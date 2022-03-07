package org.carefulchameleons.pom.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartShippingPage extends CartPage {
    public CartShippingPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=order");
    }

    public boolean isTOSChecked(){
        String value = getWebDriver().findElement(By.id("cgv")).getAttribute("value");
        if("1".equals(value))
            return true;
        else
            return false;
    }

    public CartSummaryPage continueShopping(){
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button-exclusive"))
                .click();
        return new CartSummaryPage(getWebDriver());
    }

    public PaymentPage proceedToCheckout(){
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button"))
                .click();
        return new PaymentPage(getWebDriver());
    }
}
