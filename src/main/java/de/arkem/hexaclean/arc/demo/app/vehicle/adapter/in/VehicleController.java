package de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in;

import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleMotionDataResource;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleCommand;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public class VehicleController {

    private final VehicleQuery vehicleQuery;
    private final VehicleToVehicleResourceMapper mapper;
    private final VehicleCommand vehicleCommand;
    public VehicleController(VehicleQuery vehicleQuery, VehicleToVehicleResourceMapper mapper, VehicleCommand vehicleCommand) {
        this.vehicleQuery = vehicleQuery;
        this.mapper = mapper;
        this.vehicleCommand = vehicleCommand;
    }

    //@GetMapping
    public VehicleResource readVehicle(String vin) {
        return mapper.mapVehicleToVehicleResource(vehicleQuery.findByVin(new Vin(vin)));
    }

    //@PutMapping
    public VehicleResource updateVehicle(@PathVariable("vin") String vin, @RequestBody VehicleMotionDataResource resource) {
        VehicleMotionData vehicleMotionData = mapper.mapVehicleResourceToVehicleMotionData(resource);
        Vehicle updatedVehicle = vehicleCommand.update(new Vin(vin), vehicleMotionData);
        return mapper.mapVehicleToVehicleResource(updatedVehicle);
    }

    //@PostMapping
    public VehicleResource createVehicle(@RequestBody VehicleResource resource) {
        Vehicle createdVehice = vehicleCommand.create(mapper.mapVehicleResourceToVehicle(resource));
        return mapper.mapVehicleToVehicleResource(createdVehice);
    }

}
