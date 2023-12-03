package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle;

public record EquipmentCode(String value) {

    private static final String EQUIPMENT_CODE_PATTERN = "[A-Z]{2}[0-9]{3}";

    public EquipmentCode {
        validateEquipmentCode(value);
    }

    private void validateEquipmentCode(String value) {
        if (!isValidEquipmentCode(value)) {
            throw new IllegalStateException("equipment code is not valid");
        }
    }

    private boolean isValidEquipmentCode(String value) {
        return value != null && value.matches(EQUIPMENT_CODE_PATTERN);
    }
}
