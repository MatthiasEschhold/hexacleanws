package de.arkem.hexaclean.arc.demo.app.garage.order.usecase.in;

import de.arkem.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder;
import de.arkem.hexaclean.arc.demo.app.garage.order.domain.model.OrderNumber;

public interface GarageOrderQuery {
    GarageOrder read(OrderNumber orderNumber);
}
