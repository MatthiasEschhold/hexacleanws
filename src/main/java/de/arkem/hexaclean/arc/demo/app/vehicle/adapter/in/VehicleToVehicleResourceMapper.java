package de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VehicleToVehicleResourceMapper {
    @Mapping(target = "vin", source = "vin.value")
    VehicleResource mapVehicleToVehicleResource(Vehicle entity);
}
