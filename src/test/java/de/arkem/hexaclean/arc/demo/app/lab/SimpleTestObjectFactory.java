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

/*
    protected VehicleResource createExpectedVehicleResource() {
        VehicleResource resource = new VehicleResource();
        resource.setVin(VIN);
        resource.setLicensePlate(LICENSE_PLATE_TEST_VALUE);
        resource.setMileage(Double.valueOf(MILEAGE_TEST_VALUE));
        resource.setVehicleModelType(VEHICLE_MODEL_TYPE_TEST_VALUE);
        resource.setVehicleModelName(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE);
        resource.setMileageUnit(MileageUnitValue.KM.toString());
        resource.setVin(VIN);
        resource.setSerialNumber(SERIAL_NUMBER_TEST_VALUE);
        resource.setEquipmentList(createEquipmentList().stream().map(this::mapToEquipmentResource).collect(Collectors.toList()));
        return resource;
    }


    protected VehicleDataDto createExpectedVehicleDto() {
        VehicleDataDto vehicleDto = new VehicleDataDto();
        vehicleDto.setBaumuster(VEHICLE_MODEL_TYPE_TEST_VALUE);
        vehicleDto.setBaumusterDescription(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE);
        vehicleDto.setMileageUnit(MileageUnitValue.KM.toString());
        vehicleDto.setVinOrFin(VIN);
        vehicleDto.setSerialNumber(SERIAL_NUMBER_TEST_VALUE);
        return vehicleDto;
    }

    protected Vehicle createExpectedVehicle() {
        Vehicle vehicle = new Vehicle(new Vin(VIN),
                createExpectedVehicleMotionData());
        VehicleMasterData masterData = createExpectedVehicleMasterData();
        vehicle.addVehicleMasterData(masterData);
        return vehicle;
    }



    protected List<Equipment> createEquipmentListHas2G() {
        List<Equipment> equipmentList = createEquipmentListDto().stream().map(e -> new Equipment(new EquipmentCode(e.getCode()), e.getLabel()))
                .collect(Collectors.toList());
        equipmentList.add(new Equipment(new EquipmentCode("GS200"), "2GSupportAdapter"));
        return equipmentList;
    }



    protected VehicleMotionDataResource createExpectedVehicleMotionDataResource() {
        VehicleMotionDataResource resource = new VehicleMotionDataResource();
        resource.setLicensePlate(LICENSE_PLATE_TEST_VALUE);
        resource.setMileage(MILEAGE_TEST_VALUE);
        return resource;
    }

    protected VehicleMasterData createExpectedVehicleMasterData() {
        return new VehicleMasterData(
                new VehicleModel(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE, VEHICLE_MODEL_TYPE_TEST_VALUE),
                new SerialNumber(SERIAL_NUMBER_TEST_VALUE), new MileageUnit(MileageUnitValue.KM), createEquipmentList());
    }

    protected VehicleMasterData createExpectedVehicleMasterDataHas2G() {
        return new VehicleMasterData(
                new VehicleModel(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE, VEHICLE_MODEL_TYPE_TEST_VALUE),
                new SerialNumber(SERIAL_NUMBER_TEST_VALUE), new MileageUnit(MileageUnitValue.KM), createEquipmentListHas2G());
    }


    */

}
