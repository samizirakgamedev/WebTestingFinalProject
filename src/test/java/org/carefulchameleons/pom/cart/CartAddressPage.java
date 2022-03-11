package org.carefulchameleons.pom.cart;

import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.myaccounts.MyAddressPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * POM class responsible for handling the address page in the cart.
 */
public class CartAddressPage extends CartPage {

    public CartAddressPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=order&step=1&multi-shipping=");
    }

    public String getSelectedDeliveryAddress() {
        return getWebDriver().findElement(By.id("id_address_delivery")).getText();
    }

    public boolean isDeliveryAddressBillingAddress() {
        List<WebElement> checked = getWebDriver().findElement(By.id("uniform-addressesAreEquals"))
                .findElements(By.className("checked"));
        if (checked.size() == 1)
            return true;
        else
            return false;
    }

    public void clickUseDeliveryAsBilling(){
        getWebDriver().findElement(By.id("addressesAreEquals")).click();
    }

    public void selectAddress(String address){
        getWebDriver().findElement(By.className("address_select")).click();
        getWebDriver().findElement(By.linkText(address)).click();
    }

    public MyAddressPage updateDeliveryAddress() {
        getWebDriver().findElement(By.id("address_delivery")).findElement(By.className("button")).click();
        return new MyAddressPage(getWebDriver());
    }

    public MyAddressPage updateBillingAddress() {
        getWebDriver().findElement(By.id("address_invoice")).findElement(By.className("button")).click();
        return new MyAddressPage(getWebDriver());
    }

    public MyAddressPage addAddress() {
        getWebDriver().findElement(By.className("address_add")).findElement(By.className("button")).click();
        return new MyAddressPage(getWebDriver());
    }

    public void enterTextToTextArea(String text) {
        getWebDriver().findElement(By.tagName("textarea")).sendKeys(text);
    }

    public String getTextFromTextArea() {
        return getWebDriver().findElement(By.tagName("textarea")).getText();
    }

    public IndexPage continueShopping() {
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button-exclusive"))
                .click();
        return new IndexPage(getWebDriver());
    }

    public CartShippingPage proceedToCheckout() {
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button"))
                .click();
        return new CartShippingPage(getWebDriver());
    }
}