package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.usecase.in;

import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vin;

public interface VehicleCommand {
    Vehicle createVehicle(Vin vin, VehicleMotionData vehicleMotionData);
}
