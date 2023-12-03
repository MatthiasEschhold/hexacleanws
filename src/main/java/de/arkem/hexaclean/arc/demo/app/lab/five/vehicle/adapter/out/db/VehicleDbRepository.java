package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.adapter.out.db;

import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.*;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.dto.VehicleQueryResult;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.usecase.out.VehicleRepository;

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
        return findVehicleMotionDataMock();
    }

    @Override
    public VehicleQueryResult findVehicleMotionDataByLicensePlate(LicensePlate licensePlate) {
        return new VehicleQueryResult(new Vin(""), findVehicleMotionDataMock());
    }

    private VehicleMotionData findVehicleMotionDataMock() {
        return new VehicleMotionData(new LicensePlate("ES-EL 0815"),
                new Mileage(MileageUnit.KM, new MileageValue(14000.00)));
    }

}
