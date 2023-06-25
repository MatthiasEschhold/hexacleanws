package de.arkem.hexaclean.arc.demo.app.lab.four;

import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.masterdata.VehicleMasterDataServiceClient;
import de.arkem.hexaclean.arc.demo.app.vehicle.adapter.out.masterdata.VehicleToVehicleMasterDataDtoMapper;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.VehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.arkem.hexaclean.arc.demo.app.lab.ComplexTestObjectFactory.createExpectedVehicle;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.VIN;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
class OutputAdapter_Task_4_3 {
    @Test
    @DisplayName("The VehicleMasterDataServiceClient should return vehicle master data")
    void should_return_vehicle_master_data() {

        Vehicle vehicle = createExpectedVehicle();

        VehicleMasterData vehicleMasterData = new VehicleMasterDataServiceClient(new VehicleToVehicleMasterDataDtoMapper()).fetch(new Vin(VIN));

        assertThat(vehicleMasterData.vehicleModel().modelType()).isEqualTo(vehicle.getVehicleMasterData().vehicleModel().modelType());
        assertThat(vehicleMasterData.vehicleModel().modelDescription()).isEqualTo(vehicle.getVehicleMasterData().vehicleModel().modelDescription());
        assertThat(vehicleMasterData.mileageUnit()).isEqualTo(vehicle.getVehicleMasterData().mileageUnit());
        assertThat(vehicleMasterData.serialNumber()).isEqualTo(vehicle.getVehicleMasterData().serialNumber());
        assertThat(vehicleMasterData.equipmentList().size()).isEqualTo(3);
    }
}
