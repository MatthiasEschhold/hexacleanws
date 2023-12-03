package de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.adapter.in.api;

import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.adapter.in.api.resource.VehicleMotionDataResource;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.Vin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VehicleToEntityApiMapper {
    @Mapping(source = "licensePlate", target = "licensePlate.value")
    VehicleMotionData mapVehicleMotionDataToEntity(VehicleMotionDataResource resource);

    @Mapping(source = "value", target = "value")
    Vin mapVinToEntity(String value);

}
