package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.adapter.out.masterdata;

import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vin;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.VehicleMasterData;

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
