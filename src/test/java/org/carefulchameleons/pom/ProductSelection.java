package org.carefulchameleons.pom;

import org.carefulchameleons.pom.cart.CartSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ProductSelection {
    private WebDriver webDriver;
    private Page sourcePage;
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
    }

    public List<WebElement> getProducts(WebDriver webDriver) {
        return webDriver.findElements(PRODUCT_CONTAINER);
    }

    public boolean addToCart(String productName) {
        List<WebElement> products = getProducts(webDriver);
        for(WebElement product : products) {
            if(getProductName(product).equals(productName)) {
                addProduct(product);
                return true;
            }
        }
        return false;
    }

    public double getPrice(String productName) {
        List<WebElement> products = getProducts(webDriver);
        double price = -1;
        for(WebElement product : products) {
            if(getProductName(product).equals(productName)) {
                price = Double.parseDouble(product.findElement(PRICE).getText().substring(1));
            }
        }
        return price;
    }

    public ProductPage goToProductPage(String productName) {
        WebElement link = webDriver.findElement(By.linkText(productName));
        String href = link.getAttribute("href");
        link.click();
        return new ProductPage(webDriver, href);
    }

    public Page returnToSource() {
        return sourcePage;
    }

    public Page continueShopping() {
        webDriver.findElement(CONTINUE_SHOPPING).click();
        return sourcePage;
    }

    public CartSummaryPage proceedToCheckout() {
        webDriver.findElement(PROCEED_TO_CHECKOUT).click();
        return new CartSummaryPage(webDriver);
    }

    private void addProduct(WebElement product) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(product).moveToElement(product.findElement(ADD_TO_CART_BUTTON)).click();
    }

    private String getProductName(WebElement product) {
        return product.findElement(PRODUCT_NAME).getText();
    }
}
