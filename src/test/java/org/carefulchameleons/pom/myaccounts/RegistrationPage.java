package org.carefulchameleons.pom.myaccounts;

import org.carefulchameleons.pom.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends Page {

    private final By SOCIAL_TITLE_MR = new By.ById("id_gender1");
    private final By SOCIAL_TITLE_MRS = new By.ById("id_gender2");
    private final By FIRST_NAME_TEXT_BOX = new By.ById("firstname");
    private final By LAST_NAME_TEXT_BOX = new By.ById("lastname");
    private final By EMAIL_TEXT_BOX = new By.ById("email");
    private final By PASSWORD_TEXT_BOX = new By.ById("passwd");
    private final By DAY_FOR_DATE_OF_BIRTH = new By.ById("days");
    private final By MONTH_FOR_DATE_OF_BIRTH = new By.ById("months");
    private final By YEAR_FOR_DATE_OF_BIRTH = new By.ById("years");
    private final By DROP_DOWN_OPTIONS = new By.ByTagName("option");
    private final By NEWSLETTER_TICK_BOX = new By.ById("newsletter");
    private final By SPECIAL_OFFERS_TICK_BOX = new By.ById("optin");
    private final By COMPANY_TEXT_BOX = new By.ById("company");
    private final By ADDRESS_ONE_TEXT_BOX = new By.ById("address1");
    private final By ADDRESS_TWO_TEXT_BOX = new By.ById("address2");
    private final By CITY_TEXT_BOX = new By.ById("city");
    private final By STATE_DROP_DOWN = new By.ById("id_state");
    private final By ZIP_POSTAL_CODE = new By.ById("postcode");
    private final By COUNTRY_DROPDOWN = new By.ById("id_country");
    private final By OTHER_INFO_TEXT_BOX = new By.ById("other");
    private final By HOME_PHONE_TEXT_BOX = new By.ById("phone");
    private final By MOBILE_PHONE_TEXT_BOX = new By.ById("phone_mobile");
    private final By ADDRESS_ALIAS_TEXT_BOX = new By.ById("alias");
    private final By REGISTER_BUTTON = new By.ById("submitAccount");

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=identity#account-creation");
    }

    public boolean isPhoneNumberErrorPresent(){
        return webDriver.getPageSource().contains("You must register at least one phone number.");
    }

    public boolean isLastNameErrorPresent(){
        return webDriver.getPageSource().contains("lastname is required.");
    }

    public boolean isFirstNameErrorPresent(){
        return webDriver.getPageSource().contains("firstname is required.");
    }

    public boolean isPasswordErrorPresent(){
        return webDriver.getPageSource().contains("passwd is required.");
    }

    public boolean isAddressOneErrorPresent(){
        return webDriver.getPageSource().contains("address1 is required.");
    }

    public boolean isCityErrorPresent(){
        return webDriver.getPageSource().contains("city is required.");
    }

    public boolean isZipPostCodeErrorPresent(){
        return webDriver.getPageSource().contains("The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
    }

    public boolean isCountryErrorPresent(){
        return webDriver.getPageSource().contains("This country requires you to choose a State.");
    }

    public RegistrationPage chooseSocialTitleAsMr(){
        webDriver.findElement(SOCIAL_TITLE_MR).click();
        return this;
    }

    public RegistrationPage chooseSocialTitleAsMrs(){
        webDriver.findElement(SOCIAL_TITLE_MRS).click();
        return this;
    }

    public RegistrationPage enterTextInFirstNameTextBox(String text){
        webDriver.findElement(FIRST_NAME_TEXT_BOX).sendKeys(text);
        return this;
    }

    public RegistrationPage enterTextInLastNameTextBox(String text){
        webDriver.findElement(LAST_NAME_TEXT_BOX).sendKeys(text);
        return this;
    }

    public RegistrationPage enterTextInEmailTextBox(String text){
        webDriver.findElement(EMAIL_TEXT_BOX).sendKeys(text);
        return this;
    }

    public RegistrationPage selectDayForDateOfBirth(int day){
        webDriver.findElement(DAY_FOR_DATE_OF_BIRTH).click();
        webDriver.findElement(DAY_FOR_DATE_OF_BIRTH)
                .findElements(DROP_DOWN_OPTIONS)
                .get(day)
                .click();
        return this;
    }

    public RegistrationPage selectMonthForDateOfBirth(int month){
        webDriver.findElement(MONTH_FOR_DATE_OF_BIRTH).click();
        webDriver.findElement(MONTH_FOR_DATE_OF_BIRTH)
                .findElements(DROP_DOWN_OPTIONS)
                .get(month)
                .click();
        return this;
    }

    public RegistrationPage selectYearForDateOfBirth(int year){
        webDriver.findElement(YEAR_FOR_DATE_OF_BIRTH).click();
        webDriver.findElement(YEAR_FOR_DATE_OF_BIRTH)
                .findElements(DROP_DOWN_OPTIONS)
                .get(year)
                .click();
        return this;
    }

    public RegistrationPage clickTickBoxForNewsLetter(){
        webDriver.findElement(NEWSLETTER_TICK_BOX).click();
        return this;
    }

    public RegistrationPage clickTickBoxForSpecialOffers(){
        webDriver.findElement(SPECIAL_OFFERS_TICK_BOX).click();
        return this;
    }

    public RegistrationPage enterTextInPasswordTextBox(String text){
        webDriver.findElement(PASSWORD_TEXT_BOX).sendKeys(text);
        return this;
    }

    public RegistrationPage enterTextInCompanyTextBox(String text) {
        webDriver.findElement(COMPANY_TEXT_BOX).sendKeys(text);
        return this;
    }

    public RegistrationPage enterTextInAddressOneTextBox(String text) {
        webDriver.findElement(ADDRESS_ONE_TEXT_BOX).sendKeys(text);
        return this;
    }

    public RegistrationPage enterTextInAddressTwoTextBox(String text){
        webDriver.findElement(ADDRESS_TWO_TEXT_BOX).sendKeys(text);
        return this;
    }

    public RegistrationPage enterTextInCityTextBox(String text){
        webDriver.findElement(CITY_TEXT_BOX).sendKeys(text);
        return this;
    }

    public RegistrationPage selectStateAtIndex(int index){
        webDriver.findElement(STATE_DROP_DOWN)
                .findElements(DROP_DOWN_OPTIONS)
                .get(index)
                .click();
        return this;
    }

    public RegistrationPage enterTextInPostCodeTextBox(String text){
        webDriver.findElement(ZIP_POSTAL_CODE).sendKeys(text);
        return this;
    }

    public RegistrationPage selectedCountryAtIndex(int index){
        webDriver.findElement(COUNTRY_DROPDOWN)
                .findElements(DROP_DOWN_OPTIONS)
                .get(index)
                .click();
        return this;
    }

    public RegistrationPage enterTextInOtherInfoTextBox(String text){
        webDriver.findElement(OTHER_INFO_TEXT_BOX).sendKeys(text);
        return this;
    }

    public RegistrationPage enterTextInHomePhoneTextBox(String text){
        webDriver.findElement(HOME_PHONE_TEXT_BOX).sendKeys(text);
        return this;
    }

    public RegistrationPage enterTextInMobilePhoneTextBox(String text){
        webDriver.findElement(MOBILE_PHONE_TEXT_BOX).sendKeys(text);
        return this;
    }

    public RegistrationPage enterTextInAddressAliasTextBox(String text){
        webDriver.findElement(ADDRESS_ALIAS_TEXT_BOX).sendKeys(text);
        return this;
    }

    public void clickRegisterButton(){
        webDriver.findElement(REGISTER_BUTTON).click();
    }
}
