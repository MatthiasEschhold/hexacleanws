package de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;

public interface FetchVehicleByLicensePlate {
    Vehicle fetchByLicensePlate(LicensePlate licensePlate);
}
