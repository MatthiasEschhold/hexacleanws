package de.arkem.hexaclean.arc.demo.app.lab.five;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import de.arkem.hexaclean.arc.demo.app.lab.TestConstants;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.*;


@AnalyzeClasses(packages = TestConstants.ROOT_PACKAGE)
class ArchitectureTest_Task_5_2 {

    static final String VEHICLE_COMMAND_SERVICE = "VehicleCommandService";
    public static final String VEHICLE_COMMAND = "VehicleCommand";
    public static final String VEHICLE_COMMAND_SERVICE_PATH = "de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleCommand";

    @ArchTest
    void vehicleCommandServiceAsServiceShouldFollowDesignPrinciplesForClassStereotypeService(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(VEHICLE_COMMAND_SERVICE)
                .should()
                .resideInAnyPackage(VEHICLE_DOMAIN_SERVICE)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(
                        VEHICLE_DOMAIN,
                        VEHICLE_USECASE,
                        JAVA_LANG,
                        JAVA_UTIL,
                        ORG);
        rule.check(classes);
    }

    @ArchTest
    void usecase_in_check(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(VEHICLE_COMMAND)
                .should()
                .resideInAnyPackage(VEHICLE_USECASE_IN)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(VEHICLE_DOMAIN_MODEL);
        rule.check(classes);
    }

    @ArchTest
    void usecase_in_implementation_check(JavaClasses classes) throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(VEHICLE_COMMAND_SERVICE)
                .and()
                .resideInAnyPackage(VEHICLE_DOMAIN_SERVICE)
                .should()
                .implement(Class.forName(VEHICLE_COMMAND_SERVICE_PATH));
        rule.check(classes);
    }

}
