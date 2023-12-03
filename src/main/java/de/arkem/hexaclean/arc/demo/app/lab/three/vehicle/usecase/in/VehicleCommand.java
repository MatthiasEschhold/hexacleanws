package de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.usecase.in;

import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.VehicleMotionData;

public interface VehicleCommand {
    Vehicle createVehicle(Vin vin, VehicleMotionData vehicleMotionData);
}
