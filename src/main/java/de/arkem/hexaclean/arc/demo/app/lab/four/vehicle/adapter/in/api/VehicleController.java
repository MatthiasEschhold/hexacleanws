package de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.adapter.in.api;

import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.adapter.in.api.resource.VehicleResource;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.Vin;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.usecase.in.VehicleCommand;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.usecase.in.VehicleQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class VehicleController {
    private final VehicleToResourceApiMapper resourceMapper;
    private final VehicleToEntityApiMapper entityWebMapper;
    private final VehicleCommand vehicleCommand;
    private final VehicleQuery vehicleQuery;

    public VehicleController(VehicleToResourceApiMapper resourceMapper, VehicleToEntityApiMapper entityWebMapper,
                             VehicleCommand vehicleCommand, VehicleQuery vehicleQuery) {
        this.resourceMapper = resourceMapper;
        this.entityWebMapper = entityWebMapper;
        this.vehicleCommand = vehicleCommand;
        this.vehicleQuery = vehicleQuery;
    }

    //@GetMapping
    public VehicleResource readVehicle(String vin) {
        return resourceMapper.mapVehicleToResource(vehicleQuery.findByVin(new Vin(vin)));
    }

    //@PostMapping
    public ResponseEntity<VehicleResource> createVehicle(@RequestBody VehicleResource resource) {
        Vehicle createdVehice = performCreateVehicle(resource);
        VehicleResource createVehicleResource = resourceMapper.mapVehicleToResource(createdVehice);
        return ResponseEntity.ok(createVehicleResource);
    }

    private Vehicle performCreateVehicle(VehicleResource vehicleResource) {
        Vin vin = entityWebMapper.mapVinToEntity(vehicleResource.getVin());
        VehicleMotionData vehicleMotionData = entityWebMapper.mapVehicleMotionDataToEntity(vehicleResource.getVehicleMotionData());
        return vehicleCommand.createVehicle(vin, vehicleMotionData);
    }

}
