package de.arkem.hexaclean.arc.demo.app.lab.six;

import de.arkem.hexaclean.arc.demo.app.garage.order.adapter.out.vehicle.VehicleModuleClient;
import de.arkem.hexaclean.arc.demo.app.garage.order.adapter.out.vehicle.VehicleToOriginVehicleMapper;
import de.arkem.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.FetchVehicleByLicensePlate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static de.arkem.hexaclean.arc.demo.app.lab.ComplexTestObjectFactory.createExpectedVehicle;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.LICENSE_PLATE_TEST_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class OutputAdapter_Task_6_2 {

    @Test
    @DisplayName("The VehicleModuleClient should return a vehicle")
    void vehicle_and_vin_should_be_created_successful() {
        LicensePlate licensePlate = new LicensePlate(LICENSE_PLATE_TEST_VALUE);
        FetchVehicleByLicensePlate findVehicleByLicensePlate = Mockito.mock(FetchVehicleByLicensePlate.class);
        when(findVehicleByLicensePlate.fetchByLicensePlate(licensePlate)).thenReturn(createExpectedVehicle());

        Vehicle vehicle = new VehicleModuleClient(findVehicleByLicensePlate, new VehicleToOriginVehicleMapper())
                .fetch(new de.arkem.hexaclean.arc.demo.app.garage.order.domain.model.vehicle.LicensePlate(LICENSE_PLATE_TEST_VALUE));
        de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle expectedVehicle = createExpectedVehicle();
        assertThat(vehicle.mileage()).isEqualTo(expectedVehicle.getVehicleMotionData().mileage().value());
        assertThat(vehicle.licencePlate().value()).isEqualTo(expectedVehicle.getVehicleMotionData().licensePlate().value());
    }

}
