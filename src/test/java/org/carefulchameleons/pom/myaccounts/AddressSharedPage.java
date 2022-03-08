package org.carefulchameleons.pom.myaccounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressSharedPageMy extends MyAccountSharedPage {

    private final By FIRST_NAME = new By.ById("firstname");
    private final By LAST_NAME = new By.ById("lastname");

    private final By COMPANY = new By.ById("company");

    private final By ADDRESS_ONE = new By.ById("address1");
    private final By ADDRESS_TWO = new By.ById("address2");
    private final By CITY = new By.ById("city");
    private final By STATE = new By.ById("id_state");
    private final By ZIP_CODE = new By.ById("postcode");
    private final By COUNTRY = new By.ById("id_country");

    private final By HOME_PHONE = new By.ById("phone");
    private final By MOBILE_PHONE = new By.ById("phone_mobile");

    private final By ADDITIONAL_INFO = new By.ById("other");
    private final By ADDRESS_ALIAS = new By.ById("alias");

    private final By SAVE_BUTTON = new By.ById("submitAddress");

    public AddressSharedPageMy(WebDriver webDriver) {
        super(webDriver, null);
    }

    public AddressSharedPageMy inputFirstName(String firstName) {

        WebElement element = webDriver.findElement(FIRST_NAME);

        element.clear();
        element.sendKeys(firstName);

        return this;
    }

    public AddressSharedPageMy inputLastName(String lastName) {

        WebElement element = webDriver.findElement(LAST_NAME);

        element.clear();
        element.sendKeys(lastName);

        return this;
    }

    public AddressSharedPageMy inputCompany(String company) {

        WebElement element = webDriver.findElement(COMPANY);

        element.clear();
        element.sendKeys(company);

        return this;
    }
    
    public AddressSharedPageMy inputAddressOne(String addressOne) {

        WebElement element = webDriver.findElement(ADDRESS_ONE);

        element.clear();
        element.sendKeys(addressOne);

        return this;
    }

    public AddressSharedPageMy inputAddressTwo(String addressTwo) {

        WebElement element = webDriver.findElement(ADDRESS_TWO);

        element.clear();
        element.sendKeys(addressTwo);

        return this;
    }

    public AddressSharedPageMy inputCity(String city) {

        WebElement element = webDriver.findElement(CITY);

        element.clear();
        element.sendKeys(city);

        return this;
    }

    public AddressSharedPageMy chooseStateByName(String stateName) {
        Select dropState = new Select(webDriver.findElement(STATE));
        dropState.selectByVisibleText(stateName);
        return this;
    }

    public AddressSharedPageMy chooseStateByIndex(int index) {
        Select dropState = new Select(webDriver.findElement(STATE));
        dropState.selectByIndex(index);
        return this;
    }

    public AddressSharedPageMy inputZipCode(String zipCode) {

        WebElement element = webDriver.findElement(ZIP_CODE);

        element.clear();
        element.sendKeys(zipCode);

        return this;
    }

    public AddressSharedPageMy chooseCountryByName(String countryName) {
        Select dropState = new Select(webDriver.findElement(COUNTRY));
        dropState.selectByVisibleText(countryName);
        return this;
    }

    public AddressSharedPageMy chooseCountryByIndex(int index) {
        Select dropState = new Select(webDriver.findElement(COUNTRY));
        dropState.selectByIndex(index);
        return this;
    }

    public AddressSharedPageMy inputHomePhone(String homePhone) {

        WebElement element = webDriver.findElement(HOME_PHONE);

        element.clear();
        element.sendKeys(homePhone);

        return this;
    }

    public AddressSharedPageMy inputMobilePhone(String mobilePhone) {

        WebElement element = webDriver.findElement(MOBILE_PHONE);

        element.clear();
        element.sendKeys(mobilePhone);

        return this;
    }

    public AddressSharedPageMy inputAdditionalInformation(String additionalInfo) {

        WebElement element = webDriver.findElement(ADDITIONAL_INFO);

        element.clear();
        element.sendKeys(additionalInfo);

        return this;
    }

    public AddressSharedPageMy inputAddressAlias(String addressAlias) {

        WebElement element = webDriver.findElement(ADDRESS_ALIAS);

        element.clear();
        element.sendKeys(addressAlias);

        return this;
    }

    public String getFIRST_NAME() {
        return webDriver.findElement(FIRST_NAME).getAttribute("value");
    }

    public String getLAST_NAME() {
        return webDriver.findElement(LAST_NAME).getAttribute("value");
    }

    public String getCOMPANY() {
        return webDriver.findElement(COMPANY).getAttribute("value");
    }

    public String getAddressOne() {
        return webDriver.findElement(ADDRESS_ONE).getAttribute("value");
    }

    public String getAddressTwo() {
        return webDriver.findElement(ADDRESS_TWO).getAttribute("value");
    }

    public String getCITY() {
        return webDriver.findElement(CITY).getAttribute("value");
    }

    public String getZIP_CODE() {
        return webDriver.findElement(ZIP_CODE).getAttribute("value");
    }

    public String getHOME_PHONE() {
        return webDriver.findElement(HOME_PHONE).getAttribute("value");
    }

    public String getMOBILE_PHONE() {
        return webDriver.findElement(MOBILE_PHONE).getAttribute("value");
    }

    public String getAdditionalInformation() {
        return webDriver.findElement(ADDITIONAL_INFO).getAttribute("value");
    }

    public String getADDRESS_ALIAS() {
        return webDriver.findElement(ADDRESS_ALIAS).getAttribute("value");
    }

    public AddressSharedPageMy clickSaveButton() {
        webDriver.findElement(SAVE_BUTTON).click();
        return this;
    }

    public MyAddressPageMy goToMyAddressPage() {
        return new MyAddressPageMy(webDriver);
    }

}
