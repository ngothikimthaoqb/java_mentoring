package web.configs.drivers;

import web.commons.GlobalConstants;
import web.configs.browserOptions.SauceLabOption;
import web.configs.browsers.BrowserName;
import web.configs.browsers.ChromeDriver;
import web.configs.browsers.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import web.utilities.PropertyReader;

import java.util.Map;

public class DriverConfig {
    private DriverConfig() {
    }

    private static ThreadLocal<WebDriver> driver;

    public static WebDriver getDriver(String browserName, String platformName) {
            BrowserName browserNameEnum = BrowserName.valueOf(browserName.toUpperCase());
            PropertyReader propertyReader = new PropertyReader(GlobalConstants.CONFIG_FILE_KEY);
            boolean isWindowPlatform = platformName.equals(GlobalConstants.WINDOW_PLATFORM.toString());
            String node = isWindowPlatform ? propertyReader.getValue(GlobalConstants.LOCAL_NODE) + "/wd/hub" :
                    propertyReader.getValue(GlobalConstants.SAUCELAB_NODE) + "/wd/hub";

            if (driver == null) {
                driver = new ThreadLocal<>();
                String username = propertyReader.getValue(GlobalConstants.USERNAME);
                String accessKey = propertyReader.getValue(GlobalConstants.ACCESSKEY);
                String os = propertyReader.getValue(GlobalConstants.OS);
                String os_version = propertyReader.getValue(GlobalConstants.OS_VERSION);
                Map<String, Object> getOptions = SauceLabOption.getInstance().getOptions(username, accessKey);

                switch (browserNameEnum) {
                    case CHROME:
                        driver.set(new ChromeDriver().getDriver(isWindowPlatform, node, os, os_version, getOptions));
                        break;
                    case FIREFOX:
                        driver.set(new FirefoxDriver().getDriver(isWindowPlatform, node, os, os_version, getOptions));
                        break;
                    default:
                        throw new IllegalArgumentException("Please check the browser name again!");
                }
            }

        return driver.get();
    }

    public static void quiteDriver() {
        if (driver.get() != null) {
            driver.get().close();
            driver.get().quit();
            driver.remove();
        }
        driver.set(null);
    }
}