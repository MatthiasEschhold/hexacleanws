package de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.usecase.out;

import de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.domain.model.GarageOrder;
import de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.domain.model.OrderNumber;

public interface GarageOrderDbQuery {
    GarageOrder findByOrderNumber(OrderNumber orderNumber);
}
