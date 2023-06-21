package web.commons;

import web.configs.drivers.DriverConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import web.pages.HomePage;
import web.utilities.PropertyReader;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected  WebDriver driver=null;
    protected HomePage homePage;
    protected Logger logger;

    protected BaseTest() {
        logger = LogManager.getLogger(getClass());
    }
    PropertyReader propertyReader = new PropertyReader(GlobalConstants.CONFIG_FILE_KEY);

    @Parameters({"pageUrl", "browserName", "platform"})
    @BeforeClass
    public void setUp(String pageUrl, String browserName, String platform) {
        logger.info("Page Url: " + pageUrl + " with browser name: " + browserName);
        driver = DriverConfig.getDriver(browserName, platform);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(propertyReader.getValue(GlobalConstants.SHORT_TIMEOUT_KEY)), TimeUnit.SECONDS);
        driver.get(pageUrl);
        homePage = new HomePage(driver);
    }


    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverConfig.quiteDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
