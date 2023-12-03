package de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.adapter.out.masterdata;

import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.VehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.usecase.out.FetchVehicleMasterData;

public class VehicleMasterDataServiceClient implements FetchVehicleMasterData {

    private final VehicleMasterDataToEntityExternalApiMapper externalApiMapper;

    public VehicleMasterDataServiceClient(VehicleMasterDataToEntityExternalApiMapper externalApiMapper) {
        this.externalApiMapper = externalApiMapper;
    }

    @Override
    public VehicleMasterData fetch(Vin vin) {
        VehicleDataDto vehicleDataDto = mockExternalServiceCall(vin.value());
        return externalApiMapper.mapVehicleMasterDataToEntity(vehicleDataDto);
    }

    private VehicleDataDto mockExternalServiceCall(String vin) {
        return new VehicleDataDto();
    }
}
