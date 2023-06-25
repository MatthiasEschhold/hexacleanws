package de.arkem.hexaclean.arc.demo.app.lab.one;


import de.arkem.hexaclean.arc.demo.app.lab.TestConstants;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = TestConstants.ROOT_PACKAGE)
public class ArchitectureTest_Task_1_1 {

    @ArchTest
    void vehicleAsRootEntityShouldFollowDesignRulesForClassStereotypeRootEntity(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(TestConstants.ROOT_ENTITY_UNDER_TEST)
                .and()
                .resideInAnyPackage(TestConstants.VEHICLE_DOMAIN_MODEL, TestConstants.VEHICLE_DOMAIN)
                .should()
                .onlyAccessClassesThat()
                .resideInAnyPackage(TestConstants.IO_GITHUB_DOMAINPRIMITIVES, TestConstants.VEHICLE_DOMAIN, TestConstants.VEHICLE_DOMAIN_MODEL, TestConstants.JAVA_LANG, TestConstants.JAVA_UTIL)
                .andShould()
                .dependOnClassesThat()
                .haveSimpleName(TestConstants.VALUE_OBJECT_UNDER_TEST);
        rule.check(classes);
    }

    @ArchTest
    void vinAsValueObjectShouldFollowDesignRulesForClassStereotypeValueObject(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(TestConstants.VALUE_OBJECT_UNDER_TEST)
                .and().resideInAnyPackage(TestConstants.VEHICLE_DOMAIN_MODEL, TestConstants.VEHICLE_DOMAIN)
                .should()
                .onlyAccessClassesThat()
                .resideInAnyPackage(TestConstants.IO_GITHUB_DOMAINPRIMITIVES, TestConstants.JAVA_LANG, TestConstants.JAVA_UTIL, TestConstants.VEHICLE_DOMAIN, TestConstants.VEHICLE_DOMAIN_MODEL);
        rule.check(classes);
    }

}
