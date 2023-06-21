package web.pages.checkbox;

import web.commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CheckboxPage extends BasePage {

    @FindBy(id="checkbox-1")
    WebElement checkbox1;

    @FindBy(id="checkbox-2")
    WebElement checkbox2;

    @FindBy(id="checkbox-3")
    WebElement checkbox3;

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public void clickToCheckBox1(){
       clickToElement(checkbox1);
    }

    public void clickToCheckBox2(){
        clickToElement(checkbox2);
    }

    public void clickToCheckBox3(){
        clickToElement(checkbox3);
    }

    public boolean isCheckBox1Displayed() {
        return isElementDisplayed(checkbox1);
    }

    public boolean isCheckBox2Displayed() {
        return  isElementDisplayed(checkbox2);
    }

    public boolean isCheckBox3Displayed() {
        return  isElementDisplayed(checkbox3);
    }
}
