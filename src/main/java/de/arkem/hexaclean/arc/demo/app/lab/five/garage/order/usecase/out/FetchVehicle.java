package de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.usecase.out;

import de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.domain.model.vehicle.Vehicle;

public interface FetchVehicle {
    Vehicle fetch(LicensePlate licensePlate);
}
