package de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle;

import java.util.List;

public record VehicleMasterData(List<Equipment> equipmentList, RegistrationCountry registrationCountry) {

    public VehicleMasterData {
        validateVehicleMasterData(equipmentList, registrationCountry);
    }

    private void validateVehicleMasterData(List<Equipment> equipmentList, RegistrationCountry registrationCountry) {
        if (isVehicleMasterDataValid(equipmentList, registrationCountry)) {
            throw new IllegalStateException("equipment list is not valid");
        }
    }

    private boolean isVehicleMasterDataValid(List<Equipment> equipmentList, RegistrationCountry registrationCountry) {
        return equipmentList != null && !equipmentList.isEmpty() && registrationCountry != null;
    }

}
