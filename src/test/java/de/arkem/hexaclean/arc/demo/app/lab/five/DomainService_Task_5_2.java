package de.arkem.hexaclean.arc.demo.app.lab.five;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.service.VehicleCommandService;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static de.arkem.hexaclean.arc.demo.app.lab.ComplexTestObjectFactory.createExpectedVehicle;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class DomainService_Task_5_2 {

    @Test
    @DisplayName("The VehicleCommandService should create a vehicle")
    void should_create_a_vehicle() {
        Vehicle expectedVehicle = createExpectedVehicle();
        Vehicle vehicle = createVehicle(expectedVehicle);
        assertThat(vehicle.getVin().value()).isEqualTo(expectedVehicle.getVin().value());
        assertThat(vehicle.getVehicleMotionData().licensePlate().value()).isEqualTo(expectedVehicle.getVehicleMotionData().licensePlate().value());
        assertThat(vehicle.getVehicleMotionData().mileage().value()).isEqualTo(expectedVehicle.getVehicleMotionData().mileage().value());
    }

    @Test
    @DisplayName("The VehicleCommandServie should update a vehicle")
    void should_update_a_vehicle() {
        Vehicle expectedVehicle = createExpectedVehicle();
        Vehicle vehicle = updateVehicle(expectedVehicle);
        assertThat(vehicle.getVin().value()).isEqualTo(expectedVehicle.getVin().value());
        assertThat(vehicle.getVehicleMotionData().licensePlate().value()).isEqualTo(expectedVehicle.getVehicleMotionData().licensePlate().value());
        assertThat(vehicle.getVehicleMotionData().mileage().value()).isEqualTo(expectedVehicle.getVehicleMotionData().mileage().value());
    }

    private Vehicle createVehicle(Vehicle vehicleToCreate) {
        VehicleDbCommand vehicleCommand = Mockito.mock(VehicleDbCommand.class);
        when(vehicleCommand.save(vehicleToCreate)).thenReturn(vehicleToCreate);
        return new VehicleCommandService(vehicleCommand).create(vehicleToCreate);
    }

    private Vehicle updateVehicle(Vehicle vehicleToUpdate) {
        VehicleDbCommand vehicleCommand = Mockito.mock(VehicleDbCommand.class);
        when(vehicleCommand.save(vehicleToUpdate)).thenReturn(vehicleToUpdate);
        return new VehicleCommandService(vehicleCommand).update(vehicleToUpdate.getVin(), vehicleToUpdate.getVehicleMotionData());
    }

}
