package de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in;

import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;

public class VehicleController {

    private final VehicleQuery vehicleQuery;
    private final VehicleToVehicleResourceMapper mapper;

    public VehicleController(VehicleQuery vehicleQuery, VehicleToVehicleResourceMapper mapper) {
        this.vehicleQuery = vehicleQuery;
        this.mapper = mapper;
    }

    public VehicleResource readVehicle(String vin) {
        return mapper.mapVehicleToVehicleResource(vehicleQuery.findByVin(new Vin(vin)));
    }

}
