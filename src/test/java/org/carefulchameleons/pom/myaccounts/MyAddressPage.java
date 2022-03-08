package org.carefulchameleons.pom.myaccounts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAddressPage extends MyAccountSharedPage {

    private final By ADDRESSES = new By.ByClassName("addresses");
    private final By ALERT = new By.ByClassName("alert-warning");

    public MyAddressPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=addresses");
    }

    public WebElement getAddress(int index) {
        List<WebElement> addresses = webDriver.findElements(ADDRESSES);
        return addresses.get(index);
    }

    public AddressDetailsPage updateAddressDetails(int index) {

        getAddress(index)
                .findElement(By.className("address_update"))
                .findElement(By.xpath("//a[title='Update']"))
                .click();

        return new AddressDetailsPage(webDriver);
    }

    public MyAddressPage deleteAddress(int index) {

        getAddress(index)
                .findElement(By.className("address_update"))
                .findElement(By.xpath("//a[title='Delete']"))
                .click();

        return this;
    }

    public AddressDetailsPage addNewAddressDetails(int index) {

        webDriver.findElement(By.className("main-page-indent"))
                .findElement(By.xpath("//a[title='Add an address']"))
                .click();

        return new AddressDetailsPage(webDriver);
    }

    public String getAlertMessage() {
        return webDriver.findElement(ALERT).getText();
    }

    public AddressDetailsPage addNewAddressDetailsAlert() {

        webDriver.findElement(ALERT)
                .findElement(By.linkText("Add a new address"))
                .click();

        return new AddressDetailsPage(webDriver);
    }

    public boolean hasAddresses() {
        List<WebElement> addresses = webDriver.findElements(ADDRESSES);
        return addresses.size() != 0;
    }

}
