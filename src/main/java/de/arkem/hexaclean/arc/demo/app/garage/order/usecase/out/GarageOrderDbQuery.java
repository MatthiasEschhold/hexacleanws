package de.arkem.hexaclean.arc.demo.app.garage.order.usecase.out;

import de.arkem.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder;
import de.arkem.hexaclean.arc.demo.app.garage.order.domain.model.OrderNumber;

public interface GarageOrderDbQuery {
    GarageOrder findByOrderNumber(OrderNumber orderNumber);
}
