package de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.service;

import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.theft.status.TheftStatus;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.theft.status.TheftStatusEnum;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.Vehicle;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.VehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.VehicleMotionData;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.domain.model.vehicle.Vin;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.usecase.in.VehicleCommand;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.usecase.in.VehicleQuery;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.usecase.out.DetectInterpolTheftStatus;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.usecase.out.FetchHighRiskCountries;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.usecase.out.FetchVehicleMasterData;
import de.arkem.hexaclean.arc.demo.app.lab.four.vehicle.usecase.out.VehicleRepository;

public class VehicleService implements VehicleCommand, VehicleQuery {

    private final VehicleRepository repository;
    private final FetchVehicleMasterData fetchVehicleMasterData;
    private final TheftRiskRatingService theftRiskRatingService;
    private final DetectInterpolTheftStatus detectInterpolTheftStatus;
    private final FetchHighRiskCountries fetchHighRiskCountries;

    //@Autowired
    public VehicleService(VehicleRepository repository, FetchVehicleMasterData fetchVehicleMasterData,
                          TheftRiskRatingService theftRiskRatingService, DetectInterpolTheftStatus detectInterpolTheftStatus, FetchHighRiskCountries fetchHighRiskCountries) {
        this.repository = repository;
        this.fetchVehicleMasterData = fetchVehicleMasterData;
        this.theftRiskRatingService = theftRiskRatingService;
        this.detectInterpolTheftStatus = detectInterpolTheftStatus;
        this.fetchHighRiskCountries = fetchHighRiskCountries;
    }

    @Override
    public Vehicle createVehicle(Vin vin, VehicleMotionData vehicleMotionData) {
        VehicleMasterData vehicleMasterData = fetchVehicleMasterData.fetch(vin);
        Integer ratingResult = theftRiskRatingService.rateTheftRisk(vehicleMasterData.registrationCountry(), vehicleMotionData.licensePlate(), fetchHighRiskCountries.fetch());
        if (ratingResult > 75) {
            TheftStatus theftStatus = detectInterpolTheftStatus.detect(vin, vehicleMotionData.licensePlate());
            if (isVehicleStolen(theftStatus)) {
                throw new IllegalStateException("interpol is informed and on the way");
            }
        }
        repository.save(vin, vehicleMotionData);
        return new Vehicle(vin, vehicleMotionData, vehicleMasterData);
    }

    private boolean isVehicleStolen(TheftStatus theftStatus) {
        return theftStatus.value().equals(TheftStatusEnum.STOLEN.toString());
    }

    @Override
    public Vehicle findByVin(Vin vin) {
        VehicleMasterData vehicleMasterData = fetchVehicleMasterData.fetch(vin);
        VehicleMotionData vehicleMotionData = repository.findVehicleMotionDataByVin(vin);
        return new Vehicle(vin, vehicleMotionData, vehicleMasterData);
    }
}
