package org.carefulchameleons.pom.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * POM class responsible for handling the bank wire payment page in the cart.
 */
public class CartBankWirePaymentPage extends CartPage {

    public CartBankWirePaymentPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment");
    }

    public CartPaymentPage otherPaymentMethods() {
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button-exclusive"))
                .click();
        return new CartPaymentPage(getWebDriver());
    }

    public CartPaymentConfirmationPage confirmOrder() {
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button"))
                .click();
        return new CartPaymentConfirmationPage(getWebDriver());
    }
}
