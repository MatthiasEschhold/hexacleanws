package de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.adapter.out.masterdata;

public class VehicleDataDto {
    private String vehicleIdentificationNumber;
    private EquipmentListDto equipmentListDto;

    public String getVehicleIdentificationNumber() {
        return vehicleIdentificationNumber;
    }

    public void setVehicleIdentificationNumber(String vehicleIdentificationNumber) {
        this.vehicleIdentificationNumber = vehicleIdentificationNumber;
    }

    public EquipmentListDto getEquipmentListDto() {
        return equipmentListDto;
    }

    public void setEquipmentListDto(EquipmentListDto equipmentListDto) {
        this.equipmentListDto = equipmentListDto;
    }
}
