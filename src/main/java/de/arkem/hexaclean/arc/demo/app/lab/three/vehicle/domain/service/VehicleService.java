package de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.service;

import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.VehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.usecase.in.VehicleCommand;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.domain.model.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.lab.three.vehicle.usecase.out.VehicleRepository;

public class VehicleService implements VehicleCommand {

    private final VehicleRepository repository;
    private final FetchVehicleMasterData fetchVehicleMasterData;

    //@Autowired
    public VehicleService(VehicleRepository repository, FetchVehicleMasterData fetchVehicleMasterData) {
        this.repository = repository;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
    }

    @Override
    public Vehicle createVehicle(Vin vin, VehicleMotionData vehicleMotionData) {
        VehicleMasterData vehicleMasterData = fetchVehicleMasterData.fetch(vin);
        repository.save(vin, vehicleMotionData);
        return new Vehicle(vin, vehicleMotionData, vehicleMasterData);
    }
}
