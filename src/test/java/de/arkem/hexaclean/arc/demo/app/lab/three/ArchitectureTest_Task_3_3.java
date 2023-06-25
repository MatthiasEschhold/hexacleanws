package de.arkem.hexaclean.arc.demo.app.lab.three;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import de.arkem.hexaclean.arc.demo.app.lab.TestConstants;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.*;

@AnalyzeClasses(packages = TestConstants.ROOT_PACKAGE)
class ArchitectureTest_Task_3_3 {
    static final String VEHICLE_TO_VEHICLE_RESOURCE_MAPPER = "VehicleToVehicleResourceMapper";

    @ArchTest
    void vehicleResourceMapperAsMapperShouldFollowDesignPrinciplesForStereotypeMapper(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleNameEndingWith(VEHICLE_TO_VEHICLE_RESOURCE_MAPPER)
                .should()
                .resideInAnyPackage(ADAPTER_IN, ADAPTER)
                .andShould()
                .onlyDependOnClassesThat()
                .resideInAnyPackage(
                        VEHICLE_DOMAIN,
                        VEHICLE_DOMAIN_MODEL,
                        VEHICLE_ADAPTER,
                        VEHICLE_ADAPTER_IN,
                        VEHICLE_USECASE,
                        VEHICLE_USECASE_IN,
                        JAVA_LANG,
                        JAVA_UTIL,
                        ORG);
        rule.check(classes);
    }

}
