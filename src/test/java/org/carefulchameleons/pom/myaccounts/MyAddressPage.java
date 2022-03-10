package org.carefulchameleons.pom.myaccounts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyAddressPage extends MyAccountSharedPage {

    private final By ADDRESSES = new By.ByClassName("addresses");
    private final By ALERT = new By.ByClassName("alert-warning");

    public MyAddressPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=addresses");
    }

    /**
     * <p> Gets a given address WebElement </p>
     *
     * <p> Requires: {@link #hasAddresses()} to be true </p>
     *
     * @param index position in the list of WebElements from the addresses ('addresses' classname).
     *              index must be < {@link #getAddressSize()}
     *
     * @return {@link AddressDetailsPage}, as it goes to a new details' page to edit
     */
    public WebElement getAddress(int index) {
        List<WebElement> addresses = webDriver.findElements(ADDRESSES);
        return addresses.get(index);
    }

    /**
     * <p> Clicks the update button for an address. </p>
     *
     * <p> Requires: {@link #hasAddresses()} to be true. </p>
     *
     * @param index position in the list of WebElements from the addresses ('addresses' classname).
     *              index must be < {@link #getAddressSize()}
     *
     * @return {@link AddressDetailsPage}, as it goes to a new details' page to edit
     */
    public AddressDetailsPage updateAddressDetails(int index) {

        getAddress(index)
                .findElement(By.className("address_update"))
                .findElement(By.xpath("//a[title='Update']"))
                .click();

        return new AddressDetailsPage(webDriver);
    }

    /**
     * <p> Clicks the delete button for an address. </p>
     *
     * <p> Requires: {@link #hasAddresses()} to be true. </p>
     *
     * @param index position in the list of WebElements from the addresses ('addresses' classname).
     *              index must be < {@link #getAddressSize()}
     *
     * @return {@link MyAddressPage}, as it doesn't change page to allow chaining
     */
    public MyAddressPage deleteAddress(int index) {

        getAddress(index)
                .findElement(By.className("address_update"))
                .findElement(By.xpath("//a[title='Delete']"))
                .click();

        return this;
    }

    /**
     * <p> Clicks the delete button for an address. </p>
     *
     * <p> Requires: {@link #hasAddresses()} to be true. </p>
     *
     * @param index position in the list of WebElements from the addresses ('addresses' classname).
     *              index must be < {@link #getAddressSize()}
     *
     * @return {@link MyAddressPage}, as it doesn't change page to allow chaining
     */
    public MyAddressPage confirmDeleteAddress(int index) {

        getAddress(index)
                .findElement(By.className("address_update"))
                .findElement(By.xpath("//a[title='Delete']"))
                .sendKeys(Keys.ENTER);

        return this;
    }

    /**
     * <p> Adds a new address. </p>
     *
     * <p> Requires: {@link #hasAddresses()} to be true. </p>
     *
     * @return {@link AddressDetailsPage}, as it goes to a new details' page to create an address
     */
    public AddressDetailsPage addNewAddressDetails() {

        webDriver.findElement(By.className("main-page-indent"))
                .findElement(By.xpath("//a[title='Add an address']"))
                .click();

        return new AddressDetailsPage(webDriver);
    }

    /**
     * Requires: {@link #hasAddresses()} to be false
     *
     * @return the alert message if the user has no addresses
     */
    public String getAlertMessage() {
        return webDriver.findElement(ALERT).getText();
    }

    /**
     * <p> Adds a new address from alert message. </p>
     *
     * <p> Requires: {@link #hasAddresses()} to be false. </p>
     *
     * @return {@link AddressDetailsPage}, as it goes to a new details' page to create an address
     */
    public AddressDetailsPage addNewAddressDetailsAlert() {

        webDriver.findElement(ALERT)
                .findElement(By.linkText("Add a new address"))
                .click();

        return new AddressDetailsPage(webDriver);
    }

    /**
     * @return true is the user has any address, else false
     */
    public boolean hasAddresses() {
        List<WebElement> addresses = webDriver.findElements(ADDRESSES);
        return addresses.size() != 0;
    }

    /**
     * @return amount of addresses user has
     */
    public int getAddressSize() {
        return webDriver.findElements(ADDRESSES).size();
    }
}
