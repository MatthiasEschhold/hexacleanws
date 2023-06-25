package de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;

public class VehicleController {

    private final VehicleQuery vehicleQuery;

    public VehicleController(VehicleQuery vehicleQuery) {
        this.vehicleQuery = vehicleQuery;
    }

    public Vehicle readVehicle(String vin) {
        return vehicleQuery.findByVin(new Vin(vin));
    }

}
