package org.carefulchameleons.pom.cart;

import org.carefulchameleons.pom.IndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartAddressPage extends CartPage {

    public CartAddressPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=order&step=1&multi-shipping=");
    }

    public String getCartTitle(){
        return getWebDriver().
                findElement(By.className("page-heading"))
                .getText();
    }

    public String getSelectedDeliveryAddress(){
        return getWebDriver().findElement(By.id("id_address_delivery")).getText();
    }

    public boolean isDeliveryAddressBillingAddress(){
        String value = getWebDriver().findElement(By.className("checked")).getAttribute("value");
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

    public CartShippingPage proceedToCheckout(){
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button"))
                .click();
        return new CartShippingPage(getWebDriver());
    }
}