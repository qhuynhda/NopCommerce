package pageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BaseElement {
    WebDriver driver;
    public CustomerInfoPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public String getPageAccountTitle() {
        waitForElementVisible(driver, CustomerInfoPageUI.PAGE_TITLE);
        return getElementText(driver, CustomerInfoPageUI.PAGE_TITLE);
    }

}
