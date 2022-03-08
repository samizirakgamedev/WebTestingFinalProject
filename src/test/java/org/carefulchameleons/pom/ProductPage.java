package org.carefulchameleons.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Page{
    private static final By
            SEND_TO_A_FRIEND = new By.ById("send_friend_button"),
            NAME_OF_YOUR_FRIEND = new By.ById("friend_name"),
            EMAIL_ADDRESS_OF_YOUR_FRIEND = new By.ById("friend_email"),
            SEND_EMAIL = new By.ById("sendEmail"),
            BIG_PICTURE = new By.ById("bigpic");

    public ProductPage(WebDriver webDriver, String url) {
        super(webDriver, url);
    }

    public ProductPage increaseQuantity() {

    }

    public ProductPage decreaseQuantity() {

    }

    public ProductPage selectSize() {

    }

    public ProductPage selectColour() {

    }

    public ProductPage addToWishlist() {

    }

    public ProductPage sendToAFriend(String friendName, String friendEmail) {
        webDriver.findElement(SEND_TO_A_FRIEND).click();
        webDriver.findElement(NAME_OF_YOUR_FRIEND).sendKeys(friendName);
        webDriver.findElement(EMAIL_ADDRESS_OF_YOUR_FRIEND).sendKeys(friendEmail);
        webDriver.findElement(SEND_EMAIL).click();
        return this;
    }

    public ProductPage viewLarger() {
        webDriver.findElement(BIG_PICTURE).click();
        return this;
    }
}
