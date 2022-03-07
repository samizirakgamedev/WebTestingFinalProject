package org.carefulchameleons.pom.myaccounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyOrderHistoryPage extends AccountDetailsPage {

    public MyOrderHistoryPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getOrder(int index) {

        List<WebElement> orders = webDriver.findElement(By.id("order-list"))
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
        List<WebElement> order = webDriver.findElements(By.id("order-list"));
        return order.size() != 0;
    }

    public String getAlertMessage() {
        return webDriver.findElement(By.className("alert-warning")).getText();
    }

}
