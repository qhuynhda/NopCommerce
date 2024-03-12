package pageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BaseElement {
    WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public String getNotExitEmailTextboxError() {
        waitForElementVisible(driver, LoginPageUI.WRONG_EMAIL_TEXTBOX_ERROR);
        return getElementText(driver, LoginPageUI.WRONG_EMAIL_TEXTBOX_ERROR);
    }
}
