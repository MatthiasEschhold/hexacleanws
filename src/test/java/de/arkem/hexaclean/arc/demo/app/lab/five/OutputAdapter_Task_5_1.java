package de.arkem.hexaclean.arc.demo.app.lab.five;

import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleQueryRepository;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.db.VehicleToVehicleDbEntityMapper;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.arkem.hexaclean.arc.demo.app.lab.ComplexTestObjectFactory.createExpectedVehicle;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.VIN;
import static org.assertj.core.api.Assertions.assertThat;

class OutputAdapter_Task_5_1 {

    @Test
    @DisplayName("The VehicleRepository should return a valid Vehicle")
    void vehicle_and_vin_should_be_created_successful() {
        Vehicle vehicle = findVehicleByVin();
        Vehicle expectedVehicle = createExpectedVehicle();
        assertThat(vehicle.getVin()).isEqualTo(expectedVehicle.getVin());
        assertThat(vehicle.getVehicleMotionData().licensePlate()).isEqualTo(expectedVehicle.getVehicleMotionData().licensePlate());
        assertThat(vehicle.getVehicleMotionData().mileage()).isEqualTo(expectedVehicle.getVehicleMotionData().mileage());
    }

    private Vehicle findVehicleByVin() {
        return createVehicleRepository().findVehicleByVin(new Vin(VIN));
    }

    private VehicleQueryRepository createVehicleRepository() {
        return new VehicleQueryRepository(new VehicleToVehicleDbEntityMapper());
    }

}
