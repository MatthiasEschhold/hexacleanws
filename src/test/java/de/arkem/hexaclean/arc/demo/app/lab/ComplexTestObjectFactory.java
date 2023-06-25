package de.arkem.hexaclean.arc.demo.app.lab;

import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.resource.EquipmentResource;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.masterdata.dto.EquipmentDto;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static de.arkem.hexaclean.arc.demo.app.lab.SimpleTestObjectFactory.createExpectedVehicleMotionData;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.*;

public class ComplexTestObjectFactory {

    public static VehicleMasterData createExpectedVehicleMasterDataHas5G() {
        return new VehicleMasterData(
                createEquipmentListHas5G(),
                new VehicleModel(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE, VEHICLE_MODEL_TYPE_TEST_VALUE),
                new SerialNumber(SERIAL_NUMBER_TEST_VALUE), new MileageUnit(MileageUnitValue.KM));
    }

    private static List<Equipment> createEquipmentListHas5G() {
        List<Equipment> equipmentList = createEquipmentListDto().stream().map(e -> new Equipment(new EquipmentCode(e.getCode()), e.getLabel()))
                .collect(Collectors.toList());
        equipmentList.add(new Equipment(new EquipmentCode("GS200"), "5GSupportAdapter"));
        return equipmentList;
    }

    public static VehicleResource createExpectedVehicleResource() {
        VehicleResource resource = new VehicleResource();
        resource.setVin(VIN);
        resource.setLicensePlate(LICENSE_PLATE_TEST_VALUE);
        resource.setMileage(Double.valueOf(MILEAGE_TEST_VALUE));
        resource.setVehicleModelType(VEHICLE_MODEL_TYPE_TEST_VALUE);
        resource.setVehicleModelName(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE);
        resource.setMileageUnit(MileageUnitValue.KM.toString());
        resource.setVin(VIN);
        resource.setSerialNumber(SERIAL_NUMBER_TEST_VALUE);
        resource.setEquipmentList(createEquipmentList().stream().map(e -> ComplexTestObjectFactory.mapToEquipmentResource(e)).collect(Collectors.toList()));
        return resource;
    }

    public static Vehicle createExpectedVehicle() {
        return new Vehicle(new Vin(VIN), createExpectedVehicleMotionData(), createExpectedVehicleMasterData());
    }

    public static VehicleMasterData createExpectedVehicleMasterData() {
        return new VehicleMasterData(
                createEquipmentList(),
                new VehicleModel(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE, VEHICLE_MODEL_TYPE_TEST_VALUE),
                new SerialNumber(SERIAL_NUMBER_TEST_VALUE),
                new MileageUnit(MileageUnitValue.KM));
    }

    private static EquipmentResource mapToEquipmentResource(Equipment equipment) {
        EquipmentResource resource = new EquipmentResource();
        resource.setDescription(equipment.description());
        resource.setCode(equipment.code().value());
        return resource;
    }

    private static List<Equipment> createEquipmentList() {
        return createEquipmentListDto().stream().map(e -> new Equipment(new EquipmentCode(e.getCode()), e.getLabel()))
                .collect(Collectors.toList());
    }

    private static List<EquipmentDto> createEquipmentListDto() {
        List<EquipmentDto> list = new ArrayList<>();
        list.add(new EquipmentDto("CU897", "Live Traffic Assistent"));
        list.add(new EquipmentDto("DK564", "Visual Park Assistent"));
        list.add(new EquipmentDto("KL457", "Sports Chassis M Deluxe"));
        return list;
    }

}
