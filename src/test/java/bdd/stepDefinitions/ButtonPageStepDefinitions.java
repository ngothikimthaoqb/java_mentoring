package bdd.stepDefinitions;

import bdd.runners.TestRunner;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import web.pages.buttons.ButtonPage;

public class ButtonPageStepDefinitions {
    private ButtonPage buttonPage;

    public ButtonPageStepDefinitions() {
        this.buttonPage = new ButtonPage(TestRunner.driver);
    }

    @Then("Danger button is displayed")
    public void danger_button_is_displayed() {
       buttonPage.isDangerButtonCorrect();
    }
    @Then("Primary button is displayed")
    public void primary_button_is_displayed() {
        buttonPage.isPrimaryButtonCorrect();
    }
    @Then("Success button is displayed")
    public void success_button_is_displayed() {
        buttonPage.isSuccessButtonCorrect();
    }

    @But("Dark button is not displayed")
    public void dark_button_not_displayed() {
        buttonPage.isDarkButtonNotDisplayed();
    }
}
