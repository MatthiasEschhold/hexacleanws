package de.arkem.hexaclean.arc.demo.app.lab;

import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.resource.EquipmentResource;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleDbEntity;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleRepository;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleToVehicleDbEntityMapper;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.masterdata.dto.EquipmentDto;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.*;

public class SimpleTestObjectFactory {

    public static Vehicle createExpectedVehicle() {
        return new Vehicle(new Vin(VIN), createExpectedVehicleMotionData());
    }

    public static VehicleDbEntity createVehicleDbEntity() {
        VehicleDbEntity dbEntity = new VehicleDbEntity();
        dbEntity.setVin(VIN);
        return dbEntity;
    }

    // comment in for lab 3.2
    public static VehicleRepository createVehicleRepository() {
        return new VehicleRepository(new VehicleToVehicleDbEntityMapper());
    }

    //comment in for lab 3.3
    public static VehicleResource createExpectedVehicleResource() {
        VehicleResource resource = new VehicleResource();
        resource.setVin(VIN);
        return resource;
    }

    //comment in for lab 4.1
    public static VehicleMotionData createExpectedVehicleMotionData() {
        //return null;
        return new VehicleMotionData(new LicensePlate(LICENSE_PLATE_TEST_VALUE),
                new Mileage(MILEAGE_TEST_VALUE));
    }

}
