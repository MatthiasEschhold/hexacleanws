package de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.adapter.out.masterdata;

import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.Equipment;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.EquipmentCode;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.EquipmentLabel;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.VehicleMasterData;

import java.util.List;
import java.util.stream.Collectors;

public class VehicleMasterDataToEntityExternalApiMapper {
    public VehicleMasterData mapVehicleMasterDataToEntity(VehicleDataDto resource) {
        List<Equipment> equipmentList = resource.getEquipmentListDto().getList()
                .stream()
                .map(this::createEquipment)
                .collect(Collectors.toList());
        return new VehicleMasterData(equipmentList);
    }

    private Equipment createEquipment(EquipmentDto dto) {
        return new Equipment(new EquipmentCode(dto.getCode()), new EquipmentLabel(dto.getName()));
    }
}
