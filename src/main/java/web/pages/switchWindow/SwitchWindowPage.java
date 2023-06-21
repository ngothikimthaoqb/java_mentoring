package web.pages.switchWindow;

import web.commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SwitchWindowPage extends BasePage {

    @FindBy(id="new-tab-button")
    WebElement newTabButton;

    @FindBy(id="alert-button")
    WebElement alertButton;

    public SwitchWindowPage(WebDriver driver) {
        super(driver);
    }

    public void switchToAnotherBrowser() {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        Assert.assertEquals(browserTabs.size(), 2);
        driver.switchTo().window(browserTabs .get(1));
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }

    public void clickNewTabButton() {
        clickAndHighLightToElement(driver, newTabButton);
    }

    public void clickAlertButton() {
        clickAndHighLightToElement(driver, alertButton);
    }
}
