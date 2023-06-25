package de.arkem.hexaclean.arc.demo.app.lab.one;


import de.arkem.hexaclean.arc.demo.app.lab.TestConstants;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = TestConstants.ROOT_PACKAGE)
class ArchitectureTest_Task_1_2 {

    @ArchTest
    void vehicleServiceShouldFollowDesignRulesForClassStereotypeService(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(TestConstants.SERVICE_UNDER_TEST)
                .should()
                .resideInAnyPackage(TestConstants.DOMAIN, TestConstants.DOMAIN_SERVICE)
                .andShould()
                .dependOnClassesThat()
                .resideInAnyPackage(TestConstants.DOMAIN, TestConstants.DOMAIN_MODEL, TestConstants.JAVA_LANG, TestConstants.JAVA_UTIL);
        rule.check(classes);
    }
}
