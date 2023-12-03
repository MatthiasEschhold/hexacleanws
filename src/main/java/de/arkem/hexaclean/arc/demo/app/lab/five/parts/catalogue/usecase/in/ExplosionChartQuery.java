package de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.usecase.in;

import de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.domain.model.ExplosionChart;
import de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.domain.model.PartsCategoryCode;

public interface ExplosionChartQuery {
    ExplosionChart read(PartsCategoryCode partsCategoryCode, String vin);
}
