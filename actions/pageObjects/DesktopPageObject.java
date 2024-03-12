package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ComputerPageUI;
import pageUIs.DesktopPageUI;

public class DesktopPageObject extends BasePage {
    WebDriver driver;

    public DesktopPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToFirstImage() {
        waitForElementVisible(driver, DesktopPageUI.DESKTOP_PICTURE);
        clickToElement(driver, DesktopPageUI.DESKTOP_PICTURE);
    }
}
