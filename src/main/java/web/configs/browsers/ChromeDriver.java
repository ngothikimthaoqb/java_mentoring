package web.configs.browsers;

import web.configs.browserOptions.ChromeOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class ChromeDriver implements WebDriverFactory {

    public WebDriver getDriver(boolean isWindowPlatform, String node, String os, String os_version, Map<String, Object> sauceOptions) {

        try {
            return new RemoteWebDriver(new URL(node),
                    isWindowPlatform ? DesiredCapabilities.chrome():
                            new ChromeOption().getOptions(os, os_version, sauceOptions));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
