package de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.masterdata;

import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.masterdata.dto.VehicleDataDto;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.*;

public class VehicleToVehicleMasterDataDtoMapper {

    public VehicleMasterData mapVehicleDtoToVehicleMasterData(VehicleDataDto dto) {
        return new VehicleMasterData(
                dto.getEquipmentListDto().getEquipmentList()
                        .stream().map(e -> new Equipment(new EquipmentCode(e.getCode()), e.getLabel())).toList(),
                new VehicleModel(dto.getBaumusterDescription(), dto.getBaumuster()),
                new SerialNumber(dto.getSerialNumber()),
                new MileageUnit(MileageUnitValue.valueOf(dto.getMileageUnit())));
    }

}
