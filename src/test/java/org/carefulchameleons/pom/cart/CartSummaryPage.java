package org.carefulchameleons.pom.cart;

import org.carefulchameleons.pom.IndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartSummaryPage extends CartPage {

    public CartSummaryPage(WebDriver webDriver){
        super(webDriver, "http://automationpractice.com/index.php?controller=order");
    }

    public WebElement getProduct(int index){
        List<WebElement> cartItems = getWebDriver().
                findElements(By.className("cart_item"));
        return cartItems.get(index);
    }

    public int getProductQuantity(int index) {
        String stringQuantity = getProduct(index).
                findElement(By.className("cart_quantity_input")).
                getAttribute("value");
        int quantity = Integer.parseInt(stringQuantity);
        return quantity;
    }

    public String getProductName(int index) {
        return getProduct(index).findElement(By.className("product_name")).getText();
    }

    public String getProductDescription(int index) {
        return getProduct(index).findElement(By.partialLinkText("color")).getText();
    }

    public double getProductUnitPrice(int index) {
        String priceString = getProduct(index)
                .findElement(By.className("cart_unit")).
                findElement(By.className("price")).getText();
        priceString = priceString.replaceAll("[$]", "");
        double price = Double.parseDouble(priceString);
        return price;
    }

    public String getStockStatus(int index){
        return getProduct(index)
                .findElement(By.className("cart_avail"))
                .findElement(By.className("label")).getText();
    }

    public double getTotalProductPrice(int index){
        String priceString = getProduct(index)
                .findElement(By.className("cart_total")).
                findElement(By.className("price")).getText();
        priceString = priceString.replaceAll("[$]", "");
        double price = Double.parseDouble(priceString);
        return price;
    }

    public CartSummaryPage removeProductFromCart(int index) {
        getProduct(index).findElement(By.className("cart_delete"))
                .findElement(By.className("cart_quantity_delete"))
                .click();
        return this;
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

    public CartSummaryPage incrementQuantity(int index){
        getProduct(index).findElement(By.className("cart_quantity"))
                .findElement(By.className("cart_quantity_up"))
                .click();
        return this;
    }

    public CartSummaryPage decrementQuantity(int index){
        getProduct(index).findElement(By.className("cart_quantity"))
                .findElement(By.className("cart_quantity_down"))
                .click();
        return this;
    }

    public double getTotalProducts(){
        String priceString = getWebDriver()
                .findElement(By.id("total_product"))
                .getText();
        priceString = priceString.replaceAll("[$]", "");
        double price = Double.parseDouble(priceString);
        return price;
    }

    public double getTotalShipping(){
        String priceString = getWebDriver()
                .findElement(By.id("total_shipping"))
                .getText();
        priceString = priceString.replaceAll("[$]", "");
        double price = Double.parseDouble(priceString);
        return price;
    }

    public double getTotalPriceWithoutTax(){
        String priceString = getWebDriver()
                .findElement(By.id("total_price_without_tax"))
                .getText();
        priceString = priceString.replaceAll("[$]", "");
        double price = Double.parseDouble(priceString);
        return price;
    }

    public double getTotalTax(){
        String priceString = getWebDriver()
                .findElement(By.id("total_tax"))
                .getText();
        priceString = priceString.replaceAll("[$]", "");
        double price = Double.parseDouble(priceString);
        return price;
    }

    public double getTotalPriceWithTax(){
        String priceString = getWebDriver()
                .findElement(By.id("total_price"))
                .getText();
        priceString = priceString.replaceAll("[$]", "");
        double price = Double.parseDouble(priceString);
        return price;
    }

    public String getCartTitle(){
        return getWebDriver().
                findElement(By.id("cart_title"))
                .getText();
    }

    public String getCartContains(){
        return getWebDriver().
                findElement(By.id("summary_products_quantity"))
                .getText();
    }

    public IndexPage continueShopping(){
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button-exclusive"))
                .click();
        return new IndexPage(getWebDriver());
    }

    public IndexPage proceedToCheckoutLoggedIn(){
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button"))
                .click();
        return new IndexPage(getWebDriver());
    }

    public CartAddressPage proceedToCheckoutNotLoggedIn(){
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button"))
                .click();
        return new CartAddressPage(getWebDriver());
    }
}
