package de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.usecase.out;

import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.theft.status.HighRiskCountry;

import java.util.List;

public interface FetchHighRiskCountries {
    List<HighRiskCountry> fetch();
}
