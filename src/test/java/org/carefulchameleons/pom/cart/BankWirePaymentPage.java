package org.carefulchameleons.pom.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BankWirePaymentPage extends CartPage {
    public BankWirePaymentPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?fc=module&module=bankwire&controller=payment");
    }

    public PaymentPage otherPaymentMethods(){
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button-exclusive"))
                .click();
        return new PaymentPage(getWebDriver());
    }

    public PaymentConfirmationPage confirmOrder(){
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button"))
                .click();
        return new PaymentConfirmationPage(getWebDriver());
    }
}
