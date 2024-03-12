package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.ComputerPageUI;

public class ComputerPageObject extends BasePage{
    WebDriver driver;
    public ComputerPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToDesktopImage() {
        waitForElementVisible(driver, ComputerPageUI.DESKTOP_IMAGE);
        clickToElement(driver, ComputerPageUI.DESKTOP_IMAGE);
    }
}
