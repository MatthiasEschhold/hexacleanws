package de.arkem.hexaclean.arc.demo.app.lab.two;

import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleController;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.VIN;
import static de.arkem.hexaclean.arc.demo.app.lab.TestObjectFactory.createExpectedVehicle;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class InputAdapter_Task_2_1_2_2 {

    @Test
    @DisplayName("VehicleController should return a valid Vehicle")
    void vehicle_controller_should_return_a_valid_vehicle() {
        VehicleQuery vehicleQuery = Mockito.mock(VehicleQuery.class);
        when(vehicleQuery.findByVin(new Vin(VIN))).thenReturn(createExpectedVehicle());

        Vehicle vehicle = createVehicleController(vehicleQuery).readVehicle(VIN);
        assertThat(vehicle.getVin()).isEqualTo(createExpectedVehicle().getVin());
    }

    private VehicleController createVehicleController(VehicleQuery vehicleQuery) {
        return new VehicleController(vehicleQuery);
    }

}
