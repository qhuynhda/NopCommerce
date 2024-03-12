package commons;

import org.openqa.selenium.WebDriver;
import pageUIs.BaseElementUI;
import pageUIs.CustomerInfoPageUI;
import pageUIs.SearchPageUI;

public class BaseElement extends BasePage{
    WebDriver driver;
    public BaseElement(WebDriver driver) {
        this.driver = driver;
    }

    public void  clickToHeaderLinkByText(String headerLink) {
        waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_NAME_BY_TEXT,headerLink);
        clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_NAME_BY_TEXT,headerLink);
    }
    public String getTextErrorMsgByID(String errorMsgID) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_ERROR_MSG_BY_ID,errorMsgID);
        return getElementText(driver, BaseElementUI.DYNAMIC_ERROR_MSG_BY_ID,errorMsgID);

    }

    public void enterToTextboxbyID(String textboxID, String enterValue) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,textboxID);
        sendkeyToElement(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,enterValue,textboxID);
    }
    public void clickToButtonByText(String buttonText) {
        waitForElementClickable(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
        clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
    }

    public void selectBirthComboboxByName(String itemValue, String nameValue) {
        selectItemInDefaultDropdown(driver, BaseElementUI.DYNAMIC_COMBOBOX_BIRTH_BY_NAME,itemValue, nameValue);
    }

    public void clickToGenderElement(String femaleClass) {
        clickToElement(driver, BaseElementUI.DYNAMIC_GENDER_CHECKBOX_BY_ID,femaleClass);
    }

    public void selectAddressComboboxbyID(String selectedValue, String comboboxID) {
        selectItemInDefaultDropdown(driver, BaseElementUI.DYNAMIC_ADDRESS_COMBOBOX_BY_ID,selectedValue,comboboxID);

    }

    public void clickToListboxByText(String listboxText) {
       waitForElementClickable(driver, BaseElementUI.DYNAMIC_LISTBOX_HREF_BY_TEXT,listboxText);
        clickToElement(driver, BaseElementUI.DYNAMIC_LISTBOX_HREF_BY_TEXT,listboxText);
    }
    public String getSuccessfullUpdateMsgByText(String pageText) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_SUCCESS_PAGE_MSG_BY_TEXT,pageText);
        return getElementText(driver, BaseElementUI.DYNAMIC_SUCCESS_PAGE_MSG_BY_TEXT,pageText);
    }

    public String getAddedAddressTextboxByClass(String classValue) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_ADDED_ADDRESS_TEXT_BY_CLASS,classValue);
        return getElementText(driver, BaseElementUI.DYNAMIC_ADDED_ADDRESS_TEXT_BY_CLASS, classValue);
    }

    public void clickToTopMenu(String topMenuText) {
        waitForElementClickable(driver,BaseElementUI.DYNAMIC_TOP_MENU_NOTMOBILE_BY_TEXT, topMenuText);
        clickToElement(driver, BaseElementUI.DYNAMIC_TOP_MENU_NOTMOBILE_BY_TEXT, topMenuText);
    }
    public void enterReviewTextboxByID(String textboxReviewID, String textboxReviewData) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_REVIEW_TEXTBOX_BY_ID,textboxReviewID);
        sendkeyToElement(driver, BaseElementUI.DYNAMIC_REVIEW_TEXTBOX_BY_ID, textboxReviewData,textboxReviewID);
    }

    public String getReviewbyClass(String reviewClass) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_REVIEW_TEXT_VERIFY_BY_CLASS,reviewClass);
        return getElementText(driver, BaseElementUI.DYNAMIC_REVIEW_TEXT_VERIFY_BY_CLASS, reviewClass);

    }

    public void clickToSearchFooter(String footerLinkText) {
        waitForElementClickable(driver,BaseElementUI.DYNAMIC_FOOTER_LINK_BY_TEXT, footerLinkText);
        clickToElement(driver, BaseElementUI.DYNAMIC_FOOTER_LINK_BY_TEXT, footerLinkText);
    }
    public String getSearchErrorMsg(String searchClass) {
        waitForElementVisible(driver, BaseElementUI.DYNAMIC_SEARCH_ERROR_MSG_BY_CLASS, searchClass);
        return getElementText(driver,BaseElementUI.DYNAMIC_SEARCH_ERROR_MSG_BY_CLASS, searchClass);
    }
}
