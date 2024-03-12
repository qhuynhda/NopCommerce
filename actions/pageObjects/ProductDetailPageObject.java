package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoPageUI;
import pageUIs.ProductDetailPageUI;

public class ProductDetailPageObject extends BasePage {
    WebDriver driver;
    public ProductDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddYourReviewLink() {
        waitForElementClickable(driver, ProductDetailPageUI.ADD_YOUR_REVIEW_LINK_TEXT);
        clickToElement(driver, ProductDetailPageUI.ADD_YOUR_REVIEW_LINK_TEXT);
    }
}
