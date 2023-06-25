package de.arkem.hexaclean.arc.demo.app.garage.order.usecase.in;

import de.arkem.hexaclean.arc.demo.app.garage.order.domain.command.CreateGarageOrderCommand;
import de.arkem.hexaclean.arc.demo.app.garage.order.domain.command.UpdateGarageOrderCommand;
import de.arkem.hexaclean.arc.demo.app.garage.order.domain.model.GarageOrder;

public interface GarageOrderCommand {
    GarageOrder create(CreateGarageOrderCommand createGarageOrderCommand);

    GarageOrder update(UpdateGarageOrderCommand updateGarageOrderCommand);
}
