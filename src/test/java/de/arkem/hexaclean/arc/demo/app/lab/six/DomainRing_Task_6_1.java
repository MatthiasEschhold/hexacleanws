package de.arkem.hexaclean.arc.demo.app.lab.six;

import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.service.VehicleQueryService;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static de.arkem.hexaclean.arc.demo.app.lab.ComplexTestObjectFactory.createExpectedVehicle;
import static de.arkem.hexaclean.arc.demo.app.lab.ComplexTestObjectFactory.createExpectedVehicleMasterData;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.LICENSE_PLATE_TEST_VALUE;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.VIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class DomainRing_Task_6_1 {

    @Test
    @DisplayName("The VehicleService should implement the orchestration between different outgoing use cases")
    void vehicle_service_should_return_a_valid_vehicle() {
        Vin vin = new Vin(VIN);

        VehicleDbQuery vehicleDbQuery = Mockito.mock(VehicleDbQuery.class);
        when(vehicleDbQuery.findVehicleByLicensePlate(new LicensePlate(LICENSE_PLATE_TEST_VALUE))).thenReturn(createExpectedVehicle());

        FetchVehicleMasterData fetchVehicleMasterData = Mockito.mock(FetchVehicleMasterData.class);
        when(fetchVehicleMasterData.fetch(vin)).thenReturn(createExpectedVehicleMasterData());

        Vehicle expectedVehicle = createExpectedVehicle();
        Vehicle vehicle = new VehicleQueryService(vehicleDbQuery, fetchVehicleMasterData)
                .fetchByLicensePlate(expectedVehicle.getVehicleMotionData().licensePlate());

        assertThat(vehicle).isEqualTo(expectedVehicle);
        assertThat(vehicle.getVehicleMasterData().vehicleModel().modelType()).isEqualTo(expectedVehicle.getVehicleMasterData().vehicleModel().modelType());
        assertThat(vehicle.getVehicleMasterData().vehicleModel().modelDescription()).isEqualTo(expectedVehicle.getVehicleMasterData().vehicleModel().modelDescription());
        assertThat(vehicle.getVehicleMasterData().mileageUnit()).isEqualTo(expectedVehicle.getVehicleMasterData().mileageUnit());
        assertThat(vehicle.getVehicleMasterData().serialNumber()).isEqualTo(expectedVehicle.getVehicleMasterData().serialNumber());
        assertThat(vehicle.isHas5GSupport()).isFalse();
        assertThat(vehicle.getVin()).isEqualTo(expectedVehicle.getVin());
        assertThat(vehicle.getVehicleMotionData().licensePlate()).isEqualTo(expectedVehicle.getVehicleMotionData().licensePlate());
        assertThat(vehicle.getVehicleMotionData().mileage()).isEqualTo(expectedVehicle.getVehicleMotionData().mileage());
    }

}
