package pageUIs;

public class BaseElementUI {
    public static final String DYNAMIC_ERROR_MSG_BY_ID = "id=%s-error";
    public static final String DYNAMIC_HEADER_LINK_NAME_BY_TEXT = "xpath=//div[@class='header-links']//a[contains(string(),'%s')]";
    public static final String UPLOAD_FILE_TYPE = "css=input[name='files[]']";
    public static final String DYNAMIC_TEXTBOX_BY_ID = "id=%s";
    public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
    public static final String DYNAMIC_COMBOBOX_BIRTH_BY_NAME = "name=%s";
    public static final String DYNAMIC_GENDER_CHECKBOX_BY_ID ="xpath=//label[@class='forcheckbox']/preceding-sibling::input[@id='gender-%s']";
    public static final String DYNAMIC_ADDRESS_COMBOBOX_BY_ID="id=%s";
    public static final String DYNAMIC_LISTBOX_HREF_BY_TEXT="xpath=//div[@class='side-2']//a[text()='%s']";
    public static final String DYNAMIC_SUCCESS_PAGE_MSG_BY_TEXT="xpath=//h1[contains(text(),'My account - %s')]/ancestor::div[@class='master-wrapper-page']/preceding-sibling::div[@id='bar-notification']//p";
    public static final String DYNAMIC_ADDED_ADDRESS_TEXT_BY_CLASS="xpath=//ul[@class='info']/li[@class='%s']";
    public static final String DYNAMIC_TOP_MENU_NOTMOBILE_BY_TEXT="xpath=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
    public static final String DYNAMIC_REVIEW_TEXTBOX_BY_ID="id=%s";
    public static final String DYNAMIC_REVIEW_TEXT_VERIFY_BY_CLASS="class=review-%s";
    public static final String DYNAMIC_FOOTER_LINK_BY_TEXT="xpath=//div[@class='footer']//a[contains(text(),'%s')]";
    public static final String DYNAMIC_SEARCH_ERROR_MSG_BY_CLASS="xpath=//div[@class='products-wrapper']/div[@class='%s']";
}
