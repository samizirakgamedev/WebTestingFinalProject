package org.carefulchameleons.pom.cart;

import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.myaccounts.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * POM class responsible for handling the sign-in page in the cart.
 */
public class CartSignInPage extends SignInPage {

    public CartSignInPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0");
    }

    public String getCartTitle() {
        return getWebDriver().
                findElement(By.className("page-heading"))
                .getText();
    }

    public IndexPage clickHomeButton() {
        getWebDriver().findElement(By.className("home")).click();
        return new IndexPage(getWebDriver());
    }

    public CartSummaryPage clickSummaryButton() {
        getWebDriver().findElement(By.className("first")).click();
        return new CartSummaryPage(getWebDriver());
    }
}
