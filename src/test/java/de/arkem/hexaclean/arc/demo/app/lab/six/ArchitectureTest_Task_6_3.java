package de.arkem.hexaclean.arc.demo.app.lab.six;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import de.arkem.hexaclean.arc.demo.app.lab.TestConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.*;

@AnalyzeClasses(packages = TestConstants.ROOT_PACKAGE)
class ArchitectureTest_Task_6_3 {

    static final String PARTS_CATALOGUE_APPSERVICE = "..parts.catalogue.appservice..";
    static final String VEHICLE_TO_ORIGIN_VEHICLE_MAPPER = "VehicleToOriginVehicleMapper";
    static final String GARAGE_ORDER_DOMAIN = "..garage.order.domain..";
    public static final String EXPLOSION_CHART_APPLICATION_SERVICE = "ExplosionChartApplicationService";
    public static final String PARTS_CATALOGUE_USECASE_OUT = "..parts.catalogue.usecase.out..";
    public static final String PARTS_CATALOGUE_DOMAIN = "..parts.catalogue.domain..";
    public static final String EXPLOSION_CHART_QUERY_PATH = "de.arkem.hexaclean.arc.demo.app.parts.catalogue.usecase.in.ExplosionChartQuery";

    @ArchTest
    void application_service_mapper_check(JavaClasses classes) throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(VEHICLE_TO_ORIGIN_VEHICLE_MAPPER)
                .and()
                .resideInAnyPackage(PARTS_CATALOGUE_APPSERVICE)
                .should()
                .onlyAccessClassesThat()
                .resideInAnyPackage(PARTS_CATALOGUE_APPSERVICE, VEHICLE_DOMAIN,
                        VEHICLE_DOMAIN_MODEL, GARAGE_ORDER_DOMAIN);
        rule.check(classes);
    }

    @ArchTest
    void application_service_check(JavaClasses classes) throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(EXPLOSION_CHART_APPLICATION_SERVICE)
                .and()
                .resideInAnyPackage(PARTS_CATALOGUE_APPSERVICE)
                .should()
                .onlyAccessClassesThat()
                .resideInAnyPackage(JAVA_LANG, JAVA_UTIL, ORG,
                        PARTS_CATALOGUE_USECASE_OUT, PARTS_CATALOGUE_APPSERVICE,
                        VEHICLE_USECASE_IN, VEHICLE_DOMAIN, PARTS_CATALOGUE_DOMAIN);
        rule.check(classes);
    }

    @ArchTest
    void application_service_patter_usecase_in_implementation_check(JavaClasses classes) throws ClassNotFoundException {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(EXPLOSION_CHART_APPLICATION_SERVICE)
                .and()
                .resideInAnyPackage(PARTS_CATALOGUE_APPSERVICE)
                .should()
                .implement(Class.forName(EXPLOSION_CHART_QUERY_PATH));
        rule.check(classes);
    }

}
