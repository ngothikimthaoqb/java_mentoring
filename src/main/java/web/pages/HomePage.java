package web.pages;

import io.qameta.allure.Step;
import web.commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @FindBy(xpath="//li/a[text()='Buttons']")
    WebElement button;

    @FindBy(xpath="//li/a[text()='Datepicker']")
    WebElement datepicker;

    @FindBy(xpath="//li/a[text()='Checkbox']")
    WebElement checkbox;

    @FindBy(xpath="//li/a[text()='Switch Window']")
    WebElement switchWindow;

    @FindBy(xpath="//li/a[text()='Key and Mouse Press']")
    WebElement keyAndMousePress;

    @FindBy(xpath="//li/a[text()='Complete Web Form']")
    WebElement completeWebForm;

    @FindBy(xpath="//li/a[text()='File Upload']")
    WebElement fileUpload;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Click Button")
    public void clickButton() {
        clickToElement(button);
    }

    public void clickCheckbox() {
        clickToElement(checkbox);
    }
    @Step("Click Datepicker")
    public void clickDatepicker() {
        clickToElement(datepicker);
    }

    @Step("Click Key and Mouse Press")
    public void clickKeyAndMousePress() {
        clickToElementByJavaScript(driver, keyAndMousePress);
    }

    @Step("Click Web Form")
    public boolean isCompleteWebFormDisplayed() {
        return isElementDisplayed(completeWebForm);
    }

    @Step("Click Switch Window")
    public void clickSwitchWindow() {
        clickAndHighLightToElement(driver, switchWindow);
    }

    @Step("Click File Upload")
    public void clickFileUpload() {
        clickToElement(fileUpload);
    }

    @Step("Click Complete form")
    public void clickCompleteWebForm() {
        clickToElement(completeWebForm);
    }

    @Step("Go to home Page")
    public void gotoHomePage(String pageUrl) {
        driver.get(pageUrl);
    }
}
