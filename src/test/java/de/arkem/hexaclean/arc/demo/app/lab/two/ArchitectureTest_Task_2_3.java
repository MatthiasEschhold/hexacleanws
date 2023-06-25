package de.arkem.hexaclean.arc.demo.app.lab.two;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import de.arkem.hexaclean.arc.demo.app.lab.TestConstants;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.*;

@AnalyzeClasses(packages = TestConstants.ROOT_PACKAGE)
class ArchitectureTest_Task_2_3 {

    static final String VEHICLE_USECASE_OUT = "..app.vehicle.usecase.out..";
    static final String VEHICLE_USECASE = "..app.vehicle.usecase..";
    static final String VEHICLE_ADAPTER_OUT = "..app.vehicle.adapter.out..";
    static final String VEHICLE_ADAPTER = "..app.vehicle.adapter..";
    static final String VEHICLE_DB_QUERY = "de.arkem.hexaclean.arc.demo.app.vehicle.usecase.out.VehicleDbQuery";

    @ArchTest
    void vehicleRepositoryAsAdapterOutShouldFollowPortsAndAdaptersPattern(JavaClasses classes) throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(REPOSITORY_UNDER_TEST)
                .and()
                .resideInAnyPackage(
                        VEHICLE_ADAPTER_OUT, VEHICLE_ADAPTER)
                .should()
                .implement(Class.forName(VEHICLE_DB_QUERY));
        rule.check(classes);
    }

    @ArchTest
    void vehicleDbQueryAsUseCaseOutShouldFollowDesignRulesForClassStereotypeUseCaseOut(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(USECASE_OUT_QUERY_UNDER_TEST)
                .and()
                .resideInAnyPackage(
                        VEHICLE_USECASE_OUT, VEHICLE_USECASE)
                .should()
                .resideInAnyPackage(USECASE, USECASE_OUT)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(DOMAIN, DOMAIN_MODEL);
        rule.check(classes);
    }

    @ArchTest
    void vehicleRepositoryAsAdapterOutShouldFollowDesignRulesForStereotypeAdapterOut(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(REPOSITORY_UNDER_TEST)
                .and()
                .resideInAnyPackage(VEHICLE_ADAPTER_OUT, VEHICLE_ADAPTER)
                .should()
                .resideInAnyPackage(ADAPTER, ADAPTER_OUT)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(ADAPTER, ADAPTER_OUT, USECASE_OUT, USECASE, DOMAIN, DOMAIN_MODEL, JAVA_LANG, JAVA_UTIL, ORG);
        rule.check(classes);
    }

}
