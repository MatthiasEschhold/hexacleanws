package de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;

public interface VehicleCommand {
    Vehicle create(Vehicle vehicle);
    Vehicle update(Vin vin, VehicleMotionData vehicleMotionData);

}
