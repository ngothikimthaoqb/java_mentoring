package web.pages;

import io.qameta.allure.Step;
import web.commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class KeyAndMousePressPage extends BasePage {

    @FindBy(xpath="//input[@id='name']")
    WebElement fullNameInput;

    @FindBy(id="button")
    WebElement button;

    public KeyAndMousePressPage(WebDriver driver) {
        super(driver);
    }

    @Step("Input to Full Name")
    public void inputToFullName(String firstname, String lastname) {
        sendKeyToElement(fullNameInput, firstname);
        new Actions(driver)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.SPACE)
                .sendKeys(lastname)
                .perform();
    }

    @Step("Get Full Name")
    public String getFullNameInput() {
        return getElementValue(fullNameInput);
    }

    @Step("Move to mouse button")
    public void moveToMouseButton() {
        moveToElement(driver, button);
    }

    public String getBackgroundMouseButton() {
        return  getCssValue(button, "background-color");
    }
}
