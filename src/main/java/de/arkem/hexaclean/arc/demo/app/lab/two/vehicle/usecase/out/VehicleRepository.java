package de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.usecase.out;

import de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.domain.model.Vehicle;

public interface VehicleRepository {
    Vehicle save(Vehicle vehicle);
}
