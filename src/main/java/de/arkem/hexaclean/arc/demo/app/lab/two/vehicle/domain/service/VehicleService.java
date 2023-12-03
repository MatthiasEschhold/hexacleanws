package de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.domain.service;

import de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.usecase.out.VehicleRepository;
import de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.domain.model.VehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.domain.model.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.lab.two.vehicle.usecase.in.VehicleCommand;

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
        Vehicle vehicle = new Vehicle(vin, vehicleMotionData, vehicleMasterData);
        return repository.save(vehicle);
    }
}
