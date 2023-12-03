package de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.adapter.in.api;

import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.adapter.in.api.resource.VehicleMotionDataResource;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.adapter.in.api.resource.VehicleResource;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.adapter.in.api.resource.EquipmentResource;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.adapter.in.api.resource.VehicleMasterDataResource;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.Equipment;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.VehicleMasterData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VehicleToResourceApiMapper {
    @Mapping(source = "vin.value", target = "vin")
    @Mapping(source = "vehicleMotionData", target = "vehicleMotionData")
    @Mapping(source = "vehicleMasterData", target = "vehicleMasterData")
    VehicleResource mapVehicleToResource(Vehicle vehicle);
    @Mapping(source = "licensePlate.value", target = "licensePlate")
    VehicleMotionDataResource mapVehicleMotionDataToResource(VehicleMotionData entity);

    @Mapping(source = "equipmentList", target = "equipmentList")
    VehicleMasterDataResource mapVehicleMasterDataToResource(VehicleMasterData entity);

    @Mapping(source = "equipmentCode.value", target = "equipmentCode")
    @Mapping(source = "equipmentLabel.value", target = "equipmentLabel")
    EquipmentResource mapEquipmentToResource(Equipment entity);

}
