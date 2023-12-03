package de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.adapter.out.db;

import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.VehicleMotionData;

public class VehicleToEntityDbMapper {
    public VehicleMotionData mapVehicleMotionDataToEntity(VehicleDbEntity dbEntity) {
        return new VehicleMotionData(new LicensePlate(dbEntity.getLicensePlate()));
    }
}
