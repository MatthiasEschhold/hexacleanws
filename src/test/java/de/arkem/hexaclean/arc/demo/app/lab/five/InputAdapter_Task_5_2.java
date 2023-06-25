package de.arkem.hexaclean.arc.demo.app.lab.five;

import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleController;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleToVehicleResourceMapperImpl;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.resource.VehicleResource;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleCommand;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static de.arkem.hexaclean.arc.demo.app.lab.ComplexTestObjectFactory.createExpectedVehicle;
import static de.arkem.hexaclean.arc.demo.app.lab.ComplexTestObjectFactory.createExpectedVehicleResource;
import static de.arkem.hexaclean.arc.demo.app.lab.SimpleTestObjectFactory.createExpectedVehicleMotionDataResource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class InputAdapter_Task_5_2 {

    @Test
    @DisplayName("The VehicleController should save a vehicle")
    void should_save_a_vehicle() {
        Vehicle expectedVehicle = createExpectedVehicle();
        VehicleResource vehicle = createVehicle(expectedVehicle);
        assertThat(vehicle.getVin()).isEqualTo(expectedVehicle.getVin().value());
        assertThat(vehicle.getLicensePlate()).isEqualTo(expectedVehicle.getVehicleMotionData().licensePlate().value());
        assertThat(vehicle.getMileage()).isEqualTo(expectedVehicle.getVehicleMotionData().mileage().value());
    }

    @Test
    @DisplayName("The VehicleController should update a vehicle")
    void should_update_a_vehicle() {
        Vehicle expectedVehicle = createExpectedVehicle();
        VehicleResource vehicle = updateVehicle(expectedVehicle);
        assertThat(vehicle.getVin()).isEqualTo(expectedVehicle.getVin().value());
        assertThat(vehicle.getLicensePlate()).isEqualTo(expectedVehicle.getVehicleMotionData().licensePlate().value());
        assertThat(vehicle.getMileage()).isEqualTo(expectedVehicle.getVehicleMotionData().mileage().value());
    }

    private VehicleResource createVehicle(Vehicle vehicleToSave) {
        VehicleQuery vehicleQuery = Mockito.mock(VehicleQuery.class);
        VehicleCommand vehicleCommand = Mockito.mock(VehicleCommand.class);
        when(vehicleCommand.create(vehicleToSave)).thenReturn(vehicleToSave);
        return new VehicleController(vehicleQuery, new VehicleToVehicleResourceMapperImpl(), vehicleCommand).createVehicle(createExpectedVehicleResource());
    }

    private VehicleResource updateVehicle(Vehicle vehicleToSave) {
        VehicleQuery vehicleQuery = Mockito.mock(VehicleQuery.class);
        VehicleCommand vehicleCommand = Mockito.mock(VehicleCommand.class);
        when(vehicleCommand.update(vehicleToSave.getVin(), vehicleToSave.getVehicleMotionData())).thenReturn(vehicleToSave);
        return new VehicleController(vehicleQuery, new VehicleToVehicleResourceMapperImpl(), vehicleCommand).updateVehicle(vehicleToSave.getVin().value(), createExpectedVehicleMotionDataResource());
    }

}
