package web.pages;

import web.commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CompleteWebForm extends BasePage {
    @FindBy(xpath="//input[@placeholder='Enter first name']")
    WebElement firstname;

    @FindBy(xpath="//input[@placeholder='Enter last name']")
    WebElement lastname;

    @FindBy(xpath="//input[@placeholder='Enter your job title']")
    WebElement jobTitle;

    public CompleteWebForm(WebDriver driver) {
        super(driver);
    }

    public void inputInfo(String firstname, String lastname, String jobTitle) {
        sendKeyToElement(this.firstname, firstname);
        sendKeyToElement(this.lastname, lastname);
        sendKeyToElement(this.jobTitle, jobTitle);
    }

    public void verifyAllFieldsFilled(String firstname, String lastname, String jobTitle) {
        Assert.assertEquals(getElementValue(this.firstname), firstname);
        Assert.assertEquals(getElementValue(this.lastname), lastname);
        Assert.assertEquals(getElementValue(this.jobTitle), jobTitle);

    }
}
