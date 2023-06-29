package de.arkem.hexaclean.arc.demo.app.vehicle.domain.service;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery;

public class VehicleService implements VehicleQuery {

    private VehicleDbQuery vehicleDbQuery;

    public VehicleService(VehicleDbQuery vehicleDbQuery) {
        this.vehicleDbQuery = vehicleDbQuery;
    }

    public Vehicle findByVin(Vin vin) {
        Vehicle vehicle = vehicleDbQuery.findVehicleByVin(vin);
        //add enrichment of vehcile master data here
        return vehicle;
    }

}
