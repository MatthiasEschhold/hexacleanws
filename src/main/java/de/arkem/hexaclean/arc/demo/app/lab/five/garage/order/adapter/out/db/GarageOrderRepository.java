package de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.adapter.out.db;

import de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.domain.model.GarageOrder;
import de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.domain.model.OrderNumber;
import de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.usecase.out.GarageOrderDbCommand;
import de.arkem.hexaclean.arc.demo.app.lab.five.garage.order.usecase.out.GarageOrderDbQuery;

public class GarageOrderRepository implements GarageOrderDbCommand, GarageOrderDbQuery {

    @Override
    public GarageOrder save(GarageOrder garageOrder) {
        return null;
    }

    @Override
    public GarageOrder findByOrderNumber(OrderNumber orderNumber) {
        return null;
    }
}
