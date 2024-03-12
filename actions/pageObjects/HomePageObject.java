package pageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends BaseElement {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }



}
