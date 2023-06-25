package de.arkem.hexaclean.arc.demo.app.garage.order.usecase.out;

import de.arkem.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder;

public interface GarageOrderDbCommand {
    GarageOrder save(GarageOrder garageOrder);
}
