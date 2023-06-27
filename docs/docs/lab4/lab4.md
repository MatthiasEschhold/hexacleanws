# The Domain Grows Part I

## Implement the Domain Model

![Vehicle Domain Model](../img/vehicle-domain-model.png)

<details>
<summary>Coding Task 4.1</summary>

Understand the root entity <i>Vehicle</i> and implement the missing value object according to the UML
class diagram and the validation rules described in the table below.

<details>
<summary>Value Object Validation Rules</summary>

<table>
    <tr>
        <th>Domain Object</th>
        <th>Validation Rule</th>
    </tr>
    <tr>
        <td>LicensePlate</td>
        <td><i>A-ZÖÜÄ]{1,3}-[A-ZÖÜÄ]{1,2} [1-9]{1}[0-9]{1,3}</i></td>
    </tr>
    <tr>
        <td>EquipmentCode</td>
        <td><i>[A-Z]{2}[0-9]{3}</i></td>
    </tr>
    <tr>
        <td>Mileage</td>
        <td>no negative value (mileage >= 0)</td>
    </tr>
</table>
</details>

<details>
<summary>Root Entity Validation Rules</summary>

<table>
    <tr>
        <th>Domain Object</th>
        <th>Validation Rule</th>
    </tr>
    <tr>
        <td>VehicleMotionData</td>
        <td>All fields are mandatory, all values must fulfil the validation rules</td>
    </tr>
    <tr>
        <td>Vehicle</td>
        <td>Vin, Vehicle Masterdata are mandatory</td>
    </tr>
</table>

</details>

</details>

<details>
<summary>Verify 4.1</summary>
<b>RUN</b> DomainRing_Task_4_1
<br/>
<b>RUN</b> ArchitectureTest_Task_4_1

</details>

## Extend the Input Adapter

![Vehicle Resource](../img/vehicle-resource.png)

<details>
<summary>Coding Task 4.2</summary>

Extend the <i>VehicleResource</i> like described as follows and adapt the <i>VehicleController</i> as well as 
the <i>VehicleToVehicleResourceMapper</i>.

</details>

<details>
<summary>Verify 4.2</summary>

<b>RUN</b> InputAdapter_Task_4_2
<br/>
<b>RUN</b> all architecture tests

</details>

## Introduce the VehicleMasterDataServiceClient

<details>
<summary>Coding Task 4.3 and Group Discussion</summary>

There are some constraints given by the company context. There is one central system for 
vehicle master data. This system provides the necessary master data.
<br/>
<br/>
Due to this the adapter implementation based on the classes <i>VehicleMasterDataServiceClient</i> and <i>VehicleMasterDataToVehiceDtoMapper</i> as well as
the outgoing use case (package <i>vehicle/adapter/out/dto</i> and <i>vehicle/usecase/out</i>) are introduced.

The external API returns a lot of information we do not need in our domain. This is visible in the
<i>VehicleDataDto</i> class. For example the property <i>salesRelatedInformation</i> is not needed in our domain.
Due to this we only extract the properties we defined in the
<i>VehicleMasterData</i> domain object. 

<ol>
    <li>
        Understand the architecture, code and motivation beyond. Discuss it in the group.
    </li>
    <li>
        Connect the <i>VehicleService</i> to the company vehicle master data service according to the clean architecture
principles.
    </li>
</ol>

</details>

<details>
<summary>Verify 4.3</summary>

<b>RUN</b> OutputAdapter_Task_4_3
<br/>
<b>RUN</b> all architecture tests

</details>

## Extend the Output Adapter

![Vehicle Db Entity](../img/vehicle-db-entity.png)

<details>
<summary>Coding Task 4.4</summary>

The vehicle motion data and other informations that not belongs to vehicle master data will be store in the database
of our application. This means we are owner of data and state for vehicle motion data.

Extend the <i>VehicleDbEntity</i> and the <i>VehicleToVehicleDbEntityMapper</i> as described in the diagram.

</details>

<details>
<summary>Verify 4.4</summary>
<b>RUN</b> OutputAdapter_Task_4_4
<br/>
<b>RUN</b> all architecture tests

</details>

## Extend the VehicleService

<details>
<summary>Coding Task 4.5</summary>

Extend the <i>VehicleService</i>, so that vehicle motion data will be queried from database, and 
vehicle master data will be queried from a external API.

</details>

<details>
<summary>Verify 4.5</summary>
<b>RUN</b> OutputAdapter_Task_4_5
<br/>
<b>RUN</b> all architecture tests
</details>