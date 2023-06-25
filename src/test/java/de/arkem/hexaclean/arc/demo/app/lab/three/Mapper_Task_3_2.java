/*package de.arkem.hexaclean.arc.demo.app.lab.three;

import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.VehicleDbEntity;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.VehicleToVehicleDbEntityMapper;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.arkem.hexaclean.arc.demo.app.lab.TestObjectFactory.createExpectedVehicle;
import static de.arkem.hexaclean.arc.demo.app.lab.TestObjectFactory.createVehicleDbEntity;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Mapper_Task_3_2 {
    @Test
    @DisplayName("The VehicleToVehicleDbEntityMapper should transform the VehicleDbEntity to Vehicle object instance")
    void vehicle_and_vin_should_be_created_successful() {
        VehicleDbEntity dbEntity = createVehicleDbEntity();
        Vehicle vehicle = mapVehicleDbEntityToVehicle(dbEntity);
        assertThat(vehicle).isEqualTo(createExpectedVehicle());
    }

    private Vehicle mapVehicleDbEntityToVehicle(VehicleDbEntity dbEntity) {
        return new VehicleToVehicleDbEntityMapper().mapVehicleDbEntityToVehicle(dbEntity);
    }
}
*/