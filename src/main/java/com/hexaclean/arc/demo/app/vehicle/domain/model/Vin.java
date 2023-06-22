package com.hexaclean.arc.demo.app.vehicle.domain.model;

import java.util.Objects;

public record Vin(String value) {
    public Vin {
        if(!value.matches("(?=.*\\d|=.*[A-Z])(?=.*[A-Z])[A-Z0-9]{17}")) {
            throw new IllegalStateException("Vin is not valid");
        }
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
