# Adapter Ring - Implementierung des Ports & Adapters Pattern

##  Input Adapter

<details>
   <summary>Coding Task 3</summary>

<b>Erstelle einen Input Adapter für den eingehenden Use Case</b>
<br/>
<ol>
<li>Erstelle das Package <i>adapter.in</i> im Package <i>vehicle</i></li>
<li>Erstelle den Controller <i>VehicleController</i> und lege die Klasse im vorhergesehenen Package ab</li>
<li>Implementiere eine Methode zur Anlage eines Fahrzeugs und nutze hier den Use Case <i>VehicleCommand</i></li>
<li>Hierfür muss die DTO <i>VehicleResource</i> (siehe Vorlage) und ein Mapper (<i>VehicleWebMapper</i>) eingeführt werden</li>.
<li>Ignoriere Details des Frameworks und des REST Architekturstils bei der Implementierung</li>

</ol>


<details>
      <summary>VehicleResource</summary>

   ```java
public class VehicleResource {
    
    private String vin;
    private VehicleMotionDataResource vehicleMotionData;
    private VehicleMasterDataResource vehicleMasterData;

    public VehicleMasterDataResource getVehicleMasterData() {
        return vehicleMasterData;
    }

    public void setVehicleMasterData(VehicleMasterDataResource vehicleMasterData) {
        this.vehicleMasterData = vehicleMasterData;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public VehicleMotionDataResource getVehicleMotionData() {
        return vehicleMotionData;
    }

    public void setVehicleMotionData(VehicleMotionDataResource vehicleMotionData) {
        this.vehicleMotionData = vehicleMotionData;
    }
}

   ```
   </details>

</details>

## Output Adapter

<details>
   <summary>Coding Task 4</summary>

<b>Erstelle die Output Adapter für die ausgehenden Use Cases</b>
<br/>
<ol>
<li>Erstelle das Package <i>adapter.out</i> im Package <i>vehicle</i></li>
<li>Erstelle das Datenbank Repository <i>VehicleDbRepository</i> und lege die Klasse im vorhergesehenen Package ab</li>
<li>Implementiere den Use Case <i>VehicleRepository</i></li>
<li>Führe die DTO <i>VehicleDbEntity</i> (siehe Vorlage) und ein Mapper (<i>VehicleDbMapper</i>) eingeführt werden</li>.
<li>Ignoriere Details des Frameworks bei der Implementierung</li>

</ol>

<details>
      <summary>VehicleDbEntity</summary>

   ```java
public class VehicleDbEntity {

    private String vin;
    private String licensePlate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}

   ```
   </details>

</details>
