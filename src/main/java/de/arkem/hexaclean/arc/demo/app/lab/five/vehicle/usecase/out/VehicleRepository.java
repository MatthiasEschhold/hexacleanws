package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.usecase.out;

import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vin;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.dto.VehicleQueryResult;

public interface VehicleRepository {
    void save(Vin vin, VehicleMotionData vehicleMotionData);
    VehicleMotionData findVehicleMotionDataByVin(Vin vin);
    VehicleQueryResult findVehicleMotionDataByLicensePlate(LicensePlate licensePlate);

}
