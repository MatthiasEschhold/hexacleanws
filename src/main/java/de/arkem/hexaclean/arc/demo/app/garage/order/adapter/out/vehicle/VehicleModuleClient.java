package de.arkem.hexaclean.arc.demo.app.garage.order.adapter.out.vehicle;

import de.arkem.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;
import de.arkem.hexaclean.arc.demo.app.garage.order.usecase.out.FetchVehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.FetchVehicleByLicensePlate;

public class VehicleModuleClient implements FetchVehicle {

    private FetchVehicleByLicensePlate fetchVehicleByLicensePlate;
    private VehicleToOriginVehicleMapper mapper;

    public VehicleModuleClient(FetchVehicleByLicensePlate fetchVehicleByLicensePlate, VehicleToOriginVehicleMapper mapper) {
        this.fetchVehicleByLicensePlate = fetchVehicleByLicensePlate;
        this.mapper = mapper;
    }

    @Override
    public Vehicle fetch(LicensePlate licensePlate) {
        return mapper.mapOriginVehicleToVehicle(fetchVehicleByLicensePlate.fetchByLicensePlate(
                new de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate(licensePlate.value())));
    }
}
