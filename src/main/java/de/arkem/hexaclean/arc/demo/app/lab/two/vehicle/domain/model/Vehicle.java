package de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.domain.model;

import java.util.Objects;

public class Vehicle {
    private Vin vin;
    private VehicleMotionData vehicleMotionData;
    private VehicleMasterData vehicleMasterData;

    public Vehicle(Vin vin, VehicleMotionData vehicleMotionData, VehicleMasterData vehicleMasterData) {
        validateVehicle(vin, vehicleMotionData, vehicleMasterData);
        this.vin = vin;
        this.vehicleMotionData = vehicleMotionData;
        this.vehicleMasterData = vehicleMasterData;
    }

    private void validateVehicle(Vin vin, VehicleMotionData vehicleMotionData, VehicleMasterData vehicleMasterData) {
        if (isVehicleValid(vin, vehicleMotionData, vehicleMasterData)) {
            throw new IllegalStateException("vehicle is not valid");
        }
    }

    private boolean isVehicleValid(Vin vin, VehicleMotionData vehicleMotionData, VehicleMasterData vehicleMasterData) {
        return vin != null && vehicleMotionData != null && vehicleMasterData != null;
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
}
