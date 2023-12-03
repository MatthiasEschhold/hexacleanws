package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.adapter.out.db;

import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vin;

public class VehicleToDbEntityDbMapper {
    public VehicleDbEntity mapVehicleToDbEntity(Vin vin, VehicleMotionData vehicleMotionData) {
        VehicleDbEntity vehicleDbEntity = new VehicleDbEntity();
        vehicleDbEntity.setVin(vin.value());
        vehicleDbEntity.setLicensePlate(vehicleMotionData.licensePlate().value());
        return vehicleDbEntity;
    }
}
