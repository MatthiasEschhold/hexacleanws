package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.dto;

import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vin;

public record VehicleQueryResult(Vin vin, VehicleMotionData vehicleMotionData) {
}
