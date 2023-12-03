package de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.usecase.out;

import de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.domain.model.GarageOrder;

public interface GarageOrderDbCommand {
    GarageOrder save(GarageOrder garageOrder);
}
