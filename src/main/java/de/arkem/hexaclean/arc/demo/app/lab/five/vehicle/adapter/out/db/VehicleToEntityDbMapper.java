package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.adapter.out.db;

import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.*;

public class VehicleToEntityDbMapper {
    public VehicleMotionData mapVehicleMotionDataToEntity(VehicleDbEntity dbEntity) {
        return new VehicleMotionData(new LicensePlate(dbEntity.getLicensePlate()),
                new Mileage(MileageUnit.valueOf(dbEntity.getMileageUnit()),
                        new MileageValue(dbEntity.getMileage())));
    }
}
