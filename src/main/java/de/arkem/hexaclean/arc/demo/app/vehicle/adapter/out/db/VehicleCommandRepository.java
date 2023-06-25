package de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.db;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbCommand;

public class VehicleCommandRepository implements VehicleDbCommand {

    private VehicleToVehicleDbEntityMapper mapper;

    private static final String VIN = "WP0ZZZ99ZTS392155";
    private static final String LICENSE_PLATE_TEST_VALUE = "ES-EM 385";
    private static final double MILEAGE_TEST_VALUE = 100000;

    public VehicleCommandRepository(VehicleToVehicleDbEntityMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Vehicle save(Vehicle vehicle) {
        VehicleDbEntity savedVehicle = technicalSaveWithSqlStuff(vehicle);
        return mapper.mapVehicleDbEntityToVehicle(savedVehicle);
    }

    private VehicleDbEntity technicalSaveWithSqlStuff(Vehicle vehicle) {
        //INSERT INTO ...
        // UPDATE ...
        // jdbcRepository.save(mapper.mapVehicleToVehicleDbEntity(vehicle));
        VehicleDbEntity dbEntity = new VehicleDbEntity();
        dbEntity.setVin(VIN);
        dbEntity.setLicensePlate(LICENSE_PLATE_TEST_VALUE);
        dbEntity.setMilage(MILEAGE_TEST_VALUE);
        return dbEntity;
    }
}
