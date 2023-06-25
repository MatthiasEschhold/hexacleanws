package de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery;

public class VehicleRepository implements VehicleDbQuery {

    private final VehicleToVehicleDbEntityMapper mapper;

    public VehicleRepository(VehicleToVehicleDbEntityMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Vehicle findVehicleByVin(Vin vin) {
        return mapper.mapVehicleDbEntityToVehicle(findVehicleDbEntity(vin));
    }

    private VehicleDbEntity findVehicleDbEntity(Vin vin){
        VehicleDbEntity vehicleDbEntity = new VehicleDbEntity();
        vehicleDbEntity.setVin(vin.value());
        return vehicleDbEntity;
    }

}
