package de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model;

public record EquipmentLabel(String value) {
    public EquipmentLabel {
        validateEquipmentLabel(value);
    }

    private void validateEquipmentLabel(String value) {
        if (!isValidEquipmentLabel(value)) {
            throw new IllegalStateException("equipment label is not valid");
        }
    }

    private boolean isValidEquipmentLabel(String value) {
        return value != null && !value.isBlank();
    }
}
