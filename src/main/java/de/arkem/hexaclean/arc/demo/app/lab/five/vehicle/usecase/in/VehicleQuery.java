package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.usecase.in;

import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vin;

public interface VehicleQuery {
    Vehicle findByVin(Vin vin);
}
