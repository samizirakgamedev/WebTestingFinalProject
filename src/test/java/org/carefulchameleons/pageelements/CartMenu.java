package org.carefulchameleons.pageelements;

import org.carefulchameleons.pom.cart.CartSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class CartMenu {

    public class CartContent{
        private WebDriver webDriver;
        private By checkoutButton = By.id("button_order_cart");
        public CartContent(WebDriver webDriver) {
            this.webDriver = webDriver;
        }

        public CartSummaryPage clickCheckout(){
            webDriver.findElement(checkoutButton).click();
            return new CartSummaryPage(webDriver);
        }

        public CartContent assignCheckoutButton(By checkoutButton){
            this.checkoutButton = checkoutButton;
            return this;
        }
    }

    private WebDriver webDriver;
    private By shoppingCart = By.className("shopping_cart");
    public CartMenu(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public CartMenu assignRoot(By root){
        this.shoppingCart = root;
        return this;
    }

    public CartContent hoverOnShoppingCart(){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(shoppingCart).findElement(By.tagName("a")), 1, 1);
        actions.perform();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return new CartContent(webDriver);
    }

    public Object hoverOnShoppingCartNoItems(Object page){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(shoppingCart).findElement(By.tagName("a")), 1, 1);
        actions.perform();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return page;
    }
}
