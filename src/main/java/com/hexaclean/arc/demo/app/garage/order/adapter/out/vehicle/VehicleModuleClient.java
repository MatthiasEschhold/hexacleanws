package com.hexaclean.arc.demo.app.garage.order.adapter.out.vehicle;

import com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.LicensePlate;
import com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;
import com.hexaclean.arc.demo.app.garage.order.usecase.out.FetchVehicle;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.FindVehicleByLicensePlate;

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
                new com.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate(licensePlate.value())));
    }
}
