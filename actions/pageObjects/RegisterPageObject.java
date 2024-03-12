package pageObjects;

import commons.BaseElement;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BaseElement {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }




    public String getRegisterSuccessMsg() {
        waitForElementVisible(driver,RegisterPageUI.RESULT_SUCCESS_MSG);
        return getElementText(driver, RegisterPageUI.RESULT_SUCCESS_MSG);
    }

    public String  getEmailExitMsgError() {
        waitForElementVisible(driver,RegisterPageUI.ERROR_MSG_EMAIL_EXIT);
        return getElementText(driver, RegisterPageUI.ERROR_MSG_EMAIL_EXIT);
    }
}
