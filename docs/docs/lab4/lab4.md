# Ausbau mit weiteren Anforderungen und Funktionalitäten

<details>
<summary>Coding Task 5</summary>

<details>
<summary>Implementiere die Abfrage von Fahrzeudaten anhand der Vin</summary>
<li>Führe den eingehenden Use Case <i>VehicleQuery</i> mit der Schnittstelle wie unten beschrieben ein.</li>
<li>Erweitere den ausgehenden Use Case <i>VehicleRepository<i/> um die Schnittstelle wie unten beschrieben.</li>
<li>Implementiere den eingehenden Use Case im <i>VehicleService</i></li>
</details>

<details>
 <summary>Schnittstelle VehicleQuery</summary>

```java
Vehicle findByVin(Vin vin);
```
</details>

<details>
 <summary>Schnittstelle VehicleRepository</summary>

```java
VehicleMotionData findVehicleMotionDataByVin(Vin vin);
```
</details>
</details>

<details>
<summary>Coding Task 5</summary>

<details>
<summary>Erweitere den Anwendungsfall der Fahrzeuganlage</summary>
<li>Führe die ausgehenden Use Cases <i>DetectInterpolTheftStatus</i> und <i>FetchHighRiskCountries</i> mit der Schnittstelle wie unten beschrieben ein.</li>
<li>Erweitere das Domänenmodell mit den benötigen Domänenobjekten</li>
<li>Implementiere die entsprechende ausgehenden Adapter für die eingeführten ausgehenden Use Cases</li>
<li>Führe den DomainService <i>TheftRiskRatingService</i> und lege die Klasse im vorgesehenen Package ab</li>
<li>Erweitere die Implementierung der Methode <i>createVehicle</i> im <i>VehicleService</i> um die Risikobewertung und die Abfrage bei Interpol</li>
<li>Eine Abfrage bei Interpol zum Diebstahlstatus des Fahrzeugs muss ab einem Risikowert von 75 durchgeführt werden</li>
</details>

<details>
 <summary>Schnittstelle DetectInterpolTheftStatus</summary>

```java
TheftStatus detect(Vin vin, LicensePlate licensePlate);
```

```java
public record TheftStatus(TheftStatusEnum value) {

    public TheftStatus {
        validateTheftStatus(value);
    }

    private void validateTheftStatus(TheftStatusEnum value) {
        if (!isTheftStatusValid(value)) {
            throw new IllegalStateException("anti theft status not valid");
        }
    }

    private boolean isTheftStatusValid(TheftStatusEnum value) {
        return value != null;
    }
}
```

```java
public enum TheftStatusEnum {
    UNKNOWN, STOLEN, APPROVED;
}
```

</details>

<details>
 <summary>Schnittstelle FetchHighRiskCountries</summary>

```java
List<HighRiskCountry> fetch();
```

```java
public record HighRiskCountry(String value) {
    private static final String COUNTRY_CODE_PATTERN = "[A-Z]{2}-[a-z]{2}";
    public HighRiskCountry {
        validateHighRiskCountry(value);
    }

    private void validateHighRiskCountry(String value) {
        if (!isHighRiskCountryValid(value)) {
            throw new IllegalStateException("high risk country is not valid");
        }
    }

    private boolean isHighRiskCountryValid(String value) {
        return value != null && value.matches(COUNTRY_CODE_PATTERN);
    }
}
```

</details>

<details>
 <summary>Implementierung TheftRiskRatingService</summary>

```java
public class TheftRiskRatingService {

    private static final String GERMAN_LICENSE_PLATE_PATTERN = "[A-ZÖÜÄ]{1,3}-[A-ZÖÜÄ]{1,2} [1-9]{1}[0-9]{1,3}";
    private static final String FRANCE_LICENSE_PLATE_PATTERN = "[A-Z]{3}-[0-9]{3}-[A-Z]{3}";
    private static final String GERMAN_COUNTRY_CODE = "DE-de";
    private static final String FRANCE_COUNTRY_CODE = "FR-fr";

    public Integer rateTheftRisk(RegistrationCountry registrationCountry, LicensePlate licensePlate, List<HighRiskCountry> highRiskCountries) {
        Integer riskScore = 0;
        String countryCodeOfLicensePlate = detectCountryCodeOfLicensePlate(licensePlate);
        String registrationCountryCode = registrationCountry.value();
        riskScore = riskScore + detectRiskPointByLicensePlate(countryCodeOfLicensePlate) +
                detectRiskPointByRegistrationCountry(registrationCountryCode) +
                detectRiskPointHighRiskCountry(highRiskCountries, countryCodeOfLicensePlate);
        if (!countryCodeOfLicensePlate.equals(registrationCountry)) {
            riskScore = riskScore + 15;
        }
        return riskScore;
    }

    private Integer detectRiskPointHighRiskCountry(List<HighRiskCountry> highRiskCountries, String countryCode) {
        boolean isHighRiskCountry = highRiskCountries.stream().filter(highRiskCountry -> highRiskCountry.equals(countryCode)).findFirst().isPresent();
        if (isHighRiskCountry) {
            return 20;
        }
        return 0;
    }

    private Integer detectRiskPointByRegistrationCountry(String countryCode) {
        if (countryCode.equals(GERMAN_COUNTRY_CODE)) {
            return 0;
        } else if (countryCode.equals(FRANCE_COUNTRY_CODE)) {
            return 0;
        } else {
            return 15;
        }
    }

    private Integer detectRiskPointByLicensePlate(String countryCode) {
        if (countryCode.equals(GERMAN_COUNTRY_CODE)) {
            return 0;
        } else if (countryCode.equals(FRANCE_COUNTRY_CODE)) {
            return 5;
        } else {
            return 15;
        }
    }

    private String detectCountryCodeOfLicensePlate(LicensePlate licensePlate) {
        if (licensePlate.value().matches(GERMAN_LICENSE_PLATE_PATTERN)) {
            return "DE-de";
        } else if (licensePlate.value().matches((FRANCE_LICENSE_PLATE_PATTERN))) {
            return "FR-fr";
        } //... and many more
        return "";
    }

}

```
</details>
</details>
