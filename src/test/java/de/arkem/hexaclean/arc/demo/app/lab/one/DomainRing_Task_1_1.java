/*package de.arkem.hexaclean.arc.demo.app.lab.one;


import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vehicle;
import de.arkem.hexaclean.arc.demo.app.vehicle.domain.model.Vin;
import org.junit.jupiter.api.Test;

import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.VIN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class DomainRing_Task_1_1 {

    @Test
    void should_throw_exception_due_to_invalid_vin() {
        assertThrows(Exception.class, () -> new Vehicle(new Vin("hgjhgkjhkhkhjh")));
    }

    @Test
    void should_throw_exception_due_to_null_for_vin() {
        assertThrows(Exception.class, () -> new Vehicle(null));
    }

    @Test
    void vehicle_and_vin_should_be_created_successful() {
        Vin vin = new Vin(VIN);
        Vehicle vehicle = new Vehicle(vin);
        assertThat(vehicle.getVin()).isEqualTo(vin);
    }

}*/
