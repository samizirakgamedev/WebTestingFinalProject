package org.carefulchameleons.pom.cart;

import org.carefulchameleons.pom.category.CategoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * POM class responsible for handling the payment page in the cart.
 */
public class CartPaymentPage extends CartPage {
    public CartPaymentPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=order&multi-shipping=");
    }

    public WebElement getProduct(int index) {
        List<WebElement> cartItems = getWebDriver().
                findElements(By.className("cart_item"));
        return cartItems.get(index);
    }

    public int getProductQuantity(int index) {
        String stringQuantity = getProduct(index).
                findElement(By.className("cart_quantity")).getText();
        return Integer.parseInt(stringQuantity);
    }

    public String getProductName(int index) {
        return getProduct(index).findElement(By.className("product_name")).getText();
    }

    public String getProductDescription(int index) {
        return getProduct(index).findElement(By.partialLinkText("color")).getText();
    }

    // only works when there is no discount
    public double getProductUnitPrice(int index) {
        String priceString = getProduct(index)
                .findElement(By.className("cart_unit")).
                findElement(By.className("price")).getText();
        priceString = priceString.replaceAll("[$]", "");
        return Double.parseDouble(priceString);
    }

    // only works when there is a discount
    public double getProductOldPrice(int index) {
        String priceString = getProduct(index)
                .findElement(By.className("cart_unit")).
                findElement(By.className("old-price")).getText();
        priceString = priceString.replaceAll("[$]", "");
        return Double.parseDouble(priceString);
    }

    // only works when there is a discount
    public double getProductSpecialPrice(int index) {
        String priceString = getProduct(index)
                .findElement(By.className("cart_unit")).
                findElement(By.className("special-price")).getText();
        priceString = priceString.replaceAll("[$]", "");
        return Double.parseDouble(priceString);
    }

    // only works when there is a discount
    public double getProductDiscount(int index) {
        String priceString = getProduct(index)
                .findElement(By.className("cart_unit")).
                findElement(By.className("price-percent-reduction")).getText();
        priceString = priceString.replaceAll("[$]", "");
        return Double.parseDouble(priceString);
    }

    public String getStockStatus(int index) {
        return getProduct(index)
                .findElement(By.className("cart_avail"))
                .findElement(By.className("label")).getText();
    }

    public double getTotalProductPrice(int index) {
        String priceString = getProduct(index)
                .findElement(By.className("cart_total")).
                findElement(By.className("price")).getText();
        priceString = priceString.replaceAll("[$]", "");
        return Double.parseDouble(priceString);
    }

    public int getCartSize() {
        List<WebElement> cartItems = getWebDriver().
                findElements(By.className("cart_item"));
        return cartItems.size();
    }

    public int getProductIndexFromName(String name) {
        for (int i = 0; i < getCartSize(); i++) {
            if (getProductName(i).equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public double getTotalProducts() {
        String priceString = getWebDriver()
                .findElement(By.id("total_product"))
                .getText();
        priceString = priceString.replaceAll("[$]", "");
        return Double.parseDouble(priceString);
    }

    public double getTotalShipping() {
        String priceString = getWebDriver()
                .findElement(By.id("total_shipping"))
                .getText();
        priceString = priceString.replaceAll("[$]", "");
        return Double.parseDouble(priceString);
    }

    public double getTotalPriceWithTax() {
        String priceString = getWebDriver()
                .findElement(By.id("total_price"))
                .getText();
        priceString = priceString.replaceAll("[$]", "");
        return Double.parseDouble(priceString);
    }

    public CategoryPage clickProductImage(int index) {
        getProduct(index).findElement(By.tagName("img")).click();
        String idSubstring = getProduct(index)
                .findElement(By.className("cart_ref")).toString();
        idSubstring = idSubstring.substring(idSubstring.lastIndexOf('_') + 1);
        return new CategoryPage(getWebDriver(), Integer.parseInt(idSubstring));
    }

    public CategoryPage clickProductName(int index) {
        getProduct(index).findElement(By.className("product_name")).click();
        String idSubstring = getProduct(index)
                .findElement(By.className("cart_ref")).toString();
        idSubstring = idSubstring.substring(idSubstring.lastIndexOf('_') + 1);
        return new CategoryPage(getWebDriver(), Integer.parseInt(idSubstring));
    }

    public CategoryPage clickProductDescription(int index) {
        getProduct(index).findElement(By.partialLinkText("color")).click();
        String idSubstring = getProduct(index)
                .findElement(By.className("cart_ref")).toString();
        idSubstring = idSubstring.substring(idSubstring.lastIndexOf('_') + 1);
        return new CategoryPage(getWebDriver(), Integer.parseInt(idSubstring));
    }

    public CartBankWirePaymentPage payByBankWire() {
        getWebDriver().findElement(By.className("bankwire")).click();
        return new CartBankWirePaymentPage(getWebDriver());
    }

    public CartCheckPaymentPage payByCheck() {
        getWebDriver().findElement(By.className("cheque")).click();
        return new CartCheckPaymentPage(getWebDriver());
    }

    public CartShippingPage continueShopping() {
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button-exclusive"))
                .click();
        return new CartShippingPage(getWebDriver());
    }
}
