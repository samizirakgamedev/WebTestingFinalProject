package org.carefulchameleons.pom.myaccounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyWishListsPage extends MyAccountSharedPage {

    private final By NEW_WISH_LIST_INPUT = new By.ById("name");
    private final By SAVE_NEW_WISH_LIST_BUTTON = new By.ById("submitWishlist");

    // all wish lists
    private final By WISH_LISTS_TABLE = new By.ByClassName("table");

    private final By NO_PRODUCTS_ALERT = new By.ByClassName("alert-warning");

    private final By WISH_LIST_URL = new By.ByClassName("wishlisturl");
    private final By SEND_WISH_LIST_BUTTON = new By.ById("showSendWishlist");

    // specific wishlists items
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

    /**
     * Requires: {@link #hasWishLists()} to be true.
     *
     * @param index position in the list of WebElements from the wishlist table ('table' classname).
     *              index must be < {@link #getWishListSize()}
     *
     * @return {@link WebElement}, each element relates to a table entry
     */
    public WebElement getWishList(int index) {
        return webDriver.findElement(WISH_LISTS_TABLE)
                .findElements(By.tagName("tr"))
                .get(index);
    }

    /**
     * Requires: {@link #hasWishLists()} to be true.
     *
     * @param index position in the list of WebElements from the wishlist table ('table' classname).
     *              index must be < {@link #getWishListSize()}
     *
     * @return the name of the specified wishlist
     */
    public String getWishListName(int index) {
        return getWishList(index)
                .findElements(By.tagName("td"))
                .get(0)
                .findElement(By.tagName("a"))
                .getText();
    }

    /**
     * Requires: {@link #hasWishLists()} to be true.
     *
     * @param index position in the list of WebElements from the wishlist table ('table' classname).
     *              index must be < {@link #getWishListSize()}
     *
     * @return the quantity of the specified wishlist
     */
    public int getWishListQuantity(int index) {

        String stringQuantity = getWishList(index)
                .findElements(By.tagName("td"))
                .get(1)
                .getText();

        int quantity = Integer.parseInt(stringQuantity);

        return quantity;
    }

    /**
     * Requires: {@link #hasWishLists()} to be true.
     *
     * @param index position in the list of WebElements from the wishlist table ('table' classname).
     *              index must be < {@link #getWishListSize()}
     *
     * @return the times a user has viewed the specified wishlist
     */
    public int getWishListViewed(int index) {

        String stringViewed = getWishList(index)
                .findElements(By.tagName("td"))
                .get(2)
                .getText();

        int viewed = Integer.parseInt(stringViewed);

        return viewed;
    }

    /**
     * Requires: {@link #hasWishLists()} to be true.
     *
     * @param index position in the list of WebElements from the wishlist table ('table' classname).
     *              index must be < {@link #getWishListSize()}
     *
     * @return the created date of the specified wishlist
     */
    public String getWishListCreatedDate(int index) {

        String createdDate = getWishList(index)
                .findElements(By.tagName("td"))
                .get(3)
                .getText();

        return createdDate;
    }

    public MyWishListsPage clickWishListName(int index) {

        getWishList(index)
                .findElements(By.tagName("td"))
                .get(0)
                .findElement(By.tagName("a"))
                .click();

        return this;

    }

    /**
     * <p>Clicks the direct link for a specified wishlist</p>
     *
     * <p>Requires: {@link #hasWishLists()} to be true.</p>
     *
     * @param index position in the list of WebElements from the wishlist table ('table' classname).
     *              index must be < {@link #getWishListSize()}
     *
     * @return {@link MyWishListsPage}, as page doesn't change to allow chaining
     */
    public MyWishListsPage clickWishListDirectLink(int index) {

        getWishList(index)
                .findElement(By.linkText(" View "))
                .click();

        return this;
    }

    /**
     * <p>Clicks the delete button for a specified wishlist</p>
     *
     * <p>Requires: {@link #hasWishLists()} to be true.</p>
     *
     * @param index position in the list of WebElements from the wishlist table ('table' classname).
     *              index must be < {@link #getWishListSize()}
     *
     * @return {@link MyWishListsPage}, as page doesn't change to allow chaining
     */
    public MyWishListsPage deleteWishList(int index) {

        getWishList(index)
                .findElement(By.className("wishlist_delete"))
                .findElement(By.className("icon"))
                .click();

        return this;
    }

    /**
     * Requires: {@link #hasWishLists()} to be false.
     *
     * @return the error message relating to have no wishlists
     */
    public String getAlertMessage() {
        return webDriver.findElement(NO_PRODUCTS_ALERT).getText();
    }

    /**
     * @return true if a user has any wishlists, else false
     */
    public boolean hasWishLists() {
        return webDriver.findElements(WISH_LISTS_TABLE).size() != 0;
    }

    /**
     * @return amount of wishlists the user has
     */
    public int getWishListSize() {
        return webDriver.findElements(WISH_LISTS_TABLE).size();
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

    /**
     * Requires: {@link #clickWishListName(int)} or {@link #clickWishListDirectLink(int)} to be used
     * on a wishlist with quantity > 0
     *
     * @param index position of the product ('product_info' classname) in the list of WebElements from the
     *              wishlist items ('wlp_bought_list' classname)
     * @return {@link WebElement}, relating to the html for a product shown
     */
    public WebElement getWishListItem(int index) {
        return webDriver.findElement(WISH_LIST_ITEMS)
                .findElements(By.className("product_infos"))
                .get(index);
    }

    /**
     * Requires: {@link #clickWishListName(int)} or {@link #clickWishListDirectLink(int)} to be used
     * on a wishlist with quantity > 0
     *
     * @param index position of the product ('product_info' classname) in the list of WebElements from the
     *              wishlist items ('wlp_bought_list' classname)
     * @return name of a wishlist product
     */
    public String getWishListItemName(int index) {
        return getWishList(index)
                .findElement(By.id("s_title"))
                .getText();
    }

    /**
     * Requires: {@link #clickWishListName(int)} or {@link #clickWishListDirectLink(int)} to be used
     * on a wishlist with quantity > 0. Deletes a wishlist product
     *
     * @param index position of the product ('product_info' classname) in the list of WebElements from the
     *              wishlist items ('wlp_bought_list' classname)
     * @return {@link MyWishListsPage}, as page doesn't change to allow chaining
     */
    public MyWishListsPage deleteWishListItem(int index) {
        getWishList(index).findElement(By.className("lnkdel"))
                .click();

        return this;
    }

    /**
     * Requires: {@link #clickWishListName(int)} or {@link #clickWishListDirectLink(int)} to be used
     * on a wishlist with quantity > 0
     *
     * @param index position of the product ('product_info' classname) in the list of WebElements from the
     *              wishlist items ('wlp_bought_list' classname)
     * @return details of a wishlist product
     */
    public String getWishListItemDetail(int index) {
        return getWishList(index)
                .findElement(By.id("s_title"))
                .findElement(By.tagName("a"))
                .getText();
    }

    /**
     * Requires: {@link #clickWishListName(int)} or {@link #clickWishListDirectLink(int)} to be used
     * on a wishlist with quantity > 0
     *
     * @param index position of the product ('product_info' classname) in the list of WebElements from the
     *              wishlist items ('wlp_bought_list' classname)
     * @return quantity of a wishlist product
     */
    public int getWishListItemQuantity(int index) {

        String quantityString = getWishList(index)
                .findElement(By.className("wishlist_product_detail"))
                .findElement(By.tagName("input"))
                .getAttribute("value");

        int quantity = Integer.parseInt(quantityString);

        return quantity;
    }

    /**
     * <p>Allow changing of a wishlist item quantity</p>
     *
     * <p>Requires: {@link #clickWishListName(int)} or {@link #clickWishListDirectLink(int)} to be used
     * on a wishlist with quantity > 0.</p>
     *
     * @param index position of the product ('product_info' classname) in the list of WebElements from the
     *              wishlist items ('wlp_bought_list' classname)
     * @param quantity amount of wishlist products desired
     *
     * @return {@link MyWishListsPage}, as page doesn't change to allow chaining
     */
    public MyWishListsPage inputWishListItemQuantity(int index, String quantity) {

        WebElement element = getWishList(index)
                .findElement(By.className("wishlist_product_detail"))
                .findElement(By.tagName("input"));

        element.clear();
        element.sendKeys(quantity);

        return this;
    }

    /**
     * Requires: {@link #clickWishListName(int)} or {@link #clickWishListDirectLink(int)} to be used
     * on a wishlist with quantity > 0
     *
     * @param index position of the product ('product_info' classname) in the list of WebElements from the
     *              wishlist items ('wlp_bought_list' classname)
     * @return the wishlist product priority
     */
    public String getWishListItemPriority(int index) {

        Select priorityDropDown = new Select(
                getWishList(index)
                .findElement(By.className("wishlist_product_detail"))
                .findElement(By.tagName("select")));

        return priorityDropDown.getFirstSelectedOption().getText();
    }

    /**
     * <p>Allow changing of a wishlist item priority</p>
     *
     * <p>Requires: {@link #clickWishListName(int)} or {@link #clickWishListDirectLink(int)} to be used
     * on a wishlist with quantity > 0.</p>
     *
     * @param itemIndex position of the product ('product_info' classname) in the list of WebElements from the
     *                  wishlist items ('wlp_bought_list' classname)
     * @param priorityIndex the selected priority to change to
     *
     * @return {@link MyWishListsPage}, as page doesn't change to allow chaining
     */
    public MyWishListsPage selectWishListItemPriorityByIndex(int itemIndex, int priorityIndex) {

        Select priorityDropDown = new Select(
                getWishList(itemIndex)
                .findElement(By.className("wishlist_product_detail"))
                .findElement(By.tagName("select")));

        priorityDropDown.selectByIndex(priorityIndex);

        return this;
    }

    /**
     * <p>Allows saving of changes for a wishlist item</p>
     *
     * <p>Requires: {@link #clickWishListName(int)} or {@link #clickWishListDirectLink(int)} to be used
     * on a wishlist with quantity > 0. </p>
     *
     * @param index position of the product ('product_info' classname) in the list of WebElements from the
     *                  wishlist items ('wlp_bought_list' classname)
     *
     * @return {@link MyWishListsPage}, as page doesn't change to allow chaining
     */
    public MyWishListsPage clickWishListItemSaveButton(int index) {

        getWishList(index)
                .findElement(By.className("btn_action"))
                .findElement(By.className("btn"))
                .click();

        return this;
    }

    /**
     * <p>Allows input of an email to a specified index</p>
     *
     * <p>Requires: {@link #clickSendWishListToEmailButton()} to be clicked. </p>
     *
     * @param index position of the product ('product_info' classname) in the list of WebElements from the
     *                  wishlist items ('wlp_bought_list' classname)
     * @param email email to input
     *
     * @return {@link MyWishListsPage}, as page doesn't change to allow chaining
     */
    public MyWishListsPage inputIntoWishListSendToEmail(int index, String email) {

        WebElement element = webDriver.findElement(WISH_LIST_SEND_INPUT)
                .findElements(By.className("form-control"))
                .get(index);

        element.clear();
        element.sendKeys(email);

        return this;

    }

    /**
     * <p>Clicks the send wishlist to email button</p>
     *
     * <p>Requires: {@link #clickSendWishListToEmailButton()} to be clicked. </p>
     *
     * @return {@link MyWishListsPage}, as page doesn't change to allow chaining
     */
    public MyWishListsPage clickSendWishListToEmailButton() {

       webDriver.findElement(WISH_LIST_SEND_INPUT)
                .findElement(By.name("submitWishlist"))
                .click();

        return this;
    }
}
