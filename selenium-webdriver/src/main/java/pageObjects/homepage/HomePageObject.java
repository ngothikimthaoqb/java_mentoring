package pageObjects.homepage;

import commons.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BasePage {

    public final By button = By.xpath("//li/a[text()='Buttons']");
    public final By checkbox = By.xpath("//li/a[text()='Checkbox']");
    public final By datepicker = By.xpath("//li/a[text()='Datepicker']");

    private final WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
}
