package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import pageUIs.LoginPageUI;

public class User_02_Login extends BaseTest {

    WebDriver driver;
    private HomePageObject homepage;
    private LoginPageObject loginpage;
    private RegisterPageObject register;
    private String emailAddress = getEmailAddress();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homepage = PageGeneratorManager.getHomePage(driver);
    }


    public void TC_01_Login_With_Empty_Data() {
        homepage.clickToHeaderLinkByText("Log in");
        loginpage = PageGeneratorManager.getLoginPage(driver);

        //loginpage.enterToTextboxbyID("Email",emailAddress);
        // loginpage.enterToTextboxbyID("Password","123456");
        loginpage.clickToButtonByText("Log in");

        Assert.assertEquals(loginpage.getTextErrorMsgByID("Email"), "Please enter your email");

    }


    public void TC_02_Login_With_Invalid_Email() {
        homepage.clickToHeaderLinkByText("Log in");
        loginpage = PageGeneratorManager.getLoginPage(driver);

        loginpage.enterToTextboxbyID("Email", "abc");

        loginpage.clickToButtonByText("Log in");

        Assert.assertEquals(loginpage.getTextErrorMsgByID("Email"), "Wrong email");

    }


    public void TC_03_Login_With_Unregistered_Email() {
        homepage.clickToHeaderLinkByText("Log in");
        loginpage = PageGeneratorManager.getLoginPage(driver);

        loginpage.enterToTextboxbyID("Email", "abc@gmail.com");
        loginpage.clickToButtonByText("Log in");

        Assert.assertEquals(loginpage.getNotExitEmailTextboxError(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
    }

    public void Precondition_Register_Success() {
        homepage.clickToHeaderLinkByText("Register");
        register = PageGeneratorManager.getRegisterPage(driver);

        register.enterToTextboxbyID("FirstName", "Alice");
        register.enterToTextboxbyID("LastName", "Clinton");
        register.enterToTextboxbyID("Email", emailAddress);
        register.enterToTextboxbyID("Password", "123456");
        register.enterToTextboxbyID("ConfirmPassword", "123456");

        register.clickToButtonByText("Register");


        Assert.assertEquals(register.getRegisterSuccessMsg(), "Your registration completed");
    }

    public void TC_04_Login_With_Registered_Email_Empty_Password() {
        Precondition_Register_Success();
        homepage.clickToHeaderLinkByText("Log in");
        loginpage = PageGeneratorManager.getLoginPage(driver);

        loginpage.enterToTextboxbyID("Email", emailAddress);
        loginpage.clickToButtonByText("Log in");

        Assert.assertEquals(loginpage.getNotExitEmailTextboxError(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

    }


    public void TC_05_Login_With_Registered_Email_And_Wrong_Password() {
        Precondition_Register_Success();
        homepage.clickToHeaderLinkByText("Log in");
        loginpage = PageGeneratorManager.getLoginPage(driver);

        loginpage.enterToTextboxbyID("Email", emailAddress);
        loginpage.enterToTextboxbyID("Password", "123");

        loginpage.clickToButtonByText("Log in");

        Assert.assertEquals(loginpage.getNotExitEmailTextboxError(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
    }


    public void TC_06_Login_Success() {
        Precondition_Register_Success();
        homepage.clickToHeaderLinkByText("Log in");
        loginpage = PageGeneratorManager.getLoginPage(driver);

        loginpage.enterToTextboxbyID("Email", emailAddress);
        loginpage.enterToTextboxbyID("Password", "123456");

        loginpage.clickToButtonByText("Log in");

        Assert.assertEquals(loginpage.getCurrentPageUrl(driver), "https://demo.nopcommerce.com/");
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
