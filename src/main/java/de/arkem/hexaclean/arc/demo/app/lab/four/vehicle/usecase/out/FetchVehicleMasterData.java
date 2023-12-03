package de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.usecase.out;

import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.VehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.Vin;

public interface FetchVehicleMasterData {
    VehicleMasterData fetch(Vin vin);
}
