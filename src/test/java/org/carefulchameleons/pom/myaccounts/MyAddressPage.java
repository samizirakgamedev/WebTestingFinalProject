package org.carefulchameleons.pom.myaccounts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAddressPageMy extends MyAccountSharedPage {

    private final By ADDRESSES = new By.ByClassName("addresses");
    private final By ALERT = new By.ByClassName("alert-warning");

    public MyAddressPageMy(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=addresses");
    }

    public WebElement getAddress(int index) {
        List<WebElement> addresses = webDriver.findElements(ADDRESSES);
        return addresses.get(index);
    }

    public AddressSharedPageMy updateAddressDetails(int index) {

        getAddress(index)
                .findElement(By.className("address_update"))
                .findElement(By.xpath("//a[title='Update']"))
                .click();

        return new AddressSharedPageMy(webDriver);
    }

    public MyAddressPageMy deleteAddress(int index) {

        getAddress(index)
                .findElement(By.className("address_update"))
                .findElement(By.xpath("//a[title='Delete']"))
                .click();

        return this;
    }

    public AddressSharedPageMy addNewAddressDetails(int index) {

        webDriver.findElement(By.className("main-page-indent"))
                .findElement(By.xpath("//a[title='Add an address']"))
                .click();

        return new AddressSharedPageMy(webDriver);
    }

    public String getAlertMessage() {
        return webDriver.findElement(ALERT).getText();
    }

    public AddressSharedPageMy addNewAddressDetailsAlert() {

        webDriver.findElement(ALERT)
                .findElement(By.linkText("Add a new address"))
                .click();

        return new AddressSharedPageMy(webDriver);
    }

    public boolean hasAddresses() {
        List<WebElement> addresses = webDriver.findElements(ADDRESSES);
        return addresses.size() != 0;
    }

}
