package com.hexaclean.arc.demo.app.parts.catalogue.appservice;

import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.ExplosionChart;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.PartsCategoryCode;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.Vehicle;
import com.hexaclean.arc.demo.app.parts.catalogue.domain.service.ExplosionChartDomainService;
import com.hexaclean.arc.demo.app.parts.catalogue.usecase.in.ExplosionChartQuery;
import com.hexaclean.arc.demo.app.parts.catalogue.usecase.out.FetchExplosionChart;
import com.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import com.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery;
import org.springframework.stereotype.Component;

@Component
public class ExplosionChartApplicationService implements ExplosionChartQuery {

    private FetchExplosionChart fetchExplosionChart;
    private VehicleQuery vehicleQuery;
    private VehicleToOriginVehicleMapper mapper;
    private ExplosionChartDomainService explosionChartDomainService;

    public ExplosionChartApplicationService(FetchExplosionChart fetchExplosionChart,
                                            VehicleQuery vehicleQuery,
                                            VehicleToOriginVehicleMapper mapper,
                                            ExplosionChartDomainService explosionChartDomainService) {
        this.fetchExplosionChart = fetchExplosionChart;
        this.vehicleQuery = vehicleQuery;
        this.mapper = mapper;
        this.explosionChartDomainService = explosionChartDomainService;
    }

    @Override
    public ExplosionChart read(PartsCategoryCode partsCategoryCode, String vin) {

        //Add ypur code to implement the application service pattern here
        Vehicle vehicle = mapper.mapOriginVehicleToVehicle(vehicleQuery.findByVin(new Vin(vin)));
        ExplosionChart explosionChart = fetchExplosionChart.fetch(partsCategoryCode, vehicle.vehicleModel(), vehicle.has2GSupport());

        //some domain logic located in the domain service respectively in the root entity
        explosionChartDomainService.doSomeIdependentBusinessLogic(explosionChart);
        explosionChart.doSomeIdependentBusinessLogic();

        return explosionChart;
    }

}
