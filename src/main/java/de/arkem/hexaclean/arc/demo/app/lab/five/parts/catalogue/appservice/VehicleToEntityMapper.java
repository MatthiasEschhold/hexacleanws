package de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.appservice;

import de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.domain.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VehicleToEntityMapper {

    @Mapping(source = "vin.value", target = "vin")
    @Mapping(source = "vehicleMasterData.vehicleModel.value", target = "vehicleModel")
    Vehicle mapToEntity(de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vehicle origin);
}
