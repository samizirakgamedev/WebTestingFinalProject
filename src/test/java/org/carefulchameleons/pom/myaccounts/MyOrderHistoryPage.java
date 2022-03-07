package org.carefulchameleons.pom.myaccounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyOrderHistoryPage extends AccountDetailsPage {

    private final boolean orderHistory = hasOrderHistory();

    public MyOrderHistoryPage(WebDriver webDriver) {
        super(webDriver);

    }

    public boolean hasOrderHistory() {
       List<WebElement> order = webDriver.findElements(By.id("order-list"));
       return order.size() != 0;
    }

}
