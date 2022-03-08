package org.carefulchameleons.pom.cart;

import org.carefulchameleons.pom.myaccounts.MyOrderHistoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * POM class responsible for handling the payment confirmation page in the cart.
 */
public class CartPaymentConfirmationPage extends CartPage {

    public CartPaymentConfirmationPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=order-confirmation&id_cart=4300034&id_module=30&id_order=408344&key=4a44cfad03d59611f0452069ffb3591c");
    }

    public MyOrderHistoryPage backToOrders() {
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button-exclusive")).click();
        return new MyOrderHistoryPage(getWebDriver());
    }
}
