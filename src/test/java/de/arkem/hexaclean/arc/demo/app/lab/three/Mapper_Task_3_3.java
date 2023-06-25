package de.arkem.hexaclean.arc.demo.app.lab.three;

import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleResource;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.in.VehicleToVehicleResourceMapperImpl;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.arkem.hexaclean.arc.demo.app.lab.TestObjectFactory.createExpectedVehicle;
import static de.arkem.hexaclean.arc.demo.app.lab.TestObjectFactory.createExpectedVehicleResource;
import static org.assertj.core.api.Assertions.assertThat;

class Mapper_Task_3_3 {

    @Test
    @DisplayName("The VehicleToVehicleResourceMapper should return a valid vehicle instance")
    void vehicle_and_vin_should_be_created_successful() {
        Vehicle entity = createExpectedVehicle();
        VehicleResource vehicle = new VehicleToVehicleResourceMapperImpl().mapVehicleToVehicleResource(entity);
        assertThat(vehicle.getVin()).isEqualTo(createExpectedVehicleResource().getVin());
    }

}
