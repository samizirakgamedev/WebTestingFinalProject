package org.carefulchameleons.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class Page {

    protected WebDriver webDriver;
    private final By HEADER_IMAGE = new By.ByClassName("img-responsive");
    private final By CONTACT_US_LINK = new By.ByLinkText("Contact us");
    private final By SIGN_IN = new By.ByClassName("login");
    private final By LOGO = new By.ByClassName("logo");
    private final By SEARCH_BOX = new By.ById("search_query_top");
    private final By SEARCH_BUTTON = new By.ByName("submit_search");
    private final By CART_BUTTON = new By.ByLinkText("Cart");
    private final By CART_ITEM_IMAGES = new By.ByClassName("cart-images");
    private final By CART_QUANTITY = new By.ByClassName("ajax_cart_quantity");
    private final By CART_ITEM_QUANTITIES = new By.ByClassName("quantity");
    private final By CART_PRODUCT_NAMES = new By.ByClassName("cart_block_product_name");
    private final By CART_SHIPPING_COST = new By.ByClassName("ajax_cart_shipping_cost");
    private final By CART_TOTAL_COST = new By.ByClassName("ajax_block_cart_total");
    private final By CART_CHECKOUT_BUTTON = new By.ById("button_order_cart");
    private final String EXPECTED_URL;

    public Page(WebDriver webDriver, String expected_url) {
        this.webDriver = webDriver;
        EXPECTED_URL = expected_url;
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    public String getCurrentURL(){
        return webDriver.getCurrentUrl();
    }

    public boolean isUrlCorrect(){
        return getCurrentURL().equals(EXPECTED_URL);
    }

    public void clickHeaderImage(){
        webDriver.findElement(HEADER_IMAGE).click();
    }

    public void clickContactUsButton(){
        webDriver.findElement(CONTACT_US_LINK).click();
    }

    public void clickSignInButton(){
        webDriver.findElement(SIGN_IN).click();
    }

    public IndexPage clickLogo(){
        webDriver.findElement(LOGO).click();
        return new IndexPage(webDriver);
    }

    public void enterTextInSearchBox(String text){
        webDriver.findElement(SEARCH_BOX).sendKeys(text);
    }

    public void clickSearchButton(){
        webDriver.findElement(SEARCH_BUTTON).click();
    }

    public void hoverCartButton(){
        Actions action = new Actions(webDriver);
        action.moveToElement(webDriver.findElement(CART_BUTTON));
    }

    public void clickCartButton(){
        webDriver.findElement(CART_BUTTON).click();
    }

    public void clickCartItemImageAtIndex(int index){
        hoverCartButton();
        webDriver.findElements(CART_ITEM_IMAGES)
                .get(index)
                .click();
    }

    public Integer getCartQuantity(){
        hoverCartButton();
        return Integer.parseInt(webDriver.findElement(CART_QUANTITY)
                .getText());
    }

    public Integer getCartItemQuantityAtIndex(int index){
        hoverCartButton();
        return Integer.parseInt(webDriver.findElements(CART_ITEM_QUANTITIES)
                .get(index)
                .getText());
    }

    public String getCartItemNameAtIndex(int index){
        hoverCartButton();
        return webDriver.findElements(CART_PRODUCT_NAMES).get(index).getAttribute("title");
    }

    public String getCartShippingCost(){
        hoverCartButton();
        return webDriver.findElement(CART_SHIPPING_COST).getText();
    }

    public String getCartTotalCost(){
        hoverCartButton();
        return webDriver.findElement(CART_TOTAL_COST).getText();
    }

    public void clickCartCheckOutButton(){
        hoverCartButton();
        webDriver.findElement(CART_CHECKOUT_BUTTON).click();
    }
}
