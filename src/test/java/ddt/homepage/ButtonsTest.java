package ddt.homepage;

import web.commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import web.pages.HomePage;
import web.pages.buttons.ButtonPage;
import web.utilities.listeners.TestListener;

@Listeners({TestListener.class})
@Epic("Java mentoring")
@Feature("HomePage")
public class ButtonsTest extends BaseTest {

    private HomePage homePage;
    private ButtonPage buttonPage;

    @Parameters({"pageUrl"})
    @BeforeMethod
    public void beforeMethod(String pageUrl) {
        homePage = new HomePage(driver);
        buttonPage =  new ButtonPage(driver);
        driver.get(pageUrl);
    }

    @Description("Test description: button")
    @Story("Button")
    @Test()
    public void verifyButtonsDisplayed() {
        homePage.clickButton();
        Assert.assertTrue(buttonPage.verifyAllButtons(), "All buttons");
    }
}
