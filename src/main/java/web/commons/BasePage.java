package web.commons;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.utilities.PropertyReader;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected Logger logger;
    protected PropertyReader propertyReader = new PropertyReader(GlobalConstants.CONFIG_FILE_KEY);
    protected final WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        logger = LogManager.getLogger(getClass());
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public WebElement getElement(WebDriver driver, By by) {
        return driver.findElement(by);
    }

    public List<WebElement> getElements(WebDriver driver, By by) {
        return driver.findElements(by);
    }

    public String getElementText(WebDriver driver, By by) {
        return getElement(driver, by).getText();
    }

    public String getElementText(WebElement el) {
        return el.getText();
    }
    public String getElementValue(WebDriver driver, By by) {
        return getElement(driver, by).getAttribute("value");
    }

    public String getElementValue(WebElement el) {
        return el.getAttribute("value");
    }


    public void sendKeyToElement(WebDriver driver, By by, String value) {
        getElement(driver, by).clear();
        getElement(driver, by).sendKeys(value);
    }

    public void sendKeyToElement(WebElement el, String value) {
        el.clear();
        el.sendKeys(value);
    }

    public void clickToElement(WebDriver driver, By by) {
        getElement(driver, by).click();
    }

    public void clickToElement(WebElement element) {
        element.click();
    }

    public void clickToElementByJavaScript(WebDriver driver, By by) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",  getElement(driver, by));
    }

    public void clickToElementByJavaScript(WebDriver driver, WebElement el) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",  el);
    }


    public String getTitleByJavaScript(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        return  js.executeScript("return document.title;").toString();
    }

    @Step("Scroll by JS")
    public void scrollByJavaScript(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


    public boolean isElementDisplayed(WebDriver driver, By by) {
        return getElement(driver, by).isDisplayed();
    }

    public boolean isElementDisplayed(WebElement el) {
        return el.isDisplayed();
    }

    public void waitForElementUntilClickable(WebDriver driver, By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(propertyReader.getValue(GlobalConstants.LONG_TIMEOUT_KEY)));
            wait.until(ExpectedConditions.elementToBeClickable(by));

        } catch (Exception e) {
            logger.error("Element not clickable");
        }
    }

    public void waitForElementUntilClickable(WebDriver driver, WebElement el) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(propertyReader.getValue(GlobalConstants.LONG_TIMEOUT_KEY)));
            wait.until(ExpectedConditions.elementToBeClickable(el));

        } catch (Exception e) {
            logger.error("Element not clickable");
        }
    }

    public boolean isAlertPresent(WebDriver driver){
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(propertyReader.getValue(GlobalConstants.LONG_TIMEOUT_KEY)));

        try {
            logger.debug("Alert found");
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException eTO) {
            logger.error("Alert not found");
            foundAlert = false;
        }

        return foundAlert;
    }

    public  void acceptAlert(WebDriver driver){
        driver.switchTo().alert().accept();
    }

    public void moveToElement(WebDriver driver, By by){
        Actions action = new Actions(driver);
        action.moveToElement(getElement(driver, by)).perform();
    }

    public void moveToElement(WebDriver driver, WebElement el){
        Actions action = new Actions(driver);
        action.moveToElement(el).perform();
    }

    public String getCssValue(WebDriver driver, By by, String css) {
        return getElement(driver, by).getCssValue(css);
    }

    public String getCssValue(WebElement el, String css) {
        return el.getCssValue(css);
    }

    public void staticWait(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            logger.info("Error in staticWait" + e);
        }
    }

    public WebElement findAndHighLightElement(WebDriver driver, By by) {
        WebElement elem = driver.findElement(by);
        // draw a border around the found element
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
        }
        return elem;
    }

    public WebElement findAndHighLightElement(WebDriver driver, WebElement el) {

        // draw a border around the found element
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", el);
        }
        return el;
    }

    public void clickAndHighLightToElement(WebDriver driver, By by) {
        findAndHighLightElement(driver, by).click();
    }

    public void clickAndHighLightToElement(WebDriver driver, WebElement el) {
        findAndHighLightElement(driver, el).click();
    }
}
