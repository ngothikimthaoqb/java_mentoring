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
import web.pages.datepicker.DatepickerPage;
import web.utilities.DateAndTimeUtil;
import web.utilities.listeners.TestListener;

@Listeners({TestListener.class})
@Epic("Java mentoring")
@Feature("HomePage")
public class DatePickerTest extends BaseTest {
    private HomePage homePage;
    private DatepickerPage datepickerPage;

    @Parameters({"pageUrl"})
    @BeforeMethod
    public void beforeMethod(String pageUrl) {
        homePage = new HomePage(driver);
        datepickerPage =  new DatepickerPage(driver);
        driver.get(pageUrl);
    }

    @Description("Test description: DatePicker")
    @Story("DatePicker")
    @Test()
    public void verifySelectedDatepickerSuccessfully() {
        homePage.clickDatepicker();
        datepickerPage.clickCurrentDate();
        Assert.assertEquals(datepickerPage.getCurrentDate(), DateAndTimeUtil.getCurrentDate());
    }
}
