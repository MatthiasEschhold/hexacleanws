package de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.adapter.out.db;

import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.VehicleMotionData;

public class VehicleToEntityDbMapper {
    public VehicleMotionData mapVehicleMotionDataToEntity(VehicleDbEntity dbEntity) {
        return new VehicleMotionData(new LicensePlate(dbEntity.getLicensePlate()));
    }
}
