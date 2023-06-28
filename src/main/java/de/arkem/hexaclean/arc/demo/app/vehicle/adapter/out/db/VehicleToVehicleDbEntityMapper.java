package de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.db;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.*;

public class VehicleToVehicleDbEntityMapper {
    public Vehicle mapVehicleDbEntityToVehicle(VehicleDbEntity dbEntity) {
        return new Vehicle(new Vin(dbEntity.getVin()),null);
    }

    public VehicleDbEntity mapVehicleToVehicleDbEntity(Vehicle vehicle) {
        VehicleDbEntity vehicleDbEntity = new VehicleDbEntity();
        return vehicleDbEntity;
    }
}
