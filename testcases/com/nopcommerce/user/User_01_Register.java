package com.nopcommerce.user;

import commons.BaseElement;
import commons.BaseTest;
import commons.PageGeneratorManager;
import net.bytebuddy.build.Plugin;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class User_01_Register extends BaseTest {
    WebDriver driver;
    private HomePageObject homepage;
    private RegisterPageObject register;
    private String emailAddress = getEmailAddress();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homepage = PageGeneratorManager.getHomePage(driver);
    }


    public void TC_01_Register_With_Empty_Data() {
        homepage.clickToHeaderLinkByText("Register");
        register = PageGeneratorManager.getRegisterPage(driver);

        register.clickToButtonByText("Register");

        Assert.assertEquals(register.getTextErrorMsgByID("FirstName"), "First name is required.");
        Assert.assertEquals(register.getTextErrorMsgByID("LastName"), "Last name is required.");
        Assert.assertEquals(register.getTextErrorMsgByID("Email"), "Email is required.");
        Assert.assertEquals(register.getTextErrorMsgByID("Password"), "Password is required.");
        Assert.assertEquals(register.getTextErrorMsgByID("ConfirmPassword"), "Password is required.");

    }


    public void TC_02_Register_With_Invalid_Email() {
        homepage.clickToHeaderLinkByText("Register");
        register = PageGeneratorManager.getRegisterPage(driver);

        register.enterToTextboxbyID("FirstName", "Alice");
        register.enterToTextboxbyID("LastName", "Clinton");
        register.enterToTextboxbyID("Email", emailAddress);
        register.enterToTextboxbyID("Password", "123456");
        register.enterToTextboxbyID("ConfirmPassword", "123");

        register.clickToButtonByText("Register");


        Assert.assertEquals(register.getTextErrorMsgByID("ConfirmPassword"), "The password and confirmation password do not match.");
    }


    public void TC_03_Register_Success() {
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


    public void TC_04_Register_With_Email_Exit() {
        homepage.clickToHeaderLinkByText("Register");
        register = PageGeneratorManager.getRegisterPage(driver);

        register.enterToTextboxbyID("FirstName", "Alice");
        register.enterToTextboxbyID("LastName", "Clinton");
        register.enterToTextboxbyID("Email", emailAddress);
        register.enterToTextboxbyID("Password", "123456");
        register.enterToTextboxbyID("ConfirmPassword", "123456");

        register.clickToButtonByText("Register");

        Assert.assertEquals(register.getEmailExitMsgError(), "The specified email already exists");
    }

    public void TC_05_Register_With_Password_Under_6_Characters() {
        homepage.clickToHeaderLinkByText("Register");
        register = PageGeneratorManager.getRegisterPage(driver);

        register.enterToTextboxbyID("FirstName", "Alice");
        register.enterToTextboxbyID("LastName", "Clinton");
        register.enterToTextboxbyID("Email", emailAddress);
        register.enterToTextboxbyID("Password", "123");
        register.enterToTextboxbyID("ConfirmPassword", "123456");

        register.clickToButtonByText("Register");

        Assert.assertEquals(register.getTextErrorMsgByID("Password"), "Password must meet the following rules:\nmust have at least 6 characters");
    }

    public void TC_06_Register_With_ConfirmPassword_Unmatch_With_Password() {
        homepage.clickToHeaderLinkByText("Register");
        register = PageGeneratorManager.getRegisterPage(driver);

        register.enterToTextboxbyID("FirstName", "Alice");
        register.enterToTextboxbyID("LastName", "Clinton");
        register.enterToTextboxbyID("Email", emailAddress);
        register.enterToTextboxbyID("Password", "123456");
        register.enterToTextboxbyID("ConfirmPassword", "1234");

        register.clickToButtonByText("Register");

        Assert.assertEquals(register.getTextErrorMsgByID("ConfirmPassword"), "The password and confirmation password do not match.");
    }

    @AfterClass
    public void afterClass() {
        closeBrowser();
    }
}
