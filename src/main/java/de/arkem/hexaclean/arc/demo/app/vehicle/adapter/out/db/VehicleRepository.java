package de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.db;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery;

public class VehicleRepository implements VehicleDbQuery {

    private static final String VIN = "WP0ZZZ99ZTS392155";
    private static final String LICENSE_PLATE_TEST_VALUE = "ES-EM 385";
    private static final double MILEAGE_TEST_VALUE = 100000;
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
