package org.carefulchameleons.pom.cart;

import org.carefulchameleons.pom.IndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * POM class responsible for handling the shipping page in the cart.
 */
public class CartShippingPage extends CartPage {
    public CartShippingPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=order");
    }

    public boolean isTOSChecked() {
        List<WebElement> checked = getWebDriver().findElement(By.id("uniform-cgv"))
                .findElements(By.className("checked"));
        if (checked.size() == 1)
            return true;
        else
            return false;
    }

    public void displayTOS() {
        getWebDriver().findElement(By.className("iframe")).click();
    }

    public void acceptTOS(){
        getWebDriver().findElement(By.id("cgv")).click();
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

    public IndexPage continueShopping() {
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button-exclusive"))
                .click();
        return new IndexPage(getWebDriver());
    }

    public CartPaymentPage proceedToCheckout() {
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button"))
                .click();
        return new CartPaymentPage(getWebDriver());
    }
}
