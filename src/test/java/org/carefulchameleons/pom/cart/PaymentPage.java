package org.carefulchameleons.pom.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends CartPage {
    public PaymentPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=order&multi-shipping=");
    }

    public BankWirePaymentPage payByBankWire(){
        getWebDriver().findElement(By.className("bankwire")).click();
        return new BankWirePaymentPage(getWebDriver());
    }

    public CheckPaymentPage payByCheck(){
        getWebDriver().findElement(By.className("cheque")).click();
        return new CheckPaymentPage(getWebDriver());
    }

    public CartShippingPage continueShopping(){
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button-exclusive"))
                .click();
        return new CartShippingPage(getWebDriver());
    }
}
