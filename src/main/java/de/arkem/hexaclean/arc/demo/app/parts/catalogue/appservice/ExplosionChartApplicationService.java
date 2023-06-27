package de.arkem.hexaclean.arc.demo.app.parts.catalogue.appservice;

import de.arkem.hexaclean.arc.demo.app.parts.catalogue.domain.model.ExplosionChart;
import de.arkem.hexaclean.arc.demo.app.parts.catalogue.domain.model.PartsCategoryCode;
import de.arkem.hexaclean.arc.demo.app.parts.catalogue.domain.model.vehicle.Vehicle;
import de.arkem.hexaclean.arc.demo.app.parts.catalogue.domain.service.ExplosionChartDomainService;
import de.arkem.hexaclean.arc.demo.app.parts.catalogue.usecase.in.ExplosionChartQuery;
import de.arkem.hexaclean.arc.demo.app.parts.catalogue.usecase.out.FetchExplosionChart;
import org.springframework.stereotype.Component;

@Component
public class ExplosionChartApplicationService implements ExplosionChartQuery {

    private FetchExplosionChart fetchExplosionChart;
    private final ExplosionChartDomainService explosionChartDomainService;

    public ExplosionChartApplicationService(FetchExplosionChart fetchExplosionChart,
                                            ExplosionChartDomainService explosionChartDomainService) {
        this.fetchExplosionChart = fetchExplosionChart;
        this.explosionChartDomainService = explosionChartDomainService;
    }

    @Override
    public ExplosionChart read(PartsCategoryCode partsCategoryCode, String vin) {

        //Add your code to implement the application service pattern here
        Vehicle vehicle = null;
        ExplosionChart explosionChart = fetchExplosionChart.fetch(partsCategoryCode, vehicle.vehicleModel(), vehicle.has5GSupport());

        //Some domain logic located in the domain service respectively in the root entity
        explosionChartDomainService.doSomeIdependentBusinessLogic(explosionChart);
        explosionChart.doSomeIdependentBusinessLogic();

        return explosionChart;
    }

}
