package de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.usecase.in;

import de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.domain.model.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.domain.model.Vin;

public interface VehicleCommand {
    Vehicle createVehicle(Vin vin, VehicleMotionData vehicleMotionData);
}
