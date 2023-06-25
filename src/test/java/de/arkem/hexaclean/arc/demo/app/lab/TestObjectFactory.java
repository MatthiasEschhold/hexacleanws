package de.arkem.hexaclean.arc.demo.app.lab;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;

import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.VIN;

public class TestObjectFactory {

    public static Vehicle createExpectedVehicle() {
        return new Vehicle(new Vin(VIN));
    }
}
