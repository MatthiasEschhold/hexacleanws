package de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.usecase.out;

import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.VehicleMotionData;

public interface VehicleRepository {
    void save(Vin vin, VehicleMotionData vehicleMotionData);
}
