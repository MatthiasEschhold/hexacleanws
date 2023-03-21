# The Domain Grows Part III

## New Domain Modules

Let's have a look on the introduced domain modules _GarageOrder_ and _PartsCatalogue_. Both domain modules 
depends on the _Vehicle_ domain module.

In context of the garage order only the _license plate_ and, the _mileage_ are relevant. 
 
For the parts catalogue only the _vin_, the _vehicle model_ and, the domain value _has2GSupport_ 
are from importance.

See the garage order form for more details:

![Garage Order Form](../img/garage-order-form.png)

See also a sample explosion chart as central domain object of the parts catalogue:

![Eplosion Chart for Front Brake](../img/explosion-chart.png)

Additional the corresponding spare parts table.

![Spare Parts Table for Front Brake](../img/spare-parts-table.png)

## Design Dependencies Between Domain Modules

In a traditional data-centric approach it is common to design the application around a centric data model. 
But we learned that this leads to high coupling in the long term. In this lab we meet three alternative 
solution strategies to handle dependencies between domain modules.

## Introduce the Use Case FetchVehicleByLicensePlate

<details>
   <summary>Coding Task 6.1</summary>
   <ol>
      <li>
         Introduce a additional incoming use case in the domain module <i>Vehicle</i> with the name 
         <i>FetchVehicleByLicensePlate</i> that contains the method <i>fetchByLicensePlate</i>
      </li>
      <li>
         Implement the use case by extending the <i>VehicleQueryService</i>
      </li>
   </ol>
   
   <details>
      <summary>Java</summary>

```java
Vehicle fetchByLicensePlate(Vin vin);
```

</details>

<details>
      <summary>Kotlin</summary>

```kotlin
fun fetchByLicensePlate(vin: Vin): Vehicle;
```

   </details>

   <details>
      <summary>C#</summary>

```java
Vehicle FetchByLicensePlate(Vin vin);
```

   </details>

</details>

<details>
   <summary>Verify 6.1</summary>
   <b>RUN</b> DomainRing_Task_6_1
   <br/>
   <b>RUN</b> ArchitectureTest_Task_6_1 (Java & Kotlin)
   <br/>
   <b>RUN</b> all architecture tests (C#)
</details>

## The Adapter.Out - UseCase.In Pattern

<details>
<summary>Coding Task 6.2</summary>

Implement the Adapter.Out - UseCase.In Pattern between the domain modules <i>garage order</i> and <i>vehicle</i>.
   <ol>
      <li>
         Have a look at the outgoing use case <i>FetchVehicle</i> in <i>garage/order/usecase/out</i>
      </li>
      <li>
         Implement the output adapter with the name <i>VehicleModuleClient</i> and a mapper with the name 
         <i>VehicleToOriginVehicleMapper</i>.
      </li>
   </ol>
</details>

<details>
   <summary>Verify 6.2</summary>
   <b>RUN</b> OutputAdapter_Task_6_2
   <br/>
   <b>RUN</b> ArchitectureTest_Task_6_2 (Java & Kotlin)
   <br/>
   <b>RUN</b> all architecture tests (C#)
</details>

## Implement the Application Service Pattern

<details>
   <summary>Coding Task 6.3</summary>
Implement the <i>Application Service Pattern</i> between the domain modules <i>parts catalogue</i> and <i>vehicle</i>.
<ol>
   <li>
      Have a look at the <i>ExplosionChartApplicationService</i> in <i>parts/catalogue/appservice</i> and notice the dependency to
      <i>VehicleQuery</i> of the domain module vehicle.
   </li>
   <li>
        Implement a mapper with the name <i>VehicleToOriginVehicleMapper</i>
   </li>
   <li>
        Implement the use case <i>ExposionChartQuery</i>
   </li>
   <li>
        Use <i>VehicleQuery</i> to fetch necessary vehicle data
   </li>
</ol>

</details>

<details>
   <summary>Verify 6.3</summary>
   <b>RUN</b> ApplicationService_Task_6_3
   <br/>
   <b>RUN</b> ArchitectureTest_Task_6_3 (Java & Kotlin)
   <br/>
   <b>RUN</b> all architecture tests (C#)
</details>

##  Clean Architecture Fitness Functions

<details>
   <summary>Optional Coding Task 6.4</summary>

<ol>
   <li>
      <b>RUN</b> CleanArchitectureTest
   </li>
   <li>
      Fix the test by extending the test <i>should_check_clean_architecture_all_rings_architectural_expressive</i> 
   </li>
   <li>
      <b>RUN</b> CleanArchitectureTest again. Why did the test pass now?
   </li>
</ol>
</details>

<details>
   <summary>Java & Kotlin</summary>

```java
.adapterOutOfAdapterOutUseCaseInPattern("..garage.order.adapter.out..")
.applicationService("..parts.catalogue.appservice..")
```

</details>
