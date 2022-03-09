package org.carefulchameleons.pom.myaccounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyWishListsPage extends MyAccountSharedPage {

    private final By NEW_WISH_LIST_INPUT = new By.ById("name");
    private final By SAVE_NEW_WISH_LIST_BUTTON = new By.ById("submitWishlist");

    private final By WISH_LISTS_TABLE = new By.ByClassName("table");

    private final By NO_PRODUCTS_ALERT = new By.ByClassName("alert-warning");

    private final By WISH_LIST_URL = new By.ByClassName("wishlisturl");
    private final By SEND_WISH_LIST_BUTTON = new By.ById("showSendWishlist");

    private final By WISH_LIST_ITEMS = new By.ByClassName("wlp_bought_list");
    private final By WISH_LIST_SEND_INPUT = new By.ByClassName("wl_send");


    public MyWishListsPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist");
    }

    public MyWishListsPage inputNewWishListName(String name) {
        webDriver.findElement(NEW_WISH_LIST_INPUT).sendKeys(name);
        return this;
    }

    public MyWishListsPage saveNewWishList() {
        webDriver.findElement(SAVE_NEW_WISH_LIST_BUTTON).click();
        return this;
    }

    public WebElement getWishList(int index) {
        return webDriver.findElement(WISH_LISTS_TABLE)
                .findElements(By.tagName("tr"))
                .get(index);
    }

    public String getWishListName(int index) {
        return getWishList(index)
                .findElements(By.tagName("td"))
                .get(0)
                .findElement(By.tagName("a"))
                .getText();
    }

    public int getWishListQuantity(int index) {

        String stringQuantity = getWishList(index)
                .findElements(By.tagName("td"))
                .get(1)
                .getText();

        int quantity = Integer.parseInt(stringQuantity);

        return quantity;
    }

    public int getWishListViewed(int index) {

        String stringViewed = getWishList(index)
                .findElements(By.tagName("td"))
                .get(2)
                .getText();

        int viewed = Integer.parseInt(stringViewed);

        return viewed;
    }

    public String getWishListCreatedDate(int index) {

        String createdDate = getWishList(index)
                .findElements(By.tagName("td"))
                .get(3)
                .getText();

        return createdDate;
    }

    public MyWishListsPage clickWishListDirectLink(int index) {

        getWishList(index)
                .findElement(By.linkText(" View "))
                .click();

        return this;
    }

    public MyWishListsPage deleteWishList(int index) {

        getWishList(index)
                .findElement(By.className("wishlist_delete"))
                .findElement(By.className("icon"))
                .click();

        return this;
    }

    public String getAlertMessage() {
        return webDriver.findElement(NO_PRODUCTS_ALERT).getText();
    }

    public boolean hasWishLists() {
        return webDriver.findElements(WISH_LISTS_TABLE).size() != 0;
    }

    public String getWishListURL() {
        return webDriver.findElement(WISH_LIST_URL)
                .findElement(By.className("form-control"))
                .getAttribute("value");
    }

    public MyWishListsPage clickSendThisWishList() {
        webDriver.findElement(SEND_WISH_LIST_BUTTON).click();
        return this;
    }

    public WebElement getWishListItem(int index) {
        return webDriver.findElement(WISH_LIST_ITEMS)
                .findElements(By.className("product_infos"))
                .get(index);
    }

    public String getWishListItemName(int index) {
        return getWishList(index)
                .findElement(By.id("s_title"))
                .getText();
    }

    public MyWishListsPage deleteWishListItem(int index) {
        getWishList(index).findElement(By.className("lnkdel"))
                .click();

        return this;
    }

    public String getWishListItemDetail(int index) {
        return getWishList(index)
                .findElement(By.id("s_title"))
                .findElement(By.tagName("a"))
                .getText();
    }

    public int getWishListItemQuantity(int index) {

        String quantityString = getWishList(index)
                .findElement(By.className("wishlist_product_detail"))
                .findElement(By.tagName("input"))
                .getAttribute("value");

        int quantity = Integer.parseInt(quantityString);

        return quantity;
    }

    public MyWishListsPage inputWishListItemQuantity(int index, String quantity) {

        WebElement element = getWishList(index)
                .findElement(By.className("wishlist_product_detail"))
                .findElement(By.tagName("input"));

        element.clear();
        element.sendKeys(quantity);

        return this;
    }

    public String getWishListItemPriority(int index) {

        Select priorityDropDown = new Select(
                getWishList(index)
                .findElement(By.className("wishlist_product_detail"))
                .findElement(By.tagName("select")));

        return priorityDropDown.getFirstSelectedOption().getText();
    }

    public MyWishListsPage selectWishListItemPriorityByIndex(int itemIndex, int priorityIndex) {

        Select priorityDropDown = new Select(
                getWishList(itemIndex)
                .findElement(By.className("wishlist_product_detail"))
                .findElement(By.tagName("select")));

        priorityDropDown.selectByIndex(priorityIndex);

        return this;
    }

    public MyWishListsPage clickWishListItemSaveButton(int index) {

        getWishList(index)
                .findElement(By.className("btn_action"))
                .findElement(By.className("btn"))
                .click();

        return this;
    }

    public MyWishListsPage inputIntoWishListSendToEmail(int index, String email) {

        WebElement element = webDriver.findElement(WISH_LIST_SEND_INPUT)
                .findElements(By.className("form-control"))
                .get(index);

        element.clear();
        element.sendKeys(email);

        return this;

    }

    public MyWishListsPage clickSendWishListToEmailButton() {

       webDriver.findElement(WISH_LIST_SEND_INPUT)
                .findElement(By.name("submitWishlist"))
                .click();

        return this;

    }



}
