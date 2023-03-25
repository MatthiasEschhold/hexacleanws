# Implementing the Ports & Adapters Pattern

## Dependency Injection

The _Dependency Injection Pattern_ is characterized as follows:

---
_A central component, the dependency injector, manages the lifecycle of class instances and injects these instances into
several consumers._

![Dependency injection](../img/di.png)

Relevant types of dependency injection by example with java and spring:

```java

import org.springframework.beans.factory.annotation.Autowired;

public class Consumer {

    @Autowired //field injection
    private DependencyOne one;

    private DependencyTwo two;

    @Autowired // contructor injection
    public VehicleService(DependencyTwo two) {
        this.two = two;
    }

    @Autowired //method injection
    public void doSomething(DependencyThree three) {
        three.doSomething();
    }
}
```

In short, the goal of dependency injection is to **reduce the coupling between a consumer and provider class** by the
externalization of object creation and management of the object's lifecycle. So consumers can focus on the usage of
this dependency. In combination with interfaces, the consumer will be decoupled from a provider-specific implementation.

[Futher informations about dependency injection](https://martinfowler.com/articles/dipInTheWild.html)

## (Input) Adapter Ring

<details>
   <summary>Coding Task 2.1</summary>

<b>Create a HTTP Input Adapter and Connect It to the Domain</b>
<br/>
The class-stereotype <i>Controller</i> is the place to
<ul>
   <li>implement HTTP-based inbound into our application,</li>
   <li>wiring incoming use cases to execute domain functionality and,</li>
   <li>transform domain-related exceptions to HTTP status codes.</li>
</ul>

<ol>
<il>Create a <i>VehicleController</i> and place it in the designated package</il>
<il>Implement the REST endpoint <i>/vehicle/{vin}</i> and return a hard-coded vehicle object. Use following method
   signature and the below value for the vin.</il>
<il>Ignore any framework specific annotations and configurations</il>

```java

WP0ZZZ99ZTS392155

```

</ol>

<details>
   <summary>Java</summary>

```java

public Vehicle readVehicle(String vin) {...}

```

</details>

<details>
   <summary>Kotlin</summary>

```kotlin

fun readVehicle(vin: String): Vehicle {...}

```

</details>

<details>
   <summary>C#</summary>

```java

public VehicleRootEntity ReadVehicle(string vin) {...} 

```

</details>

</details>

<details>
   <summary>Coding Task 2.2</summary>

   <b>Call the Domain</b>

   <ol>
      <li>Create the incoming use case <i>VehicleQuery</i> with the method</li>
      <li>Replace the hard-coded <i>Vehicle</i> within <i>VehicleController</i> with the usage of <i>VehicleQuery</i></li>
      <li>The dependency between <i>VehicleController</i> and <i>VehicleQuery</i> should be resolved via <i>constructor injection</i></li>
      <li>Implement the incoming usecase <i>VehicleQuery</i> through <i>VehicleService</i></li>
   </ol>

<details>
   <summary>Java</summary>

```java

Vehicle findByVin(Vin vin);

```

</details>
<details>
<summary>Kotlin</summary>

```kotlin

fun findByVin(vin: Vin): Vehicle

```

</details>

<details>
<summary>C#</summary>

```java

VehicleRootEntity FindByVin(string vin) {...} 

```

</details>

</details>

<details>
<summary>Verify Lab 2</summary>


<b>RUN</b> InputAdapter_Task_2_1_2_2
<br/>
<b>RUN</b> ArchitectureTest_Task_2_1_2_2

</details>

## Dependency Inversion Principle

The dependency inversion principle says:

---
_Abstractions should not depend on details. Details should depend on abstractions._

The _VehicleService_ is a concrete implementation. This means it is a detail. Following the dependency inversion
principle, the _VehicleService_ should depend on an abstraction like an interface. 
This interface will be implemented by the provider of a functionality. As a result, there is no direct dependency on a 
specific implementation. The dependency is inverted!

![Dependency Inversion Principle](../img/dependency-inversion.png)

## (Output) Adapter Ring

<details>
   <summary>Coding Task 2.3</summary>
   <b>Introduce a Outgoing Use Case and Create a Database Adapter</b>

   The class-stereotype <i>Repository</i> is the place to
   <ul>
      <li>wire a JdbcRepository or JpaRepository,</li>
      <li>connect to a database with plain jdbc,</li>
      <li>define and execute sql statements as well as</li>
      <li>handle sql errors.</li>
   </ul>
   
   <ol>
      <li>Create the outgoing usecase <i>VehicleDbQuery</i> with the method</li>
      <li>Create the repository <i>VehicleRepository</i> and place it in the designated package</li>
      <li>The repository should implement <i>VehicleDbQuery</i> and should return a hard-coded <i>Vehicle</i> instance</li>
      <li>Replace the hard-coded <i>Vehicle</i> within <i>VehicleService</i> with the usage of <i>VehicleDbQuery</i></li>
      <li>The dependency between <i>VehicleService</i> and <i>VehicleDbQuery</i> should be resolved via <i>constructor injection</i></li>
   </ol>

<details>
   <summary>Java</summary>

```java

Vehicle findVehicleByVin(Vin vin);

```

</details>

<details>
   <summary>Kotlin</summary>

```kotlin

fun findVehicleByVin(vin: Vin): Vehicle

```
</details>

<details>
   <summary>C#</summary>

```java

VehicleRootEntity FindVehicleByVin(Vin vin) {...} 

```

</details>

</details>

<details>
   <summary>Verify 2.3</summary>
   <b>RUN</b> OutputAdapter_Task_2_3
   <br/>
   <b>RUN</b> ArchitectureTest_Task_2_3
</details>

<details>
   <summary>Optional Questions</summary>

For dealing with persistence aspects spring-data-jpa or spring-data-jdbc uses annotations like
<i>@Entity</i>, <i>@Table</i>, <i>@Id</i>, <i>@Column</i>, etc. Often this concepts need also an empty constructor as
well as setter and getters for all properties.

```java

@Table("vehicle")  //jdbc
@Entity //jpa
public class Vehicle {

    @Column("vin")
    @Id
    private Vin vin;

    //...

    public Vehicle() {
    }

    public Vehicle(Vin vin) {
        //...
    }

    //getter and setter
}

```
<ol>
   <li>
      Regarding the above code example answer following questions:
      <ol>
         <li>Is the domain object <i>Vehicle</i> decoupled from infrastructure aspects?</li>
         <li>Is it possible to ensure a valid creation of the domain object like implemented in Lab 1?</li>
         <li>Is there fully control that the domain object state stays valid over the lifetime of the object?</li>
      </ol>
   </li>
   <li>
      Is a value object a good structure for a relational database? What are benefits of a value object like the <i>Vin</i>?
   </li>
   <li>
      How would you describe the relationship between dependency inversion and dependency injection?
   </li>
   <li>
      How would you describe the single responsibility principles for the following classes? Make two or three bullet
      points.
      <ul>
         <li><i></i>VehicleController</i>,</li>
         <li><i>VehicleService</i>,</li>
         <li><i>VehicleRepository</i> and</li>
         <li><i>Vehicle</i></li>
      </ul>
      <details>
         <summary>Example</summary>
         The responsibility of <i>VehicleController</i> with the stereoytpe <i>Controller</i> is:
         <ul>
            <li>...</li>
            <li>...</li>
            <li>...</li>
         </ul>
      </details>
   </li>
</ol>