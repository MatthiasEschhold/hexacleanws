package de.arkem.hexaclean.arc.demo.app.vehicle.domain.service;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleCommand;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbCommand;
import org.springframework.stereotype.Service;

@Service
public class VehicleCommandService implements VehicleCommand {

    private VehicleDbCommand dbCommand;

    public VehicleCommandService(VehicleDbCommand dbCommand) {
        this.dbCommand = dbCommand;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        return dbCommand.save(vehicle);
    }

    @Override
    public Vehicle update(Vin vin, VehicleMotionData vehicleMotionData) {
        return dbCommand.save(new Vehicle(vin, vehicleMotionData));
    }
}
