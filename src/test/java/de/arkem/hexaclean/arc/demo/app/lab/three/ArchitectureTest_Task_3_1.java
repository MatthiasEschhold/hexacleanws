package de.arkem.hexaclean.arc.demo.app.lab.three;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import de.arkem.hexaclean.arc.demo.app.lab.TestConstants;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.*;

@AnalyzeClasses(packages = TestConstants.ROOT_PACKAGE)
class ArchitectureTest_Task_3_1 {
    @ArchTest
    void vehicleDbEntityAsStereotypeDtoShouldFollowDesignPrinciplesDataTransferObjects(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(DB_ENTITY_UNDER_TEST)
                .should()
                .resideInAnyPackage(ADAPTER_OUT, ADAPTER)
                .andShould()
                .onlyAccessClassesThat()
                .resideInAnyPackage(ADAPTER_OUT, ADAPTER, JAVA_LANG, JAVA_UTIL, ORG);
        rule.check(classes);
    }

}
