package de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;

public interface VehicleDbCommand {
    Vehicle save(Vehicle vehicle);
}
