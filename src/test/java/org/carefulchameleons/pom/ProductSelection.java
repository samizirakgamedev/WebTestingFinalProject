package org.carefulchameleons.pom;

import org.carefulchameleons.pom.cart.CartSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class ProductSelection {
    private WebDriver webDriver;
    private Page sourcePage;
    private By productsContainer;
    private static final By
            PRODUCT_CONTAINER = new By.ByClassName("product-container"),
            PRODUCT_NAME = new By.ByClassName("product-name"),
            ADD_TO_CART_BUTTON = new By.ByLinkText("Add to cart"),
            PRICE = new By.ByClassName("product-price"),
            CONTINUE_SHOPPING = new By.ByClassName("continue"),
            PROCEED_TO_CHECKOUT = new By.ByLinkText("Proceed to checkout");
    public ProductSelection(WebDriver webDriver, Page sourcePage) {
        this.webDriver = webDriver;
        this.sourcePage = sourcePage;
        this.productsContainer = PRODUCT_CONTAINER;
    }

    /**
     * Retrieves the products that are on the page.
     * @return a list of WebElements representing the product containers.
     */
    public List<WebElement> getProducts() {
        return webDriver.findElements(PRODUCT_CONTAINER);
    }

    /**
     * Adds the given product to the cart.
     * @param productName The name of the product to be added to the cart
     * @return this, for fluidity
     */
    public ProductSelection addToCart(String productName) {
        List<WebElement> products = getProducts();
        for(WebElement product : products) {
            if(getProductName(product).equals(productName)) {
                addProduct(product);
                break;
            }
        }
        return this;
    }

    /**
     * Retrieves the price of the given product
     * @param productName The name of the product to get the price of
     * @return the price of the product, or $-1 if the product was not found on the page
     */
    public double getPrice(String productName) {
        List<WebElement> products = getProducts();
        double price = -1;
        for(WebElement product : products) {
            if(getProductName(product).equals(productName)) {
                price = Double.parseDouble(product.findElement(PRICE).getText().substring(1));
            }
        }
        return price;
    }

    /**
     * Navigates to the page associated with the given product
     * @param productName The name of the product to go to the page for
     * @return The page associated with the product
     */
    public ProductPage goToProductPage(String productName) {
        WebElement link = webDriver.findElement(By.linkText(productName));
        String href = link.getAttribute("href");
        link.click();
        return new ProductPage(webDriver, href);
    }

    /**
     * Returns to the general page this product selection was on
     * @return the general page this product selection was on
     */
    public Page returnToSource() {
        return sourcePage;
    }

    /**
     * Clicks the "Continue shopping" button
     * @return this, for fluidity
     */
    public ProductSelection continueShopping() {
        webDriver.findElement(CONTINUE_SHOPPING).click();
        return this;
    }

    /**
     * Clicks the "Proceed to checkout" button, navigating to the cart summary page
     * @return the cart summary page
     */
    public CartSummaryPage proceedToCheckout() {
        webDriver.findElement(PROCEED_TO_CHECKOUT).click();
        return new CartSummaryPage(webDriver);
    }

    /**
     * Adds the given product to the cart
     * @param product the product to add to the cart
     */
    private void addProduct(WebElement product) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(product).moveToElement(product.findElement(ADD_TO_CART_BUTTON)).click();
    }

    /**
     * Retrieves the name of the given product
     * @param product the product-container WebElement representing the product
     * @return the product's name
     */
    private String getProductName(WebElement product) {
        return product.findElement(PRODUCT_NAME).getText();
    }

    public ProductFancyPage clickOnEye(int index){
        webDriver.findElement(PRODUCT_CONTAINER).findElements(By.className("quick-view-mobile")).get(index).click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        return new ProductFancyPage(webDriver);
    }


    public ProductPage clickOnTitle(int index){
        webDriver.findElement(PRODUCT_CONTAINER).findElements(By.className("product-name")).get(index).click();
        return new ProductPage(webDriver, "");
    }

    public String getTitle(int index){
        return webDriver.findElement(PRODUCT_CONTAINER).findElements(By.className("product-name")).get(index).getText();

    }


    public String getPrice(int index){
        return webDriver.findElement(PRODUCT_CONTAINER).findElements(By.className("product-price")).get(index).getText();
    }

    public ProductSelection hoverOverProduct(int index){
        Actions actions = new Actions(webDriver);
        WebElement element = webDriver.findElement(PRODUCT_CONTAINER).findElements(By.partialLinkText("More")).get(index);
        actions.moveToElement(element, 10, 10);
        actions.perform();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return this;
    }

    public ProductPage clickOnMore(int index){
        webDriver.findElement(PRODUCT_CONTAINER).findElements(By.partialLinkText("More")).get(index).click();
        return new ProductPage(webDriver, "");
    }

    public ProductSelection addItemToCart(int index){
        webDriver.findElement(PRODUCT_CONTAINER).findElements(By.partialLinkText("Add to cart")).get(index).click();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return this;
    }

}
