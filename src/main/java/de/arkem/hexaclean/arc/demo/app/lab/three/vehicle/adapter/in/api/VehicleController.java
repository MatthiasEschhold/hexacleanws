package de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.adapter.in.api;

import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.adapter.in.api.resource.VehicleResource;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.usecase.in.VehicleCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public class VehicleController {
    private final VehicleToResourceApiMapper resourceMapper;
    private final VehicleToEntityApiMapper entityWebMapper;
    private final VehicleCommand vehicleCommand;

    public VehicleController(VehicleToResourceApiMapper resourceMapper, VehicleToEntityApiMapper entityWebMapper, VehicleCommand vehicleCommand) {
        this.resourceMapper = resourceMapper;
        this.entityWebMapper = entityWebMapper;
        this.vehicleCommand = vehicleCommand;
    }

    //@GetMapping
    /*public VehicleResource readVehicle(String vin) {
        return mapper.mapVehicleToVehicleResource(vehicleQuery.findByVin(new Vin(vin)));
    }*/

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
