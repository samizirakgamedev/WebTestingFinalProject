package org.carefulchameleons.pom.cart;

import org.carefulchameleons.pom.category.CategoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PaymentPage extends CartPage {
    public PaymentPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=order&multi-shipping=");
    }

    public WebElement getProduct(int index){
        List<WebElement> cartItems = getWebDriver().
                findElements(By.className("cart_item"));
        return cartItems.get(index);
    }

    public int getProductQuantity(int index) {
        String stringQuantity = getProduct(index).
                findElement(By.className("cart_quantity")).getText();
        int quantity = Integer.parseInt(stringQuantity);
        return quantity;
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
        double price = Double.parseDouble(priceString);
        return price;
    }

    // only works when there is a discount
    public double getProductOldPrice(int index) {
        String priceString = getProduct(index)
                .findElement(By.className("cart_unit")).
                findElement(By.className("old-price")).getText();
        priceString = priceString.replaceAll("[$]", "");
        double price = Double.parseDouble(priceString);
        return price;
    }

    // only works when there is a discount
    public double getProductSpecialPrice(int index) {
        String priceString = getProduct(index)
                .findElement(By.className("cart_unit")).
                findElement(By.className("special-price")).getText();
        priceString = priceString.replaceAll("[$]", "");
        double price = Double.parseDouble(priceString);
        return price;
    }

    // only works when there is a discount
    public double getProductDiscount(int index) {
        String priceString = getProduct(index)
                .findElement(By.className("cart_unit")).
                findElement(By.className("price-percent-reduction")).getText();
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

    public double getTotalPriceWithTax(){
        String priceString = getWebDriver()
                .findElement(By.id("total_price"))
                .getText();
        priceString = priceString.replaceAll("[$]", "");
        double price = Double.parseDouble(priceString);
        return price;
    }

    public CategoryPage clickProductImage(int index){
        getProduct(index).findElement(By.tagName("img")).click();
        String idSubstring = getProduct(index)
                .findElement(By.className("cart_ref")).toString();
        idSubstring = idSubstring.substring(idSubstring.lastIndexOf('_') + 1);
        int id = Integer.parseInt(idSubstring);
        return new CategoryPage(getWebDriver(), 0);
    }

    public CategoryPage clickProductName(int index){
        getProduct(index).findElement(By.className("product_name")).click();
        String idSubstring = getProduct(index)
                .findElement(By.className("cart_ref")).toString();
        idSubstring = idSubstring.substring(idSubstring.lastIndexOf('_') + 1);
        int id = Integer.parseInt(idSubstring);
        return new CategoryPage(getWebDriver(), 0);
    }

    public CategoryPage clickProductDescription(int index){
        getProduct(index).findElement(By.partialLinkText("color")).click();
        String idSubstring = getProduct(index)
                .findElement(By.className("cart_ref")).toString();
        idSubstring = idSubstring.substring(idSubstring.lastIndexOf('_') + 1);
        int id = Integer.parseInt(idSubstring);
        return new CategoryPage(getWebDriver(), 0);
    }

    public BankWirePaymentPage payByBankWire(){
        getWebDriver().findElement(By.className("bankwire")).click();
        return new BankWirePaymentPage(getWebDriver());
    }

    public CheckPaymentPage payByCheck(){
        getWebDriver().findElement(By.className("cheque")).click();
        return new CheckPaymentPage(getWebDriver());
    }

    public CartShippingPage continueShopping(){
        getWebDriver().findElement(By.className("cart_navigation"))
                .findElement(By.className("button-exclusive"))
                .click();
        return new CartShippingPage(getWebDriver());
    }
}
