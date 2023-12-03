package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle;

public record Mileage(MileageUnit mileageUnit, MileageValue mileageValue) {
    public Mileage {
        validateMileage(mileageUnit, mileageValue);
    }

    private void validateMileage(MileageUnit mileageUnit, MileageValue mileageValue) {
        if (isMileageValid(mileageUnit, mileageValue)) {
            throw new IllegalStateException("Mileage should not be negative");
        }
    }

    private boolean isMileageValid(MileageUnit mileageUnit, MileageValue mileageValue) {
        return mileageUnit != null && mileageValue != null;
    }
}
