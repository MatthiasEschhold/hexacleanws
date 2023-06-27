package de.arkem.hexaclean.arc.demo.app.vehicle.domain.service;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.FetchVehicleByLicensePlate;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery;

public class VehicleQueryService implements VehicleQuery, FetchVehicleByLicensePlate {

    private VehicleDbQuery vehicleDbQuery;
    private FetchVehicleMasterData fetchVehicleMasterData;

    public VehicleQueryService(VehicleDbQuery vehicleDbQuery, FetchVehicleMasterData fetchVehicleMasterData) {
        this.vehicleDbQuery = vehicleDbQuery;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
    }

    public Vehicle findByVin(Vin vin) {
        Vehicle vehicle = vehicleDbQuery.findVehicleByVin(vin);
        enrichWithVehicleMasterData(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle fetchByLicensePlate(LicensePlate licensePlate) {
        Vehicle vehicle = vehicleDbQuery.findVehicleByLicensePlate(licensePlate);
        enrichWithVehicleMasterData(vehicle);
        return vehicle;
    }

    private void enrichWithVehicleMasterData(Vehicle vehicle) {
        vehicle.addVehicleMasterData(fetchVehicleMasterData.fetch(vehicle.getVin()));
    }
}
