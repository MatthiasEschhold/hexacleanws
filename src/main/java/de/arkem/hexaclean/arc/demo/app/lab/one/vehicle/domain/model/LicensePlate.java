package de.arkem.hexaclean.arc.demo.app.lab.one.vehicle.domain.model;

public record LicensePlate(String value) {
    private static final String LICENSE_PLATE_PATTERN = "[A-ZÖÜÄ]{1,3}-[A-ZÖÜÄ]{1,2} [1-9]{1}[0-9]{1,3}";

    public LicensePlate {
        validateLicensePlate(value);
    }

    private void validateLicensePlate(String value) {
        if (!isValidLicensePlate(value)) {
            throw new IllegalStateException("license plate is not valid");
        }
    }

    private boolean isValidLicensePlate(String value) {
        return value != null && value.matches(LICENSE_PLATE_PATTERN);
    }
}
