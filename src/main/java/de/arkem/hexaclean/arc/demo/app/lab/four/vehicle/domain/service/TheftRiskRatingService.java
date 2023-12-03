package de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.service;

import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.theft.status.HighRiskCountry;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.RegistrationCountry;

import java.util.List;

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
