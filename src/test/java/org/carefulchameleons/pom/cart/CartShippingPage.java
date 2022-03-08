package org.carefulchameleons.pom.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * POM class responsible for handling the shipping page in the cart.
 */
public class CartShippingPage extends CartPage {
    public CartShippingPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=order");
    }

    public boolean isTOSChecked() {
        String value = getWebDriver().findElement(By.id("cgv")).getAttribute("value");
        return "1".equals(value);
    }

    public void clickTOS() {
        getWebDriver().findElement(By.className("iframe")).click();
    }

    // only works after using clickTOS()
    public String getTOSTitle() {
        String title = getWebDriver().
                findElement(By.className("cms")).
                findElement(By.className("page-heading")).
                getText();
        getWebDriver().findElement(By.className("fancybox-close")).click();
        return title;
    }

    public CartSummaryPage continueShopping() {
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button-exclusive"))
                .click();
        return new CartSummaryPage(getWebDriver());
    }

    public CartPaymentPage proceedToCheckout() {
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button"))
                .click();
        return new CartPaymentPage(getWebDriver());
    }
}
