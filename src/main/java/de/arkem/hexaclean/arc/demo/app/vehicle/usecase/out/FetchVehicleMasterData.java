package de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;

public interface FetchVehicleMasterData {
    public VehicleMasterData fetch(Vin vin);
}
