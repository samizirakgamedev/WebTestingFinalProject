package org.carefulchameleons.pom.myaccounts;

import org.carefulchameleons.pom.cart.CartSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyOrderHistoryPage extends MyAccountSharedPage {

    private final By ORDER_LIST = new By.ById("order-list");
    private final By ALERT = new By.ByClassName("alert-warning");

    public MyOrderHistoryPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=history");
    }

    /**
     * <p> Gets an order WebElement </p>
     *
     * <p> Requires: {@link #hasOrderHistory()} to be true </p>
     *
     * @param index position in the list of WebElements from the order list table ('order-list' classname).
     *              index must be < {@link #getOrderHistorySize()}
     *
     * @return {@link WebElement}, each element relates to a table entry
     */
    public WebElement getOrder(int index) {

        List<WebElement> orders = webDriver.findElement(ORDER_LIST)
                .findElement(By.tagName("tbody"))
                .findElements(By.tagName("tr"));

        return orders.get(index);
    }

    /**
     * Requires: {@link #hasOrderHistory()} to be true
     *
     * @param index position in the list of WebElements from the order list table ('order-list' classname).
     *              index must be < {@link #getOrderHistorySize()}
     *
     * @return order reference of the specified order
     */
    public String getOrderReference(int index) {
        return getOrder(index).findElement(By.className("color-myaccount")).getText();
    }

    /**
     * Requires: {@link #hasOrderHistory()} to be true
     *
     * @param index position in the list of WebElements from the order list table ('order-list' classname).
     *              index must be < {@link #getOrderHistorySize()}
     *
     * @return price of the specified order
     */
    public double getOrderPrice(int index) {
        String priceString = getOrder(index)
                .findElement(By.className("price")).getText();

        priceString = priceString.replaceAll("[$]", "");

        double price = Double.parseDouble(priceString);
        return price;
    }

    /**
     * Requires: {@link #hasOrderHistory()} to be true
     *
     * @param index position in the list of WebElements from the order list table ('order-list' classname).
     *              index must be < {@link #getOrderHistorySize()}
     *
     * @return order date of the specified order
     */
    public String getOrderDate(int index) {
        return getOrder(index).findElement(By.className("history_date")).getText();
    }

    /**
     * Requires: {@link #hasOrderHistory()} to be true
     *
     * @param index position in the list of WebElements from the order list table ('order-list' classname).
     *              index must be < {@link #getOrderHistorySize()}
     *
     * @return payment method of the specified order
     */
    public String getPaymentMethod(int index) {
        return getOrder(index).findElement(By.className("history_method")).getText();
    }

    /**
     * Requires: {@link #hasOrderHistory()} to be false
     *
     * @return the error msg if there's no order history
     */
    public String getAlertMessage() {
        return webDriver.findElement(ALERT).getText();
    }

    /**
     * <p>Clicks address details button</p>
     *
     * <p>Requires: {@link #hasOrderHistory()} to be true</p>
     *
     * @param index position in the list of WebElements from the order list table ('order-list' classname).
     *              index must be < {@link #getOrderHistorySize()}
     *
     * @return {@link MyOrderHistoryPage}, as it stays on the page allowing for chaining
     */
    public MyOrderHistoryPage clickDetailsButton(int index) {
        getOrder(index)
                .findElement(By.className("history_detail"))
                .findElement(By.className("btn")).click();
        return this;
    }

    /**
     * <p>Clicks address reorder button</p>
     *
     * <p>Requires: {@link #hasOrderHistory()} to be true</p>
     *
     * @param index position in the list of WebElements from the order list table ('order-list' classname).
     *              index must be < {@link #getOrderHistorySize()}
     *
     * @return {@link MyOrderHistoryPage}, as it stays on the page allowing for chaining
     */
    public CartSummaryPage clickReorderButton(int index) {
        getOrder(index)
                .findElement(By.className("history_detail"))
                .findElement(By.className("link-button")).click();
        return new CartSummaryPage(webDriver);
    }

    /**
     * @return true if the user has an order history else false
     */
    public boolean hasOrderHistory() {
        List<WebElement> order = webDriver.findElements(ORDER_LIST);
        return !order.isEmpty();
    }

    /**
     * @return amount of previous orders the user has
     */
    public int getOrderHistorySize() {
        return webDriver.findElements(ORDER_LIST).size();
    }



}
