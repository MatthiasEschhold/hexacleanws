package de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.usecase.out;

import de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.domain.model.VehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.domain.model.Vin;

public interface FetchVehicleMasterData {
    VehicleMasterData fetch(Vin vin);
}
