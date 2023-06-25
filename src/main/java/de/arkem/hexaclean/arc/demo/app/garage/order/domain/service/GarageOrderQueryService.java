package de.arkem.hexaclean.arc.demo.app.garage.order.domain.service;

import de.arkem.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder;
import de.arkem.hexaclean.arc.demo.app.garage.order.domain.model.OrderNumber;
import de.arkem.hexaclean.arc.demo.app.garage.order.usecase.in.GarageOrderQuery;
import de.arkem.hexaclean.arc.demo.app.garage.order.usecase.out.GarageOrderDbQuery;

public class GarageOrderQueryService implements GarageOrderQuery {

    private GarageOrderDbQuery dbQuery;

    public GarageOrderQueryService(GarageOrderDbQuery dbQuery) {
        this.dbQuery = dbQuery;
    }

    @Override
    public GarageOrder read(OrderNumber orderNumber) {
        return dbQuery.findByOrderNumber(orderNumber);
    }

}
