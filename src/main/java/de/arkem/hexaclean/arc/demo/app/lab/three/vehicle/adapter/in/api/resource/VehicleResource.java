package de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.adapter.in.api.resource;

public class VehicleResource {
    private String vin;
    private VehicleMotionDataResource vehicleMotionData;
    private VehicleMasterDataResource vehicleMasterData;

    public VehicleMasterDataResource getVehicleMasterData() {
        return vehicleMasterData;
    }

    public void setVehicleMasterData(VehicleMasterDataResource vehicleMasterData) {
        this.vehicleMasterData = vehicleMasterData;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public VehicleMotionDataResource getVehicleMotionData() {
        return vehicleMotionData;
    }

    public void setVehicleMotionData(VehicleMotionDataResource vehicleMotionData) {
        this.vehicleMotionData = vehicleMotionData;
    }
}
