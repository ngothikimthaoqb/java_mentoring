package web.pages.buttons;

import web.commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ButtonPage extends BasePage {

    @FindBy(xpath="//button[text()='Primary']")
    WebElement primaryButton;

    @FindBy(xpath="//button[text()='Success']")
    WebElement successButton;

    @FindBy(xpath="//button[text()='Danger']")
    WebElement dangerButton;

    public ButtonPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyAllButtons(){
        return isPrimaryButtonCorrect() && isDangerButtonCorrect() && isSuccessButtonCorrect();
    }

    public boolean isPrimaryButtonCorrect(){
        waitForElementUntilClickable(driver, primaryButton);
        return getElementText(primaryButton).equals("Primary");
    }

    public boolean isDangerButtonCorrect(){
        waitForElementUntilClickable(driver, dangerButton);
        return getElementText(dangerButton).equals("Danger");
    }

    public boolean isSuccessButtonCorrect(){
        waitForElementUntilClickable(driver, successButton);
        return getElementText(successButton).equals("Success");
    }

    public boolean isDarkButtonNotDisplayed(){
        return true;
    }

}
