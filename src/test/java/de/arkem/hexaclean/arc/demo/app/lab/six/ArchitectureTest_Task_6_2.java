package de.arkem.hexaclean.arc.demo.app.lab.six;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import de.arkem.hexaclean.arc.demo.app.lab.TestConstants;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.*;

@AnalyzeClasses(packages = TestConstants.ROOT_PACKAGE)
class ArchitectureTest_Task_6_2 {

    static final String VEHICLE_MODULE_CLIENT = "VehicleModuleClient";
    static final String GARAGE_ORDER_ADAPTER_OUT = "..garage.order.adapter.out..";
    static final String GARAGE_ORDER_ADAPTER = "..garage.order.adapter..";
    static final String FETCH_VEHICLE_FULL_PATH = "de.arkem.hexaclean.arc.demo.app.garage.order.usecase.out.FetchVehicle";

    @ArchTest
    void vehicleModuleClientAsAdapterShouldFollowDesignPrinciplesForStereotypeOutboundAdapter(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(VEHICLE_MODULE_CLIENT)
                .and()
                .resideInAnyPackage(GARAGE_ORDER_ADAPTER_OUT, GARAGE_ORDER_ADAPTER)
                .should()
                .onlyAccessClassesThat()
                .resideInAnyPackage(GARAGE_ORDER_ADAPTER_OUT,
                        GARAGE_ORDER_ADAPTER, DOMAIN, DOMAIN_MODEL,
                        VEHICLE_USECASE_IN, JAVA_LANG, JAVA_UTIL, ORG);
        rule.check(classes);
    }

    @ArchTest
    void vehicleModuleClientShouldFollowPortsAndAdaptersPattern(JavaClasses classes) throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(VEHICLE_MODULE_CLIENT)
                .and()
                .resideInAnyPackage(GARAGE_ORDER_ADAPTER_OUT, GARAGE_ORDER_ADAPTER)
                .should()
                .implement(Class.forName(FETCH_VEHICLE_FULL_PATH));
        rule.check(classes);
    }

}
