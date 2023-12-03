package de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.domain.model;

import java.util.Objects;

public record Vin(String value) {
    private static final String VIN_PATTERN = "(?=.*\\d|=.*[A-Z])(?=.*[A-Z])[A-Z0-9]{17}";

    public Vin {
        validateVin(value);
    }

    private void validateVin(String value) {
        if (!isValidVin(value)) {
            throw new IllegalStateException("vin is not valid");
        }
    }

    private boolean isValidVin(String value) {
        return value != null && value.matches(VIN_PATTERN);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vin vin = (Vin) o;
        return Objects.equals(value, vin.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
