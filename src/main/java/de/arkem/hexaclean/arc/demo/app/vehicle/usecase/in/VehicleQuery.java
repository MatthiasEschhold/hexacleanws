package de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;

public interface VehicleQuery {
    Vehicle findByVin(Vin vin);

}
