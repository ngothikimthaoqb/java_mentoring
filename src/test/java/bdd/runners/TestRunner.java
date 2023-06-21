package bdd.runners;

import java.util.concurrent.TimeUnit;

import web.commons.GlobalConstants;
import web.configs.drivers.DriverConfig;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.TestNGCucumberRunner;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import web.utilities.PropertyReader;

@CucumberOptions(
        features = "src/test/java/bdd/features/",
        glue = {"bdd.stepDefinitions"},
        monochrome = true,
        tags="@SmokeTest",
        plugin = "json:target/cucumber-reports/CucumberTestReport.json")
public class TestRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    public static WebDriver driver = null;
    PropertyReader propertyReader = new PropertyReader(GlobalConstants.CONFIG_FILE_KEY);
    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"pageUrl", "browserName", "platform"})
    public void setUpClass(String pageUrl, String browserName, String platform) throws Exception {
        driver = DriverConfig.getDriver(browserName, platform);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(propertyReader.getValue(GlobalConstants.SHORT_TIMEOUT_KEY)), TimeUnit.SECONDS);
        driver.get(pageUrl);
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        DriverConfig.quiteDriver();
        testNGCucumberRunner.finish();
    }
}
