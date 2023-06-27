package de.arkem.hexaclean.arc.demo.app.lab.five;

import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleCommandRepository;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleToVehicleDbEntityMapper;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.arkem.hexaclean.arc.demo.app.lab.ComplexTestObjectFactory.createExpectedVehicle;
import static org.assertj.core.api.Assertions.assertThat;

class OutputAdapter_Task_5_2 {

    @Test
    @DisplayName("The VehicleCommandRepository should save a vehicle")
    void vehicle_and_vin_should_be_created_successful() {
        Vehicle expectedVehicle = createExpectedVehicle();
        Vehicle vehicle = saveVehicle(expectedVehicle);
        assertThat(vehicle.getVin()).isEqualTo(expectedVehicle.getVin());
        assertThat(vehicle.getVehicleMotionData().licensePlate()).isEqualTo(expectedVehicle.getVehicleMotionData().licensePlate());
        assertThat(vehicle.getVehicleMotionData().mileage()).isEqualTo(expectedVehicle.getVehicleMotionData().mileage());
    }

    private Vehicle saveVehicle(Vehicle vehicleToSave) {
        return createVehicleRepository().save(vehicleToSave);
    }

    private VehicleCommandRepository createVehicleRepository() {
        return new VehicleCommandRepository(new VehicleToVehicleDbEntityMapper());
    }

}
