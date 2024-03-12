package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageGeneratorManager {
    public static HomePageObject getHomePage(WebDriver driver){
        return  new HomePageObject(driver);
    }
    public static LoginPageObject getLoginPage(WebDriver driver){
        return  new LoginPageObject(driver);
    }
    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return  new RegisterPageObject(driver);
    }
    public static WishlistPageObject getWishlistPage(WebDriver driver){
        return  new WishlistPageObject(driver);
    }

    public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver){
        return  new ShoppingCartPageObject(driver);
    }

    public static CustomerInfoPageObject getMyAccountPage(WebDriver driver) {
        return new CustomerInfoPageObject(driver);
    }
    public static AddressesPageObject getAddressPage(WebDriver driver) {
        return new AddressesPageObject(driver);
    }
    public static ProductDetailPageObject getProductDetailPage(WebDriver driver) {
        return new ProductDetailPageObject(driver);
    }
    public static ComputerPageObject getComputerPage(WebDriver driver) {
        return new ComputerPageObject(driver);
    }
    public static DesktopPageObject getDesktopPage(WebDriver driver) {
        return new DesktopPageObject(driver);
    }

    public static ProductReviewPageObject getProductReviewPage(WebDriver driver) {
        return new ProductReviewPageObject(driver);
    }
    public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
        return new CustomerInfoPageObject(driver);
    }
    public static SearchPageObject getSearchPage(WebDriver driver) {
        return new SearchPageObject(driver);
    }
}
