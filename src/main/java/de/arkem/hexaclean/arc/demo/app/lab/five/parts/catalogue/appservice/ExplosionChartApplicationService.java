package de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.appservice;

import de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.usecase.out.FetchExplosionChart;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.usecase.in.VehicleQuery;
import de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.domain.model.ExplosionChart;
import de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.domain.model.PartsCategoryCode;
import de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.domain.service.ExplosionChartDomainService;
import de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.usecase.in.ExplosionChartQuery;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vin;
import org.springframework.stereotype.Component;

@Component
public class ExplosionChartApplicationService implements ExplosionChartQuery {

    private FetchExplosionChart fetchExplosionChart;
    private VehicleQuery vehicleQuery;
    private VehicleToEntityMapper mapper;
    private final ExplosionChartDomainService explosionChartDomainService;

    public ExplosionChartApplicationService(FetchExplosionChart fetchExplosionChart,
                                            VehicleQuery vehicleQuery,
                                            VehicleToEntityMapper mapper,
                                            ExplosionChartDomainService explosionChartDomainService) {
        this.fetchExplosionChart = fetchExplosionChart;
        this.vehicleQuery = vehicleQuery;
        this.mapper = mapper;
        this.explosionChartDomainService = explosionChartDomainService;
    }

    @Override
    public ExplosionChart read(PartsCategoryCode partsCategoryCode, String vin) {

        //Add ypur code to implement the application service pattern here
        Vehicle vehicle = mapper.mapToEntity(vehicleQuery.findByVin(new Vin(vin)));
        ExplosionChart explosionChart = fetchExplosionChart.fetch(partsCategoryCode, vehicle);

        //some domain logic located in the domain service respectively in the root entity
        explosionChartDomainService.doSomeIdependentBusinessLogic(explosionChart);
        explosionChart.doSomeIdependentBusinessLogic();

        return explosionChart;
    }

}
