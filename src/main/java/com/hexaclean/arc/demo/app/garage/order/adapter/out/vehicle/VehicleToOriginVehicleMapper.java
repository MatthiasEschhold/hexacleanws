package com.hexaclean.arc.demo.app.garage.order.adapter.out.vehicle;


import com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.LicensePlate;
import com.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;

public class VehicleToOriginVehicleMapper {

    Vehicle mapOriginVehicleToVehicle(com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle vehicle) {
        return new Vehicle(new LicensePlate(vehicle.getVehicleMotionData().licensePlate().value()),
                vehicle.getVehicleMotionData().mileage().value());
    }
}
