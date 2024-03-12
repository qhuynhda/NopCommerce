package pageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import pageUIs.AddressesPageUI;

public class AddressesPageObject extends BaseElement {
    WebDriver driver;
    public AddressesPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToCloseBannerButton() {
        waitForElementClickable(driver, AddressesPageUI.CLOSE_BUTTON);
        clickToElement(driver, AddressesPageUI.CLOSE_BUTTON);
       // waitForElementInVisible(driver, AddressesPageUI.CLOSE_BUTTON);
    }
}
