package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle;

public record VehicleModel(String value) {
    public VehicleModel {
        validateVehicleModel(value);
    }

    private void validateVehicleModel(String value) {
        if (!isValidVehicleModel(value)) {
            throw new IllegalStateException("equipment label is not valid");
        }
    }

    private boolean isValidVehicleModel(String value) {
        return value != null && !value.isBlank();
    }
}