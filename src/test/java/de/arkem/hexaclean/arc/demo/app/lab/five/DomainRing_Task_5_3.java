package de.arkem.hexaclean.arc.demo.app.lab.five;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.arkem.hexaclean.arc.demo.app.lab.ComplexTestObjectFactory.createExpectedVehicleMasterData;
import static de.arkem.hexaclean.arc.demo.app.lab.ComplexTestObjectFactory.createExpectedVehicleMasterDataHas5G;
import static de.arkem.hexaclean.arc.demo.app.lab.SimpleTestObjectFactory.createExpectedVehicleMotionData;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.VIN;
import static org.assertj.core.api.Assertions.assertThat;

public class DomainRing_Task_5_3 {
    @Test
    @DisplayName("The vehicle supports 5G")
    void the_vehicle_supports_5G() {
        Vin vin = new Vin(VIN);
        Vehicle vehicle = new Vehicle(vin, createExpectedVehicleMotionData());
        VehicleMasterData masterData = createExpectedVehicleMasterDataHas5G();
        vehicle.addVehicleMasterData(masterData);
        assertThat(vehicle.getVin()).isEqualTo(vin);
        assertThat(vehicle.isHas5GSupport()).isTrue();
    }

    @Test
    @DisplayName("The vehicle supports not 5G")
    void the_vehicle_supports_not_5G() {
        Vin vin = new Vin(VIN);
        Vehicle vehicle = new Vehicle(vin, createExpectedVehicleMotionData());
        VehicleMasterData masterData = createExpectedVehicleMasterData();
        vehicle.addVehicleMasterData(masterData);
        assertThat(vehicle.getVin()).isEqualTo(vin);
        assertThat(vehicle.isHas5GSupport()).isFalse();
    }
}
