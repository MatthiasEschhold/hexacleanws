package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle;

import java.util.List;

public record VehicleMasterData(List<Equipment> equipmentList, RegistrationCountry registrationCountry, VehicleModel vehicleModel) {

    public VehicleMasterData {
        validateVehicleMasterData(equipmentList, registrationCountry, vehicleModel);
    }

    private void validateVehicleMasterData(List<Equipment> equipmentList, RegistrationCountry registrationCountry,  VehicleModel vehicleModel) {
        if (isVehicleMasterDataValid(equipmentList, registrationCountry, vehicleModel)) {
            throw new IllegalStateException("equipment list is not valid");
        }
    }

    private boolean isVehicleMasterDataValid(List<Equipment> equipmentList, RegistrationCountry registrationCountry,  VehicleModel vehicleModel) {
        return equipmentList != null && !equipmentList.isEmpty() && registrationCountry != null && vehicleModel != null;
    }

}
