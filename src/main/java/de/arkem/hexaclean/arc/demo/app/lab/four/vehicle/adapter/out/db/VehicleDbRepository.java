package de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.adapter.out.db;

import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.Vin;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.usecase.out.VehicleRepository;

public class VehicleDbRepository implements VehicleRepository {

    private final VehicleToDbEntityDbMapper dbEntityMapper;
    private final VehicleToEntityDbMapper entityMapper;
    private final VehicleCrudRepository crudRepository;

    public VehicleDbRepository(VehicleToDbEntityDbMapper dbEntityMapper, VehicleToEntityDbMapper entityMapper, VehicleCrudRepository crudRepository) {
        this.dbEntityMapper = dbEntityMapper;
        this.entityMapper = entityMapper;
        this.crudRepository = crudRepository;
    }

    @Override
    public void save(Vin vin, VehicleMotionData vehicleMotionData) {
        crudRepository.save(dbEntityMapper.mapVehicleToDbEntity(vin, vehicleMotionData));
    }

    @Override
    public VehicleMotionData findVehicleMotionDataByVin(Vin vin) {
        return  findVehicleMotionDataMock();
    }

    private VehicleMotionData findVehicleMotionDataMock() {
        return new VehicleMotionData(new LicensePlate("ES-EL 0815"));
    }
}
