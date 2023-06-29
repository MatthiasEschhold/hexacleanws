package de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in;

import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.resource.EquipmentResource;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleMotionDataResource;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface VehicleToVehicleResourceMapper {

    @Mapping(source = "mileageUnit", target = "vehicleMasterData.mileageUnit", qualifiedByName = "mapToMileageUnit")
    @Mapping(source = "vehicleModelName", target = "vehicleMasterData.vehicleModel.modelDescription")
    @Mapping(source = "vehicleModelType", target = "vehicleMasterData.vehicleModel.modelType")
    @Mapping(source = "serialNumber", target = "vehicleMasterData.serialNumber.value")
    @Mapping(source = "vin", target = "vin.value")
    @Mapping(source = "equipmentList", target = "vehicleMasterData.equipmentList")
    Vehicle mapVehicleResourceToVehicle(VehicleResource resource);

    @Mapping(source = "description", target = "description")
    @Mapping(source = "code", target = "code.value")
    Equipment mapEquipmentResourceToEquipment(EquipmentResource resource);

    @Mapping(source = "licensePlate", target = "licensePlate.value")
    @Mapping(source = "mileage", target = "mileage.value")
    VehicleMotionData mapVehicleResourceToVehicleMotionData(VehicleMotionDataResource resource);

    @Named("mapToMileageUnit")
    static MileageUnit mapToMileageUnit(String mileageUnit) {
        return new MileageUnit(MileageUnitValue.valueOf(mileageUnit));
    }

    @Mapping(target = "mileageUnit", source = "vehicleMasterData.mileageUnit", qualifiedByName = "mapToMileageUnitPrimitive")
    @Mapping(target = "vehicleModelName", source = "vehicleMasterData.vehicleModel.modelDescription")
    @Mapping(target = "vehicleModelType", source = "vehicleMasterData.vehicleModel.modelType")
    @Mapping(target = "serialNumber", source = "vehicleMasterData.serialNumber.value")
    @Mapping(target = "vin", source = "vin.value")
    @Mapping(target = "equipmentList", source = "vehicleMasterData.equipmentList")
    VehicleResource mapVehicleToVehicleResource(Vehicle entity);


    @Mapping(target = "description", source = "description")
    @Mapping(target = "code", source = "code.value")
    EquipmentResource mapEquipmentResourceToEquipment(Equipment equipment);

    @Named("mapToMileageUnitPrimitive")
    static String mapToMileageUnitPrimitive(MileageUnit mileageUnit) {
        return mileageUnit.value().toString();
    }
}
