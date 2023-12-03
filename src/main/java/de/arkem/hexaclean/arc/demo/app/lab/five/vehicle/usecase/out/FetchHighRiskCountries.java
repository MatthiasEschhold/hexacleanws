package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.usecase.out;

import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.theft.status.HighRiskCountry;

import java.util.List;

public interface FetchHighRiskCountries {
    List<HighRiskCountry> fetch();
}
