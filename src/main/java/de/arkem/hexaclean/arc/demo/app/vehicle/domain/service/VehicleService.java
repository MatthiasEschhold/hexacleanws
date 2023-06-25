package de.arkem.hexaclean.arc.demo.app.vehicle.domain.service;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery;

public class VehicleService implements VehicleQuery {

    private VehicleDbQuery vehicleDbQuery;
    private FetchVehicleMasterData fetchVehicleMasterData;

    public VehicleService(VehicleDbQuery vehicleDbQuery, FetchVehicleMasterData fetchVehicleMasterData) {
        this.vehicleDbQuery = vehicleDbQuery;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
    }

    public Vehicle findByVin(Vin vin) {
        Vehicle vehicle = vehicleDbQuery.findVehicleByVin(vin);
        enrichWithVehicleMasterData(vehicle);
        return vehicle;
    }

    private void enrichWithVehicleMasterData(Vehicle vehicle) {
        VehicleMasterData masterData = fetchVehicleMasterData.fetch(vehicle.getVin());
        vehicle.addVehicleMasterData(masterData);
    }

}
