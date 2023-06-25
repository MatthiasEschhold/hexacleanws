package de.arkem.hexaclean.arc.demo.app.lab.three;

import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.VehicleRepository;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.VehicleToVehicleDbEntityMapper;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.VIN;
import static de.arkem.hexaclean.arc.demo.app.lab.TestObjectFactory.createExpectedVehicle;
import static org.assertj.core.api.Assertions.assertThat;
class OutputAdapter_Task_3_2 {

    @Test
    @DisplayName("The VehicleRepository should return a valid Vehicle")
    void vehicle_and_vin_should_be_created_successful() {
        Vehicle vehicle = findVehicleByVin();
        assertThat(vehicle).isEqualTo(createExpectedVehicle());
    }

    private Vehicle findVehicleByVin() {
        return createVehicleRepository().findVehicleByVin(new Vin(VIN));
    }

    private VehicleRepository createVehicleRepository() {
        return new VehicleRepository(new VehicleToVehicleDbEntityMapper());
    }

}
