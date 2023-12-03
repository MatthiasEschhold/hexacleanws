package de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.usecase.out;

import de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.domain.model.ExplosionChart;
import de.arkem.hexaclean.arc.demo.app.lab.five.parts.catalogue.domain.model.PartsCategoryCode;

public interface FetchExplosionChart {
    ExplosionChart fetch(PartsCategoryCode partsCategoryId, Vehicle vehicle);
}
