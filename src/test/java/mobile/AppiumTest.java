package mobile;

import mobile.configs.BaseTest;
import mobile.pages.LoginPage;
import org.testng.annotations.Test;

public class AppiumTest extends BaseTest {

    @Test
    public void verifyLogin()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("abc123", "123452abc");
        loginPage.verifyErrorMessage();
    }
}
