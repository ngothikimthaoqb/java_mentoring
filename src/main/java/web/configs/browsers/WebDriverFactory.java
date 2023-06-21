package web.configs.browsers;

import org.openqa.selenium.WebDriver;

import java.util.Map;

public interface WebDriverFactory {
    public WebDriver getDriver(boolean isWindowPlatform, String node, String OS, String OS_Version, Map<String, Object> sauceOptions);
}
