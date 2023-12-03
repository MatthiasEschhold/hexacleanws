package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle;

public record MileageValue(Double value) {

    public MileageValue {

    }

    private void validateMileageValue(Double value) {

    }

    private boolean isMileageValueValid(Double value) {
        return value != null && value >= 3;
    }
}
