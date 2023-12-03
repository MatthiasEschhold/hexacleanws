package de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.usecase.out;

import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.VehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.Vin;

public interface FetchVehicleMasterData {
    VehicleMasterData fetch(Vin vin);
}
