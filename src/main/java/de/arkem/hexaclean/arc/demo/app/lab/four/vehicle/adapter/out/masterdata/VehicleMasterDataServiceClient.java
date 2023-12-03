package de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.adapter.out.masterdata;

import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.VehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.Vin;

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
