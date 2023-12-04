# Domain Ring und Use Case Ring

## Domain Model

<details>
  <summary>Coding Task 1</summary>

<b>Erstellung des Domänenmodell für Vehicle</b>
<br/>
<ol>
   <li>Implementiere das dargestellte Domänenmodell <i>Vehicle</i></li>
   <li><i>Vehicle</i> ist die Root Entity des Domänenmodell. Implementiere die andere Domänenobjekte als <i>Value Object</i>.</li>
   <li>Erstelle das Package <i>vehicle</i>> und innerhalb <i>vehicle</i> die Package-Struktur <i>domain.service</i></li>
   <li>Berücksichtige dabei folgende Validierungsregeln der Domänenobjekte</li>
</ol>

![Vehicle Domain Model](../img/vehicle-domain-model.png)

</details>

<details>
   <summary>Value Object Validation Rules</summary>

   <table>
       <tr>
           <th>Domain Object</th>
           <th>Validation Rule</th>
       </tr>
       <tr>
           <td>Vehicle</td>
           <td>Alle Eigenschaften muss vorhanden und valide sein.</td>
       </tr>
       <tr>
           <td>VIN</td>
           <td>siehe Vin Regex Pattern</td>
       </tr>
       <tr>
           <td>LicensePlate</td>
           <td>siehe LicensePlate Regex Pattern</td>
       </tr>
       <tr>
           <td>Mileage</td>
           <td>no negative value (mileage >= 0)</td>
       </tr>
       <tr>
           <td>EquipmentCode</td>
           <td>siehe EuqipmentCode Pattern</td>
       </tr>
       <tr>
           <td>Alle anderen Domänenobjekte</td>
           <td>Kein Nullwerte, keine leeren oder blank Strings</td>
       </tr>
   </table>
</details>

   <details>
     <summary>VIN Regex Pattern</summary>
   
   ```java
   
   // examples
   // WP0ZZZ99ZTS392155
   // WBAOLZ99ZTS349156
   
   "(?=.*\\d|=.*[A-Z])(?=.*[A-Z])[A-Z0-9]{17}"
   
   ```
   </details>

   <details>
     <summary>LicensePlate Regex Pattern</summary>
   
   ```java
    "[A-ZÖÜÄ0-9]{1,5}[-]{0,1}[A-ZÖÜÄ0-9]{0,10}[-]{0,1}[A-ZÖÜÄ0-9]{0,4}""[A-ZÖÜÄ0-9]{1,5}[-]{0,1}[A-ZÖÜÄ0-9]{0,10}[-]{0,1}[A-ZÖÜÄ0-9]{0,4}"  
   ```
   </details>

   <details>
     <summary>EquipmentCode Pattern</summary>

   ```java
   
   // examples
   // WP0ZZZ99ZTS392155
   // WBAOLZ99ZTS349156
   
   "(?=.*\d|=.*[A-Z])(?=.*[A-Z])[A-Z0-9]{17}"
   
   ```
   </details>

<details>
  <summary>Verify Task 1.1</summary>
   <b>RUN</b> DomainRing_Task_1_1
   <br/>
   <b>RUN</b> ArchitectureTest_Task_1_1
</details>

## Domain Service und Use Cases

<details>
   <summary>Coding Task 2</summary>
   <b>Erstelle den DomainService für die Root Entity  <i>Vehicle</i></b>
   <br/>
   <ol>
      <li>Erstelle das Package <i>domain.service</i> im Package <i>vehicle</i></li>
      <li>Erstelle die Klasse <i>VehicleService</i> im vorgesehenen Package</li>
      <li>Erstelle die Packages <i>usecase.in</i> und <i>usecase.out</i> im Package <i>vehicle</i></li>
      <li>Erstelle den eingehenden Use Case <i>VehicleCommand</i> im dafür vorgesehenen Package mit der Schnittstelle <i>createVehicle</i></li>
      <li>Erstelle die ausgehenden Use Cases <i>VehicleRepository</i> und <i>FetchVehicleMasterData</i> im dafür vorgesehenen Package mit den dafür vorgesehenen Schnittstellen</li>
      <li>Implementiere den Anwendungsfall <i>createVehicle</i> im <i>VehicleService</i></li>
   </ol>

   </details>
   
   <details>
      <summary>Schnittstelle VehicleCommand</summary>

   ```java
   Vehicle createVehicle(Vin vin, VehicleMotionData vehicleMotionData);
   ```
   </details>

   <details>
      <summary>Schnittstelle VehicleRepository</summary>

   ```java
   Vehicle save(Vehicle vehicle);
   ```
   </details>

   <details>
      <summary>Schnittstelle FetchVehicleMasterData</summary>

   ```java
   VehicleMasterData fetch(Vin vin);
   ```
   </details>


<details>
  <summary>Verify Task 1.2</summary>
   <b>RUN</b> DomainRing_Task_1_2
   <br/>
   <b>RUN</b> ArchitectureTest_Task_1_2
</details>