package de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.theft.status;

public record TheftStatus(TheftStatusEnum value) {

    public TheftStatus {
        validateTheftStatus(value);
    }

    private void validateTheftStatus(TheftStatusEnum value) {
        if (!isTheftStatusValid(value)) {
            throw new IllegalStateException("anti theft status not valid");
        }
    }

    private boolean isTheftStatusValid(TheftStatusEnum value) {
        return value != null;
    }
}
