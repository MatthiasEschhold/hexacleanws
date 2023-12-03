package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.usecase.out;

import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vin;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.VehicleMasterData;

public interface FetchVehicleMasterData {
    VehicleMasterData fetch(Vin vin);
}
