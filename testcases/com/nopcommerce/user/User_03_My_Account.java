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

public class User_03_My_Account extends BaseTest {
    WebDriver driver;
    private HomePageObject homepage;
    private LoginPageObject loginpage;
    private RegisterPageObject register;
    private CustomerInfoPageObject customerinfo;
    private AddressesPageObject address;
    private ComputerPageObject computer;
    private DesktopPageObject desktop;
    private ProductDetailPageObject productdetail;
    private ProductReviewPageObject productreviews;
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


    public void TC_01_Update_Customer_Info_Success() {
        Login_Success();

        homepage = PageGeneratorManager.getHomePage(driver);
        homepage.clickToHeaderLinkByText("My account");

        customerinfo = PageGeneratorManager.getMyAccountPage(driver);

        Assert.assertEquals(customerinfo.getPageAccountTitle(), "My account - Customer info");

        customerinfo.clickToGenderElement("female");

        customerinfo.enterToTextboxbyID("FirstName", "Automation");
        customerinfo.enterToTextboxbyID("LastName", "FC");

        customerinfo.selectBirthComboboxByName("Day", "DateOfBirthDay");
        customerinfo.selectBirthComboboxByName("January", "DateOfBirthMonth");
        customerinfo.selectBirthComboboxByName("1999", "DateOfBirthYear");


        customerinfo.enterToTextboxbyID("Email", emailAddress);
        customerinfo.enterToTextboxbyID("Company", "Automation FC");

        customerinfo.clickToButtonByText("Save");
        Assert.assertEquals(customerinfo.getSuccessfullUpdateMsgByText("Customer info"), "The customer info has been updated successfully.");

    }


    public void TC_02_Add_New_Addresses_Info_Success() {
        //can phai lam dynamic cho click listbox
        customerinfo.clickToListboxByText("Addresses");

        address = PageGeneratorManager.getAddressPage(driver);

        address.clickToButtonByText("Add new");

        address.enterToTextboxbyID("Address_FirstName", "Automation");
        address.enterToTextboxbyID("Address_LastName", "FC");

        address.enterToTextboxbyID("Address_Email", "automationfc93.vn@gmail.com");
        address.enterToTextboxbyID("Address_Company", "Automation FC");


        address.selectAddressComboboxbyID("Viet Nam", "Address_CountryId");
        address.selectAddressComboboxbyID("Other", "Address_StateProvinceId");

        address.enterToTextboxbyID("Address_City", "Da Nang");
        address.enterToTextboxbyID("Address_Address1", "123/04 Le Lai");
        address.enterToTextboxbyID("Address_Address2", "234/05 Hai Phong");
        address.enterToTextboxbyID("Address_ZipPostalCode", "550000");
        address.enterToTextboxbyID("Address_PhoneNumber", "0123456789");
        address.enterToTextboxbyID("Address_FaxNumber", "0987654321");

        address.clickToButtonByText("Save");
        Assert.assertEquals(address.getSuccessfullUpdateMsgByText("Addresses"), "The new address has been added successfully.");

        Assert.assertEquals(address.getAddedAddressTextboxByClass("name"), "Automation FC");
        Assert.assertEquals(address.getAddedAddressTextboxByClass("email"), "Email: automationfc93.vn@gmail.com");
        Assert.assertEquals(address.getAddedAddressTextboxByClass("phone"), "Phone number: 0123456789");
        Assert.assertEquals(address.getAddedAddressTextboxByClass("fax"), "Fax number: 0987654321");
        Assert.assertEquals(address.getAddedAddressTextboxByClass("company"), "Automation FC");
        Assert.assertEquals(address.getAddedAddressTextboxByClass("address1"), "123/04 Le Lai");
        Assert.assertEquals(address.getAddedAddressTextboxByClass("address2"), "234/05 Hai Phong");
        Assert.assertEquals(address.getAddedAddressTextboxByClass("city-state-zip"), "Da Nang, 550000");
        Assert.assertEquals(address.getAddedAddressTextboxByClass("country"), "Viet Nam");

    }


    public void TC_03_Change_Password() {
        address.clickToListboxByText("Change password");
        address.enterToTextboxbyID("OldPassword", "123456");
        address.enterToTextboxbyID("NewPassword", "654321");
        address.enterToTextboxbyID("ConfirmNewPassword", "654321");

        address.clickToButtonByText("Change password");

        Assert.assertEquals(address.getSuccessfullUpdateMsgByText("Change password"), "Password was changed");

        address.clickToCloseBannerButton();
        address.clickToHeaderLinkByText("Log out");
        homepage.clickToHeaderLinkByText("Log in");
        loginpage = PageGeneratorManager.getLoginPage(driver);

        loginpage.enterToTextboxbyID("Email", "automationfc93.vn@gmail.com");
        loginpage.enterToTextboxbyID("Password", "123456");

        loginpage.clickToButtonByText("Log in");
        Assert.assertEquals(loginpage.getNotExitEmailTextboxError(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
        loginpage.enterToTextboxbyID("Password", "654321");
        loginpage.clickToButtonByText("Log in");

//        Assert.assertEquals(loginpage.getCurrentPageUrl(driver), "https://demo.nopcommerce.com/");

    }

    @Test
    public void TC_04_Add_Review_Product() {
        Login_Success();

        loginpage.clickToTopMenu("Computers");

        computer = PageGeneratorManager.getComputerPage(driver);
        computer.clickToDesktopImage();

        desktop = PageGeneratorManager.getDesktopPage(driver);
        desktop.clickToFirstImage();

        productdetail = PageGeneratorManager.getProductDetailPage(driver);
        productdetail.clickToAddYourReviewLink();

        productreviews = PageGeneratorManager.getProductReviewPage(driver);
        productreviews.enterReviewTextboxByID("AddProductReview_Title", "Title Review");
        productreviews.enterReviewTextboxByID("AddProductReview_ReviewText", "Text ReviewF");
        productreviews.clickToButtonByText("Submit review");
        Assert.assertEquals(productreviews.getMsgReviewSuccess(), "Product review is successfully added.");
        productreviews.clickToHeaderLinkByText("My account");

        productreviews.clickToListboxByText("My product reviews");

        Assert.assertEquals(productreviews.getReviewbyClass("title"), "Title Review");
        Assert.assertEquals(productreviews.getReviewbyClass("text"), "Text ReviewF");
        Assert.assertTrue(productreviews.getReviewbyClass("info").contains("Build your own computer"));
    }

    @AfterClass
    public void afterClass() {

    }

}
