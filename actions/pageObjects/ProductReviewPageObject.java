package pageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import pageUIs.BaseElementUI;
import pageUIs.ProductReviewPageUI;

public class ProductReviewPageObject extends BaseElement {
    WebDriver driver;
    public ProductReviewPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public String getMsgReviewSuccess() {
        waitForElementVisible(driver, ProductReviewPageUI.PRODUCT_REVIEW_ADDED_SUCCESS);
        return getElementText(driver, ProductReviewPageUI.PRODUCT_REVIEW_ADDED_SUCCESS);
    }
}
