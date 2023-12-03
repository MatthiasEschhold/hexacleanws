package de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.usecase.out;

import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.theft.status.TheftStatus;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.Vin;

public interface DetectInterpolTheftStatus {
    TheftStatus detect(Vin vin, LicensePlate licensePlate);
}
