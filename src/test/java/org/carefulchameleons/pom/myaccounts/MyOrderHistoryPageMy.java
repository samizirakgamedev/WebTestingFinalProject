package org.carefulchameleons.pom.myaccounts;

import org.carefulchameleons.pom.cart.CartSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyOrderHistoryPageMy extends MyAccountSharedPage {

    private final By ORDER_LIST = new By.ById("order-list");
    private final By ALERT = new By.ByClassName("alert-warning");

    public MyOrderHistoryPageMy(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=history");
    }

    public WebElement getOrder(int index) {

        List<WebElement> orders = webDriver.findElement(ORDER_LIST)
                .findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"));

        return orders.get(index);
    }

    public String getOrderReference(int index) {
        return getOrder(index).findElement(By.className("color-myaccount")).getText();
    }

    public double getOrderPrice(int index) {
        String priceString = getOrder(index)
                .findElement(By.className("price")).getText();

        priceString = priceString.replaceAll("[$]", "");

        double price = Double.parseDouble(priceString);
        return price;
    }

    public String getOrderDate(int index) {
        return getOrder(index).findElement(By.className("history_date")).getText();
    }

    public String getPaymentMethod(int index) {
        return getOrder(index).findElement(By.className("history_method")).getText();
    }

    public boolean hasOrderHistory() {
        List<WebElement> order = webDriver.findElements(ORDER_LIST);
        return order.size() != 0;
    }

    public String getAlertMessage() {
        return webDriver.findElement(ALERT).getText();
    }

    public MyOrderHistoryPageMy clickDetailsButton() {
        webDriver.findElement(By.className("history_detail"))
                .findElement(By.className("btn")).click();
        return this;
    }

    public CartSummaryPage clickReorderButton() {
        webDriver.findElement(By.className("history_detail"))
                .findElement(By.className("link-button")).click();
        return new CartSummaryPage();
    }

}
