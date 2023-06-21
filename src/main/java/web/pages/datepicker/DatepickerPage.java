package web.pages.datepicker;

import web.commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatepickerPage extends BasePage {

    @FindBy(id="datepicker")
    WebElement datepicker;

    @FindBy(xpath="//*[contains(@class, 'today day')]")
    WebElement currentDay;
    public DatepickerPage(WebDriver driver) {
        super(driver);
    }

    public void clickCurrentDate() {
        waitForElementUntilClickable(driver, datepicker);
        clickToElement(datepicker);
        clickToElement(currentDay);
    }

    public String getCurrentDate() {
       return getElementValue(datepicker);
    }
}
