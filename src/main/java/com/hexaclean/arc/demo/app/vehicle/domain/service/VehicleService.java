package com.hexaclean.arc.demo.app.vehicle.domain.service;

import com.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;

public class VehicleService {

    public Vehicle findByVin(Vin vin){
        return new Vehicle(vin);
    }

}
