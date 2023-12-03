package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle;

public record VehicleMotionData(LicensePlate licensePlate, Mileage mileage) {
    public VehicleMotionData {
        validateVehicleMotionData(licensePlate, mileage);
    }

    private void validateVehicleMotionData(LicensePlate licensePlate, Mileage mileage) {
        if (isVehicleMotionDataValid(licensePlate, mileage)) {
            throw new IllegalStateException("vehicle motion data not valid");
        }
    }

    private boolean isVehicleMotionDataValid(LicensePlate licensePlate, Mileage mileage) {
        return licensePlate != null && mileage != null;
    }
}
