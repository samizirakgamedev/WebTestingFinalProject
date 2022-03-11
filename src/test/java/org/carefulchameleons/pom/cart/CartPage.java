package org.carefulchameleons.pom.cart;

import org.carefulchameleons.pageelements.CategoryMenu;
import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Abstract POM class responsible for handling the cart pages.
 */
public abstract class CartPage extends Page {

    public CartPage(WebDriver webDriver, String expected_url) {
        super(webDriver, expected_url);
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

    public CartSignInPage clickSignInButton() {
        getWebDriver().findElement(By.className("second")).click();
        return new CartSignInPage(getWebDriver());
    }

    public CartAddressPage clickAddressButton() {
        getWebDriver().findElement(By.className("third")).click();
        return new CartAddressPage(getWebDriver());
    }

    public CartShippingPage clickShippingButton() {
        getWebDriver().findElement(By.className("four")).click();
        return new CartShippingPage(getWebDriver());
    }

    public CartPaymentPage clickPaymentButton() {
        getWebDriver().findElement(By.className("last")).click();
        return new CartPaymentPage(getWebDriver());
    }

    public CategoryMenu getCategoryMenu(){
        return new CategoryMenu(webDriver);
    }
}
