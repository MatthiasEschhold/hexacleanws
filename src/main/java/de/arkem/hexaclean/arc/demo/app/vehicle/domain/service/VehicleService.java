package de.arkem.hexaclean.arc.demo.app.vehicle.domain.service;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;

public class VehicleService {

    public Vehicle findByVin(Vin vin) {
        return new Vehicle(vin);
    }

}
