package pageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import pageUIs.SearchPageUI;

public class SearchPageObject extends BaseElement {
    WebDriver driver;

    public SearchPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }



    public void enterToSearchTextbox(String searchValue) {
        waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
        sendkeyToElement(driver, SearchPageUI.SEARCH_TEXTBOX, searchValue);
    }
}
