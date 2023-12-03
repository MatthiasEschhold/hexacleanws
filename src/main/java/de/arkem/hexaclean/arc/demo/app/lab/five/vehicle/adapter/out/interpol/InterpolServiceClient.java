package de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.adapter.out.interpol;

import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.theft.status.TheftStatus;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.theft.status.TheftStatusEnum;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.LicensePlate;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.domain.model.vehicle.Vin;
import de.arkem.hexaclean.arc.demo.app.lab.five.vehicle.usecase.out.DetectInterpolTheftStatus;

public class InterpolServiceClient implements DetectInterpolTheftStatus {
    @Override
    public TheftStatus detect(Vin vin, LicensePlate licensePlate)  {
        return new TheftStatus(TheftStatusEnum.STOLEN);
    }
}
