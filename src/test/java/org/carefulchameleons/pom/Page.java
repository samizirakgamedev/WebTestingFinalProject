package org.carefulchameleons.pom;

import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected WebDriver webDriver;
    private final PageHeader PAGE_HEADER;
    private final PageFooter PAGE_FOOTER;

    private final String EXPECTED_URL;

    public Page(WebDriver webDriver, String expected_url) {
        this.webDriver = webDriver;
        EXPECTED_URL = expected_url;
        PAGE_HEADER = new PageHeader(webDriver);
        PAGE_FOOTER = new PageFooter(webDriver);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public PageHeader getPageHeader(){
        return PAGE_HEADER;
    }

    public PageFooter getPageFooter() {
        return PAGE_FOOTER;
    }

    public String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }

    public boolean isUrlCorrect() {
        return getCurrentURL().equals(EXPECTED_URL);
    }
<<<<<<< HEAD

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
