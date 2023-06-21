package bdd.stepDefinitions;

import bdd.runners.TestRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import web.pages.CompleteWebForm;

public class CompleteWebFormStepDefinitions {
    private CompleteWebForm completeWebForm;

    public CompleteWebFormStepDefinitions() {
        this.completeWebForm = new CompleteWebForm(TestRunner.driver);
    }

    @When("^I input firstname as (.*), lastname as (.*) and job title as (.*)$")
    public void inputInfo(String firstname, String lastname, String jobTitle ) {
        completeWebForm.inputInfo(firstname, lastname, jobTitle);
    }
    @Then("^Verify all fields firstname as (.*), lastname as (.*) and job title as (.*) are filled$")
    public void verify_all_fields_are_completed(String firstname, String lastname, String jobTitle) {
        completeWebForm.verifyAllFieldsFilled(firstname, lastname, jobTitle);
    }
}
