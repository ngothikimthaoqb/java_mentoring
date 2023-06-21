package mobile.configs;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import web.commons.GlobalConstants;
import web.utilities.PropertyReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public static AppiumDriver<?> driver;
    protected Logger logger;

    protected BaseTest() {
        logger = LogManager.getLogger(getClass());
    }

    @Parameters({"udid", "platformName", "app"})
    @BeforeClass
    public void setUp(String udid, String platformName, String app) throws MalformedURLException {
        PropertyReader propertyReader = new PropertyReader(GlobalConstants.CONFIG_FILE_KEY);
        String appiumURL = propertyReader.getValue(GlobalConstants.APPIUM);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.UDID,udid);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.APP, app);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 50000);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        driver = new AndroidDriver<AndroidElement>(new URL(appiumURL), capabilities);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
