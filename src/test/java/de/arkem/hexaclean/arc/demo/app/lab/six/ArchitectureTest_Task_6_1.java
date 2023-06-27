package de.arkem.hexaclean.arc.demo.app.lab.six;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.*;

class ArchitectureTest_Task_6_1  {

    static final String FETCH_VEHICLE_BY_LICENSE_PLATE_FULL_PATH = "com.hexaclean.arc.demo.app.vehicle.usecase.in.FindVehicleByLicensePlate";
    @ArchTest
    void usecase_in_implementation_check(JavaClasses classes) throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(SERVICE_UNDER_TEST)
                .and()
                .resideInAnyPackage(VEHICLE_DOMAIN_SERVICE, VEHICLE_DOMAIN)
                .should()
                .implement(Class.forName(FETCH_VEHICLE_BY_LICENSE_PLATE_FULL_PATH));
        rule.check(classes);
    }

}
