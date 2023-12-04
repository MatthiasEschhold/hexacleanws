# Slicing Use Cases with the Interface Segregation Principle

_Robert C. Martin_ points out in his book _Clean Architecture_ that

<blockquote cite="https://example.com/optional-reference">
depending on something that carries baggage that
you don't need can cause you trouble that you didn't expect!
</blockquote> 

The _Interface Segregation Principle_ provides an answer to this problem. It states that broad 
interfaces should be split into specific ones so that clients only know the methods they need.

Applying the _Interface Segregation Principle_

* **removes unnecessary dependencies** to methods the consumer doesn't need,
* makes the existing **dependencies more visible**,
* **prevents** potential trouble based on **side effects** and,
* enables **extendibility** and **flexibility** 

In origin sense the _Interface Segregation Principle_ says:

---
Many client-specific interfaces increase readability and understandability compared to one general-purpose interface. 
No clients should be forced to depend on methods it does not use. In conclusion, interfaces should be separated into small 
responsibilities as minimalistic as possible.

![Variants of slicing use cases](../img/usecaseslicing.png)

Personally I do not use the option _Root Entity_. As a default I use the option _Command & Query_. When different
consumer exists and there are difference between their needs, then I recommend using the option _One Method Per
Use Case (Port)_. Also referring to the package structure variants, there is a _separation of incoming and outgoing use
cases_, which is recommended to _apply_ as _standard design principle_.

Following code examples shows different variants of slicing use cases.

**Use Cases by Root Entity**

```java

public interface VehicleUseCase {

    Vehicle readByVin(Vin vin);

    Vehicle readByLicensePlate(LicensePlate licensePlate);

    Vehicle update(Vin vin, VehicleMotionData vehicleMotionData);

    Vehicle create(Vehicle vehicle);

    void delete(Vin vin);
}
```

**Use Case by Separating Command and Query**

```java

public interface VehicleQuery {

    Vehicle readByVin(Vin vin);

    Vehicle readByLicensePlate(LicensePlate licensePlate);
}
```

```java

public interface VehicleCommand {

    Vehicle update(Vin vin, VehicleMotionData vehicleMotionData);

    Vehicle create(Vehicle vehicle);

    void delete(Vin vin);
}
```

A separation in _Command and Query_ helps to prevent, that classes grow into complex and big units of code that are
hard to understand. A good orientation for modularisation inside a _domain module_ can be found in _Command and Query_, even
when you do not plan to apply the [Command Query Segregation Principle](https://martinfowler.com/bliki/CQRS.html). 
But we can create a good foundation for such an evolution.

**One Method per Use Case (Port)**

```java
public interface ReadVehicleByVin {

    Vehicle read(Vin vin);
}
```

```java
public interface ReadVehicleByLicensePlate {

    Vehicle read(LicensePlate licensePlate);
}
```

```java
public interface CreateVehicle {

    Vehicle readByVin(Vin vin);

    Vehicle readByLicensePlate(LicensePlate licensePlate);
}
```

```java
public interface UpdateVehicle {

    Vehicle update(Vin vin, VehicleMotionData vehicleMotionData);
}
```

```java
public interface DeleteVehicle {

    void delete(Vin vib);
}
```

Even when the variant _One Method per Use Case_ is not typical Java, slicing use cases this way reduces coupling
between clients. In conclusion, the overall coupling between components of the software system will be kept low.
Coupling rises quickly and unavoidable. Due to this, we should avoid it every time when possible, especially in
fast-growing software systems for complex business domains.

Small sliced use cases allow assembling these use cases to a higher composition of functionality. Based on this,
functionality can be extended fast for new or changing business processes or user group specific requirements.

### Slicing Use Cases in Practice

There is no right way by default. It depends on complexity and specific requirements of the project. 
In practice a reasonable combination of these variants is may the best way to find a good balance between flexibility and 
simplicity in the architecture in the long term.

Let's have a look on following functional requirements. As we already know, we have the mission to build a great garage
management that is maintainable, extendable and flexible. We want to modernize existing business processes and establish
new business models. And the system now starts to live, and we can expect an evolution over the years because the
business model change over time due to changing requirements of the stakeholder as well as technical evolution, which
creates the need of modernization.
