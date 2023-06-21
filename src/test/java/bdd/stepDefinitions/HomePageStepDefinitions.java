package bdd.stepDefinitions;

import bdd.runners.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import web.pages.HomePage;


public class HomePageStepDefinitions {
    private HomePage homePage;

    public HomePageStepDefinitions() {
        this.homePage = new HomePage(TestRunner.driver);
    }

    @When("User click on button tab in navigation bar")
    public void user_click_on_button_tab_in_navigation_bar() {
        homePage.clickButton();
    }

    @When("I click Complete Web Form link")
    public void i_click_complete_web_form_link() {
       homePage.clickCompleteWebForm();
    }

    @Given("^Open Website (.*)$")
    public void goToHomePage(String pageUrl) {
        homePage.gotoHomePage(pageUrl);
    }
}
