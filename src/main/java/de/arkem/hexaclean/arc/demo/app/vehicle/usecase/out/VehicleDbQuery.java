package de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;

public interface VehicleDbQuery {
    Vehicle findVehicleByVin(Vin vin);
    Vehicle findVehicleByLicensePlate(LicensePlate licensePlate);
}
