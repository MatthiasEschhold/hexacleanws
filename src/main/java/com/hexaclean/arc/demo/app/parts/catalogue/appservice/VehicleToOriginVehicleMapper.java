package com.hexaclean.arc.demo.app.parts.catalogue.appservice;

import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.Vehicle;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.VehicleModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper()
public interface VehicleToOriginVehicleMapper {

    @Mapping(source = "vin.value", target = "vin")
    @Mapping(source = "has2GSupport", target = "has2GSupport")
    @Mapping(source = "vehicleMasterData.vehicleModel", target = "vehicleModel")
    Vehicle mapOriginVehicleToVehicle(com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle origin);

    @Mapping(source = "modelDescription", target = "modelDescription")
    @Mapping(source = "modelType", target = "modelType")
    VehicleModel mapOriginVehicleModelToVehicleModel(com.hexaclean.arc.demo.app.vehicle.domain.model.VehicleModel vehicleModel);
}
