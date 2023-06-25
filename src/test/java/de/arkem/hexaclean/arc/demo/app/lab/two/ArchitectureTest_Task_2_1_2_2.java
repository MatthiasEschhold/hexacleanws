package de.arkem.hexaclean.arc.demo.app.lab.two;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import de.arkem.hexaclean.arc.demo.app.lab.TestConstants;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.*;

@AnalyzeClasses(packages = TestConstants.ROOT_PACKAGE)
class ArchitectureTest_Task_2_1_2_2 {

    public static final String VEHICLE_DOMAIN_SERVICE = "..app.vehicle.domain.service..";
    public static final String VEHICLE_DOMAIN = "..app.vehicle.domain..";
    public static final String VEHICLE_QUERY = "de.arkem.hexaclean.arc.demo.app.vehicle.usecase.in.VehicleQuery";

    @ArchTest
    void vehicleControllerAsAdapterInShouldFollowDesignRulesForClassStereotypeAdapterIn(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(CONTROLLER_UNDER_TEST)
                .should()
                .resideInAnyPackage(ADAPTER, ADAPTER_IN)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(
                        DOMAIN,
                        DOMAIN_MODEL,
                        USECASE_IN,
                        USECASE,
                        ORG,
                        JAVA_LANG,
                        ADAPTER,
                        ADAPTER_IN);
        rule.check(classes);
    }

    @ArchTest
    void vehicleQueryAsUseCaseInShouldFollowDesignPrincipleForClassStereotypeUseCaseIn(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(USECASE_IN_QUERY_UNDER_TEST)
                .should()
                .resideInAnyPackage(USECASE, USECASE_IN)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(DOMAIN, DOMAIN_MODEL);
        rule.check(classes);
    }

    @ArchTest
    void vehicleServiceAsServiceShouldFollowPortsAndAdaptersPatterns(JavaClasses classes) throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(SERVICE_UNDER_TEST)
                .and()
                .resideInAnyPackage(VEHICLE_DOMAIN_SERVICE, VEHICLE_DOMAIN)
                .should()
                .implement(Class.forName(VEHICLE_QUERY));
        rule.check(classes);
    }

}
