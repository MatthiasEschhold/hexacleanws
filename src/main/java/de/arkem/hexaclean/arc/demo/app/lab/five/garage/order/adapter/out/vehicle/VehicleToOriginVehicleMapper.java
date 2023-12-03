package de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.adapter.out.vehicle;

import de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.domain.model.vehicle.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.domain.model.vehicle.Vehicle;

public class VehicleToOriginVehicleMapper {

    Vehicle mapOriginVehicleToVehicle(de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vehicle vehicle) {
        return new Vehicle(new LicensePlate(vehicle.getVehicleMotionData().licensePlate().value()),
                vehicle.getVehicleMotionData().mileage().mileageValue().value());
    }
}
