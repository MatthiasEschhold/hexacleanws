package de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model;

public record VehicleMotionData(LicensePlate licensePlate) {
    public VehicleMotionData {
        validateVehicleMotionData(licensePlate);
    }

    private void validateVehicleMotionData(LicensePlate licensePlate) {
        if (isVehicleMotionDataValid(licensePlate)) {
            throw new IllegalStateException("vehicle motion data not valid");
        }
    }

    private boolean isVehicleMotionDataValid(LicensePlate licensePlate) {
        return licensePlate != null;
    }
}
