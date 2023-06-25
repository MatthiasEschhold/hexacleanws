package de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.masterdata;

import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.masterdata.dto.EquipmentDto;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.masterdata.dto.EquipmentListDto;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.masterdata.dto.VehicleDataDto;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.MileageUnitValue;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;

import java.util.ArrayList;
import java.util.List;

public class VehicleMasterDataServiceClient implements FetchVehicleMasterData {

    private VehicleToVehicleMasterDataDtoMapper mapper;

    private static final String VEHICLE_MODEL_DESCRIPTION_TEST_VALUE = "E30 Limousine";
    private static final String VEHICLE_MODEL_TYPE_TEST_VALUE = "3er";
    private static final String SERIAL_NUMBER_TEST_VALUE = "0123456789";
    private static final String VIN = "WP0ZZZ99ZTS392155";

    public VehicleMasterDataServiceClient(VehicleToVehicleMasterDataDtoMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public VehicleMasterData fetch(Vin vin) {
        return mapper.mapVehicleDtoToVehicleMasterData(createExpectedVehicleDto());
    }

    private VehicleDataDto createExpectedVehicleDto() {
        EquipmentListDto equipmentListDto = new EquipmentListDto();
        equipmentListDto.setEquipmentList(createEquipmentListDto());
        VehicleDataDto vehicleDto = new VehicleDataDto();
        vehicleDto.setBaumuster(VEHICLE_MODEL_TYPE_TEST_VALUE);
        vehicleDto.setBaumusterDescription(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE);
        vehicleDto.setMileageUnit(MileageUnitValue.KM.toString());
        vehicleDto.setVinOrFin(VIN);
        vehicleDto.setSerialNumber(SERIAL_NUMBER_TEST_VALUE);
        vehicleDto.setEquipmentListDto(equipmentListDto);
        return vehicleDto;
    }

    private List<EquipmentDto> createEquipmentListDto() {
        List<EquipmentDto> list = new ArrayList<>();
        list.add(new EquipmentDto("CU897", "Live Traffic Assistent"));
        list.add(new EquipmentDto("DK564", "Visual Park Assistent"));
        list.add(new EquipmentDto("KL457", "Sports Chassis M Deluxe"));
        return list;
    }
}
