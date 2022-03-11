package org.carefulchameleons.pom;

import org.carefulchameleons.pom.enums.ColourSelection;
import org.carefulchameleons.pom.enums.SizeSelection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends Page{
    private static final By
            QUANTITY_UP = new By.ByClassName("product_quantity_up"),
            QUANTITY_DOWN = new By.ByClassName("product_quantity_down"),
            SIZE_DROPDOWN = new By.ById("group_1"),
            ADD_TO_WISHLIST = new By.ById("wishlist_button"),
            SEND_TO_A_FRIEND = new By.ById("send_friend_button"),
            NAME_OF_YOUR_FRIEND = new By.ById("friend_name"),
            EMAIL_ADDRESS_OF_YOUR_FRIEND = new By.ById("friend_email"),
            SEND_EMAIL = new By.ById("sendEmail"),
            BIG_PICTURE = new By.ById("bigpic"),
            NEXT_BUTTON = new By.ByClassName("fancybox-next"),
            PREVIOUS_BUTTON = new By.ByClassName("fancybox-previous"),
            ADD_TO_CART = new By.ById("add_to_cart"),
            CLOSE_BUTTON = new By.ByClassName("fancybox-close");

    public ProductPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    /**
     * Presses the + button next to the quantity
     * @return this, for fluidity
     */
    public ProductPage increaseQuantity() {
        webDriver.findElement(QUANTITY_UP).click();
        return this;
    }

    /**
     * Presses the - button next to the quantity
     * @return this, for fluidity
     */
    public ProductPage decreaseQuantity() {
        webDriver.findElement(QUANTITY_DOWN).click();
        return this;
    }

    /**
     * Selects the given size from the dropdown list
     * @param s The size to select
     * @return this, for fluidity
     */
    public ProductPage selectSize(SizeSelection s) {
        (new Select(webDriver.findElement(SIZE_DROPDOWN))).selectByValue(String.format("%d", s.ID));
        return this;
    }

    /**
     * Selects the given colour from the right
     * @param c The colour to select
     * @return this, for fluidity
     */
    public ProductPage selectColour(ColourSelection c) {
        webDriver.findElement(new By.ById(String.format("color_%d", c.ID))).click();
        return this;
    }

    /**
     * Clicks the "Add to wishlist" button
     * @return this, for fluidity
     */
    public ProductPage addToWishlist() {
        webDriver.findElement(ADD_TO_WISHLIST).click();
        return this;
    }

    /**
     * Clicks the "Add to Cart" button
     * @return productSelection
     */
    public ProductSelection addToCart(){
        webDriver.findElement(ADD_TO_CART).click();
        return new ProductSelection(webDriver, this);
    }


    /**
     * Inputs the given details into the "send to a friend" form
     * @param friendName The input for the "name of your friend" field
     * @param friendEmail The input for the "e-mail address of your friend" field
     * @return this, for fluidity
     */
    public ProductPage sendToAFriend(String friendName, String friendEmail) {
        webDriver.findElement(SEND_TO_A_FRIEND).click();
        webDriver.findElement(NAME_OF_YOUR_FRIEND).sendKeys(friendName);
        webDriver.findElement(EMAIL_ADDRESS_OF_YOUR_FRIEND).sendKeys(friendEmail);
        webDriver.findElement(SEND_EMAIL).click();
        return this;
    }

    /**
     * Clicks on the "view larger" button
     * @return this, for fluidity
     */
    public ProductPage viewLarger() {
        webDriver.findElement(BIG_PICTURE).click();
        return this;
    }

    /**
     * Clicks the "next image" button
     * @return this, for fluidity
     */
    public ProductPage nextImage() {
        webDriver.findElement(NEXT_BUTTON).click();
        return this;
    }

    /**
     * Clicks the "previous image" button
     * @return this, for fluidity
     */
    public ProductPage previousImage() {
        webDriver.findElement(PREVIOUS_BUTTON).click();
        return this;
    }

    /**
     * Clicks on the close button
     * @return this, for fluidity
     */
    public ProductPage closeButton() {
        webDriver.findElement(CLOSE_BUTTON).click();
        return this;
    }
}
