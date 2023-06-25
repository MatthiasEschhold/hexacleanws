package de.arkem.hexaclean.arc.demo.app.vehicle.domain.model;

import de.arkem.hexaclean.arc.demo.app.common.Default;

import java.util.List;
import java.util.Objects;

public class Vehicle {
    public static final String EQUIPMENT_CODE_5G = "GS200";
    private Vin vin;
    private VehicleMotionData vehicleMotionData;
    private VehicleMasterData vehicleMasterData;
    private Boolean has5GSupport;

    public Vehicle(Vin vin, VehicleMotionData vehicleMotionData) {
        this.vin = vin;
        this.vehicleMotionData = vehicleMotionData;
        if (this.vin == null || this.vehicleMotionData == null) {
            throw new IllegalStateException("one or more of the properties vin or motion data are null!");
        }
    }

    @Default
    public Vehicle(Vin vin, VehicleMotionData vehicleMotionData, VehicleMasterData vehicleMasterData) {
        this(vin, vehicleMotionData);
        this.vehicleMasterData = vehicleMasterData;
        determineHas2GSupport(this.vehicleMasterData.equipmentList());
        validateVehicleMasterData();
    }

    private void determineHas2GSupport(List<Equipment> equipmentList) {
        this.has5GSupport = equipmentList.stream()
                .filter(e -> e.code().value().equals(EQUIPMENT_CODE_5G))
                .findAny()
                .isPresent();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vin, vehicle.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }

    public Vin getVin() {
        return vin;
    }

    public VehicleMotionData getVehicleMotionData() {
        return vehicleMotionData;
    }

    public VehicleMasterData getVehicleMasterData() {
        return vehicleMasterData;
    }

    public Boolean isHas5GSupport() {
        return has5GSupport;
    }

    private void validateVehicleMasterData() {
        if (this.vehicleMasterData == null) {
            throw new IllegalStateException("Vehicle master data should not be null!");
        }
    }

    public void addVehicleMasterData(VehicleMasterData vehicleMasterData) {
        this.vehicleMasterData = vehicleMasterData;
        determineHas2GSupport(this.vehicleMasterData.equipmentList());
    }
}
