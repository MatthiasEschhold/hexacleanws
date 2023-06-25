package de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;

public class VehicleToVehicleDbEntityMapper {
    public Vehicle mapVehicleDbEntityToVehicle(VehicleDbEntity dbEntity){
        return new Vehicle(new Vin(dbEntity.getVin()));
    }

}
