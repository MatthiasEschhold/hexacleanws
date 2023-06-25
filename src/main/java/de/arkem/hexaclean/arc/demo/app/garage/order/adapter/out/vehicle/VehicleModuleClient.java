package de.arkem.hexaclean.arc.demo.app.garage.order.adapter.out.vehicle;

import de.arkem.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;
import de.arkem.hexaclean.arc.demo.app.garage.order.usecase.out.FetchVehicle;

public class VehicleModuleClient implements FetchVehicle {

    private FindVehicleByLicensePlate findVehicleByLicensePlate;
    private VehicleToOriginVehicleMapper mapper;

    public VehicleModuleClient(FindVehicleByLicensePlate vehicleQuery, VehicleToOriginVehicleMapper mapper) {
        this.findVehicleByLicensePlate = vehicleQuery;
        this.mapper = mapper;
    }

    @Override
    public Vehicle fetch(LicensePlate licensePlate) {
        return mapper.mapOriginVehicleToVehicle(findVehicleByLicensePlate.findByLicensePlate(
                new de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate(licensePlate.value())));
    }
}
