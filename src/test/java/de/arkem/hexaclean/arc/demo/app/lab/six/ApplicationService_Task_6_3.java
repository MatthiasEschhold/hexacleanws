package de.arkem.hexaclean.arc.demo.app.lab.six;

import de.arkem.hexaclean.arc.demo.app.parts.catalogue.appservice.ExplosionChartApplicationService;
import de.arkem.hexaclean.arc.demo.app.parts.catalogue.appservice.VehicleToOriginVehicleMapper;
import de.arkem.hexaclean.arc.demo.app.parts.catalogue.domain.model.ExplosionChart;
import de.arkem.hexaclean.arc.demo.app.parts.catalogue.domain.model.PartsCategoryCode;
import de.arkem.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.VehicleModel;
import de.arkem.hexaclean.arc.demo.app.parts.catalogue.domain.service.ExplosionChartDomainService;
import de.arkem.hexaclean.arc.demo.app.parts.catalogue.usecase.out.FetchExplosionChart;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static de.arkem.hexaclean.arc.demo.app.lab.ComplexTestObjectFactory.createExpectedVehicle;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.when;

class ApplicationService_Task_6_3 {

    @Test
    @DisplayName("Should return a explosion chart")
    void should_return_a_explosion_chart() {
        FetchExplosionChart fetchExplosionChart = Mockito.mock(FetchExplosionChart.class);
        VehicleQuery vehicleQuery = Mockito.mock(VehicleQuery.class);
        VehicleToOriginVehicleMapper mapper = Mockito.mock(VehicleToOriginVehicleMapper.class);
        Vehicle vehicle = createExpectedVehicle();

        de.arkem.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.Vehicle expectedVehicle =
                new de.arkem.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.Vehicle(VIN, false, new VehicleModel(VEHICLE_MODEL_DESCRIPTION_TEST_VALUE, VEHICLE_MODEL_TYPE_TEST_VALUE));

        when(fetchExplosionChart.fetch(any(), any(), anyBoolean())).thenReturn(new ExplosionChart(expectedVehicle, null, null));
        when(vehicleQuery.findByVin(new Vin(VIN))).thenReturn(vehicle);
        when(mapper.mapOriginVehicleToVehicle(vehicle)).thenReturn(expectedVehicle);

        ExplosionChartApplicationService appService = new ExplosionChartApplicationService(fetchExplosionChart, vehicleQuery,
                mapper, new ExplosionChartDomainService());

        ExplosionChart explosionChart = appService.read(new PartsCategoryCode("123", "testcode"), VIN);

        assertThat(explosionChart.getVehicle().vehicleModel().modelType()).isEqualTo(expectedVehicle.vehicleModel().modelType());
        assertThat(explosionChart.getVehicle().vehicleModel().modelDescription()).isEqualTo(expectedVehicle.vehicleModel().modelDescription());
        assertThat(vehicle.isHas5GSupport()).isEqualTo(expectedVehicle.has5GSupport());
    }
}