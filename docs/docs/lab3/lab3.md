# Mappings Between Boundaries

Currently, the _Vehicle_ is the model of the application, and it is not separated from infrastructure.
In conclusion the idea of ports and adapters is not consequently followed. The missing element for a fully decoupled
domain from infrastructure is a _mapping between these boundaries_.

---
**Mapping**

Mappings between boundaries describes a transformation of the state of a source entity model to a target entity model.
The following code snippets shows an example of different entity model, where for example the _baumuster_ of
_VehicleDto_ must be mapped on the property _modelName_ of _Vehicle_.

```java
public class Vehicle {

    public String modelName;

    public String vin;

    public Double mileage;

}
```

```java
public class VehicleDto {

    public String vehicleModel;

    public String vehicleId;

    public Double mileage;

}
```

---
**Pro Mapping**

<ul>
    <li>
        If we don't map between layers, we have to use the same model on both layers, which means that the layers will be
        tightly coupled.
    </li>
    <li> Mappings enables use to
        <ol>
            <li>reduce the amount of data from external models,</li>
            <li>implement a model in our domain language, which is easier to understand and to extend</li>
        </ol>
    </li>
</ul>

---
**Contra Mapping**

* If we do map between layers, we produce a lot of boilerplate code, which is overkill for many use cases.

---

All arguments are true. We have to consider our architecture goals for this decision. Our goals are to create
a isolated domain, and source code that expresses the domain functionality and language.
A key element to reach this is mapping. A good balance between boilerplate code and decoupling can be reached by
**simplifying** and **automating** mappings based on the so-called **_Two-Way Mapping Strategy_**.

### Data Transfer Objects Between Layers

The class-stereotype <i>Data Transfer Object</i> described data objects provided by infrastructure components. In
detail <i>Data Transfer Object</i> can be a:

* _DbEntity_
* _Event_
* _Resource_
* _Response Object_
* and so on

### Benefits of Mappings

---
**Stable Domain and Fast Adaption**

Changes to the infrastructure do not affect the domain. For example an external service changes its response model
then the changes affect only the mapper of the adapter. This single point of change enables us to
adapt fast to infrastructure changes.

In addition to that, it is possible to reduce test efforts. There are no tests of the domain needed when nothing
changed. The adapter implementation could be tested in isolation on a pure technical level, which is less complex and
cost-intensive.

---
**Evolutionary Design**

Change comes fast and unexpected. But for sure it comes! Domain-related change could arise due to

* changing behaviour,
* new requirements,
* growing business model,
* changing business model,
* new consumers,
* and so on.

Since we cannot foresee change, we must look ahead and act. On an architectural level, this means that we have to
apply **architecture** and **design** **principle** that **enables** **change**.

The idea of ports and adapters is a powerful pattern to support change based on the decoupling of domain and
infrastructure. Each of them can **grow**, **modernize** and **tested** independently.

## Output Adapter

<details>
    <summary>Coding Task 3.1</summary>
    <b>Introduce a DbEntity</b>
    <ol>
        <li>Create the class <i>VehicleDbEntity</i> and place it in the designated package</li>
        <li>Ignore framework specific annotations like discussed in the previous lab</li>
    </ol>

<details>
<summary>Java</summary>

```java

public class VehicleDbEntity {

    //id
    private String vin;

    //getter and setter
}

```
</details>

<details>
<summary>Kotlin</summary>

```kotlin

class VehicleDbEntity {
    
    //id
    var vin: String? = null

}

```

</details>

<details>
<summary>C#</summary>

```java

public class VehicleDbEntity {

    //id
    private string Vin {get; set;};

}

```

</details>

</details>

<details>
    <summary>Verify 3.1</summary>
    <b>RUN</b> DbEntity_Task_3_1
    <br/>
    <b>RUN</b> ArchitectureTest_Task_3_1
</details>

## VehicleRepository, VehicleDbEntity and Mapping between Output Adapter and Domain

<details>
<summary>Coding Task 3.2</summary>

<b>Extend the VehicleRepository</b>
<ol>
<li>
    Add the private method <i>findVehicleDbEntity</i> to <i>VehicleRepository</i> which returns a hard coded <i>VehicleDbEntity</i>
</li>
<li>
    Use <i>findVehicleDbEntity</i> in the existing public method <i>findVehicleByVin</i> and replace the hard code <i>Vehicle</i>
    creation
</li>
</ol>

<details>
<summary>Java</summary>

```java

private VehicleDbEntity findVehicleDbEntity(Vin vin){ ... }

```

</details>

<details>
<summary>Kotlin</summary>

```kotlin

private fun findVehicleDbEntity(vin: Vin): VehicleDbEntity {...}

```

</details>
<details>
<summary>C#</summary>

```java

private VehicleDbEntity FindVehicleDbEntity(Vin vin){ ... }

```
</details>

As a result you have a compiltation error.

<b>Introduce a Mapper</b>
<ol>
<li>
    Introduce the <i>VehicleToVehicleDbEntityMapper</i> with the following method and fix the compilation error.
</li>
</ol>

<details>
<summary>Java</summary>

```java
public Vehicle mapVehicleDbEntityToVehicle(VehicleDbEntity dbEntity){...}
```

</details>

<details>
<summary>Kotlin</summary>

```kotlin

fun mapVehicleDbEntityToVehicle(dbEntity: VehicleDbEntity): Vehicle{...}

```

</details>

<details>
<summary>C#</summary>

```java

public VehicleRootEntity MapVehicleDbEntityToVehicle(VehicleDbEntity dbEntity){...}

```

</details>

</details>

<details>
<summary>Verify 3.2</summary>
<b>COMMENT IN</b> method createVehicleDbEntity in class TestObjectFactory
<br/>
<b>COMMENT IN</b> method createVehicleRepository in class TestObjectFactory
<br/>
<b>RUN</b> Mapper_Task_3_2
<br/>
<b>RUN</b> OutputAdapter_Task_3_2
<br/>
<b>RUN</b> ArchitectureTest_Task_3_2

</details>

## VehicleController, VehicleResource and Mapping between Input Adapter and Domain

<details>
<summary>Coding Task 3.3</summary>
<b>Extend the VehicleController with a Resource</b>
<br/>
Change the method <i>read vehicle</i> with the <i>vin</i> as input parameter to

<details>
<summary>Java</summary>

```java

public VehicleResource readVehicle(String vin);

```

</details>

<details>
<summary>Kotlin</summary>

```java

fun readVehicle(vin: String): VehicleResource;

```

</details>

<details>
<summary>C#</summary>

```java

public VehicleResource ReadVehicle(string vin);

```

</details>

Now a compilation error occur in the <i>VehicleController</i>.

<ol>
<li>
Implement the class <i>VehicleResource</i> and,
</li>
<li>
a mapper class with the name <i>VehicleToVehicleResourceMapper</i> which uses MapStruct
</li>
</ol>

<details>
<summary>Java</summary>

Sources for MapStruct:
<ul>
    <li><a href="https://www.baeldung.com/mapstruct">MapStruct Basics</a></li>
    <li><a href="https://www.baeldung.com/mapstruct-custom-mapper">Custom Mapper with MapStruct</a></li>
    <li><a href="https://mapstruct.org/documentation/stable/reference/html/">MapStruct Reference Guide Version 1.5.3</a></li>
    <li><a href="https://mapstruct.org/community/other-resources/">Other sources</a></li>
</ul>
</details>

<details>
<summary>C#</summary>

Sources for AutoMapper:
<ul>
<li><a href="https://dotnettutorials.net/lesson/automapper-in-c-sharp/">AutoMapper Tutorial</a></li>
<li> <a href="https://docs.automapper.org/en/stable/index.html/">AutoMapper Documentation</a></li>
</ul>
</details>
</details>

<details>
<summary>Verify 3.3</summary>
<b>COMMENT IN</b> method createExpectedVehicleResource in class TestObjectFactory
<br/>
<b>RUN</b> InputAdapter_Task_3_3
<br/>
<b>RUN</b> ArchitectureTest_Task_3_3
</details>

<details>
<summary>Addtional Verification for Java</summary>
<b>RUN</b> Mapper_Task_3_3
</details>