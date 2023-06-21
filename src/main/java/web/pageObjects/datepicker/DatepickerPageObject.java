package web.pageObjects.datepicker;

import org.openqa.selenium.By;

public class DatepickerPageObject{
    public final By datepicker = By.id("datepicker");
    public final By currentDay = By.xpath("//*[contains(@class, 'today day')]");
}
