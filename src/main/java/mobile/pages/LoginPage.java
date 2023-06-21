package mobile.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    private String loginButtonXpath="//android.widget.Button[@content-desc='Log in']";
    private String usernameLabelXpath="//android.view.View[@content-desc='Mobile number or email']";
    private String passwordLabelXpath = "//android.view.View[@content-desc='Password']";
    private String usernameInputXpath="//android.widget.EditText[1]";
    private String passwordInputXpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText";

    private String errorMessageXpath = "//android.widget.LinearLayout/android.widget.TextView";
    public AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        this.driver=driver;
    }

    public void waitUntilElementIsVisible(By by, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void login(String username, String password) {
        waitUntilElementIsVisible(By.xpath(usernameLabelXpath), 12000);
        WebElement usernameEl = driver.findElementByXPath(usernameLabelXpath);
        usernameEl.click();
        WebElement userInput = driver.findElementByXPath(usernameInputXpath);
        userInput.sendKeys(username);
        WebElement passwordEl = driver.findElementByXPath(passwordLabelXpath);
        passwordEl.click();
        WebElement passwordInput = driver.findElementByXPath(passwordInputXpath);
        passwordInput.sendKeys(password);
        WebElement login = driver.findElementByXPath(loginButtonXpath);
        login.click();
    }

    public void verifyErrorMessage() {
       waitUntilElementIsVisible(By.xpath(errorMessageXpath), 100);
        WebElement el = driver.findElementByXPath(errorMessageXpath);
        Assert.assertEquals(el.getText(), "Wrong Credentials");
    }

}
