package ddt.patternTests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import web.pageObjects.patterns.decorator.*;
import web.utilities.listeners.TestListener;

@Listeners({TestListener.class})
@Epic("Java mentoring")
@Feature("Design pattern")
public class DecoratorTests {

    @Description("Test description: Quality assurance become to business analyst")
    @Story("Key And Mouse Press")
    @Test
    public void qualityAssuranceBecomeBusinessAnalyst(){
        Employee employee = new EmployeeImpl("Ngo Thao");
        employee.join("2022");

        // Work as quality assurance position
        employee = new QualityAssurance(employee);
        ((QualityAssurance) employee).performTestingFeatureTask("Login");

        // After 1 year, work as Business Analyst
        employee = new BusinessAnalyst(employee);
        ((BusinessAnalyst) employee).createUserStory();
        ((BusinessAnalyst) employee).planing("Sprint 20");
    }

    @Description("Test description: Business analyst become to project manager")
    @Story("Key And Mouse Press")
    @Test
    public void businessAnalystBecomeProjectManager(){
        Employee employee = new EmployeeImpl("Ngo Thao");
        employee.join("2022");

        // Work as Business Analyst
        employee = new BusinessAnalyst(employee);
        ((BusinessAnalyst) employee).createUserStory();
        ((BusinessAnalyst) employee).planing("Sprint 22");

        // After 1 year, work as Business Analyst
        employee = new ProjectManager(employee);
        ((ProjectManager) employee).assignTask();
        ((ProjectManager) employee).collectReport();
    }

    @Description("Test description: Developer become to project manager")
    @Story("Key And Mouse Press")
    @Test
    public void developerBecomeProjectManager(){
        Employee employee = new EmployeeImpl("Ngo Thao");
        employee.join("2022");

        // Work as Business Analyst
        employee = new Developer(employee);
        ((Developer) employee).performCodingFeatureTask("Login");

        // After 1 year, work as Business Analyst
        employee = new ProjectManager(employee);
        ((ProjectManager) employee).assignTask();
        ((ProjectManager) employee).collectReport();
    }
}
