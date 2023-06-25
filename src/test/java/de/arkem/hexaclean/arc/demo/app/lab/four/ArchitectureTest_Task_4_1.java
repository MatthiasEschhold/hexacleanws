package de.arkem.hexaclean.arc.demo.app.lab.four;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import de.arkem.hexaclean.arc.demo.app.lab.TestConstants;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static de.arkem.hexaclean.arc.demo.app.lab.TestConstants.*;

@AnalyzeClasses(packages = TestConstants.ROOT_PACKAGE)
public class ArchitectureTest_Task_4_1 {

    public static final String LICENSE_PLATE = "LicensePlate";
    public static final String MILEAGE = "Mileage";
    public static final String EQUIPMENT_CODE = "EquipmentCode";

    @ArchTest
    void licensePlateAsValueObjectShouldFollowDesignPrinciplesForClassStereotypeValueObject(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(LICENSE_PLATE)
                .and()
                .resideInAnyPackage(VEHICLE_DOMAIN_MODEL, VEHICLE_DOMAIN)
                .should()
                .onlyAccessClassesThat()
                .resideInAnyPackage(IO_GITHUB_DOMAINPRIMITIVES, JAVA_LANG, JAVA_UTIL)
                .orShould().haveSimpleName(LICENSE_PLATE);
        rule.check(classes);
    }

    @ArchTest
    void mileageAsValueObjectShouldFollowDesignPrinciplesForClassStereotypeValueObject(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(MILEAGE)
                .and()
                .resideInAnyPackage(VEHICLE_DOMAIN_MODEL, VEHICLE_DOMAIN)
                .should()
                .onlyAccessClassesThat()
                .resideInAnyPackage(IO_GITHUB_DOMAINPRIMITIVES, JAVA_LANG, JAVA_UTIL)
                .orShould().haveSimpleName(MILEAGE);
        rule.check(classes);
    }

    @ArchTest
    void equipmentCodeAsValueObjectShouldFollowDesignPrinciplesForClassStereotypeValueObject(JavaClasses classes) {
        ArchRule rule = classes()
                .that()
                .haveSimpleName(EQUIPMENT_CODE)
                .and()
                .resideInAnyPackage(VEHICLE_DOMAIN_MODEL, VEHICLE_DOMAIN)
                .should()
                .onlyAccessClassesThat()
                .resideInAnyPackage(IO_GITHUB_DOMAINPRIMITIVES, JAVA_LANG, JAVA_UTIL)
                .orShould().haveSimpleName(EQUIPMENT_CODE);
        rule.check(classes);
    }

}
