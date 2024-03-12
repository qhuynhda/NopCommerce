package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;

public class User_04_Search_Advanced_Search extends BaseTest {
    WebDriver driver;
    private HomePageObject homepage;
    private LoginPageObject loginpage;
    private RegisterPageObject register;
    private SearchPageObject searchpage;
    private String emailAddress = getEmailAddress();

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        homepage = PageGeneratorManager.getHomePage(driver);
    }


    public void Register_Success() {
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

    public void Login_Success() {
        Register_Success();
        homepage.clickToHeaderLinkByText("Log in");
        loginpage = PageGeneratorManager.getLoginPage(driver);

        loginpage.enterToTextboxbyID("Email", emailAddress);
        loginpage.enterToTextboxbyID("Password", "123456");

        loginpage.clickToButtonByText("Log in");

        Assert.assertEquals(loginpage.getCurrentPageUrl(driver), "https://demo.nopcommerce.com/");
    }


    public void TC_01_Search_With_Empty_Data() {
        Login_Success();

        homepage = PageGeneratorManager.getHomePage(driver);
        homepage.clickToSearchFooter("Search");

        searchpage = PageGeneratorManager.getSearchPage(driver);
        searchpage.clickToButtonByText("Search");

        Assert.assertEquals(searchpage.getSearchErrorMsg("warning"), "Search term minimum length is 3 characters");

    }

    @Test
    public void TC_02_Search_With_Data_Not_Exist() {

        Login_Success();

        homepage = PageGeneratorManager.getHomePage(driver);
        homepage.clickToSearchFooter("Search");

        searchpage = PageGeneratorManager.getSearchPage(driver);
        searchpage.enterToSearchTextbox("Macbook Pro 2050");
        sleepInSeconds(3);
        searchpage.clickToButtonByText("Search");

        Assert.assertEquals(searchpage.getSearchErrorMsg("no-result"), "No products were found that matched your criteria.");


    }


    public void TC_03_Change_Password() {


    }


    public void TC_04_Add_Review_Product() {

    }

    @AfterClass
    public void afterClass() {

    }

}
