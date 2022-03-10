package org.carefulchameleons.pom.myaccounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyPersonalInfoPage extends MyAccountSharedPage {

    private final By SOCIAL_TITLE_MR = new By.ById("id_gender1");
    private final By SOCIAL_TITLE_MRS = new By.ById("id_gender2");
    private final By FIRST_NAME_TEXT_BOX = new By.ById("firstname");
    private final By LAST_NAME_TEXT_BOX = new By.ById("lastname");
    private final By EMAIL_TEXT_BOX = new By.ById("email");
    private final By DAY_FOR_DATE_OF_BIRTH = new By.ById("days");
    private final By MONTH_FOR_DATE_OF_BIRTH = new By.ById("months");
    private final By YEAR_FOR_DATE_OF_BIRTH = new By.ById("years");
    private final By DATE_OF_BIRTH_OPTIONS = new By.ByTagName("option");
    private final By CURRENT_PASSWORD_TEXT_BOX = new By.ById("old password");
    private final By NEW_PASSWORD_TEXT_BOX = new By.ById("passwd");
    private final By CONFIRM_PASSWORD_TEXT_BOX = new By.ById("confirmation");
    private final By NEWSLETTER_TICK_BOX = new By.ById("newsletter");
    private final By SPECIAL_OFFERS_TICK_BOX = new By.ById("optin");
    private final By SAVE_BUTTON = new By.ById("submitWishlist");

    public MyPersonalInfoPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=identity");
    }

    public MyPersonalInfoPage chooseSocialTitleAsMr(){
        webDriver.findElement(SOCIAL_TITLE_MR).click();
        return new MyPersonalInfoPage(webDriver);
    }

    public MyPersonalInfoPage chooseSocialTitleAsMrs(){
        webDriver.findElement(SOCIAL_TITLE_MRS).click();
        return this;
    }

    public MyPersonalInfoPage enterTextInFirstNameTextBox(String text){
        webDriver.findElement(FIRST_NAME_TEXT_BOX).sendKeys(text);
        return this;
    }

    public MyPersonalInfoPage enterTextInLastNameTextBox(String text){
        webDriver.findElement(LAST_NAME_TEXT_BOX).sendKeys(text);
        return this;
    }

    public MyPersonalInfoPage enterTextInEmailTextBox(String text){
        webDriver.findElement(EMAIL_TEXT_BOX).sendKeys(text);
        return this;
    }

    public MyPersonalInfoPage selectDayForDateOfBirth(int day){
        webDriver.findElement(DAY_FOR_DATE_OF_BIRTH).click();
        webDriver.findElement(DAY_FOR_DATE_OF_BIRTH)
                .findElements(DATE_OF_BIRTH_OPTIONS)
                .get(day)
                .click();
        return this;
    }

    public MyPersonalInfoPage selectMonthForDateOfBirth(int month){
        webDriver.findElement(MONTH_FOR_DATE_OF_BIRTH).click();
        webDriver.findElement(MONTH_FOR_DATE_OF_BIRTH)
                .findElements(DATE_OF_BIRTH_OPTIONS)
                .get(month)
                .click();
        return this;
    }

    public MyPersonalInfoPage selectYearForDateOfBirth(int year){
        webDriver.findElement(YEAR_FOR_DATE_OF_BIRTH).click();
        webDriver.findElement(YEAR_FOR_DATE_OF_BIRTH)
                .findElements(DATE_OF_BIRTH_OPTIONS)
                .get(year)
                .click();
        return this;
    }

    public MyPersonalInfoPage enterTextInCurrentPasswordTextBox(String text){
        webDriver.findElement(CURRENT_PASSWORD_TEXT_BOX).sendKeys(text);
        return this;
    }

    public MyPersonalInfoPage enterTextInNewPasswordTextBox(String text){
        webDriver.findElement(NEW_PASSWORD_TEXT_BOX).sendKeys(text);
        return this;
    }

    public MyPersonalInfoPage enterTextInConfirmPasswordTextBox(String text){
        webDriver.findElement(CONFIRM_PASSWORD_TEXT_BOX).sendKeys(text);
        return this;
    }

    public MyPersonalInfoPage clickTickBoxForNewsLetter(){
        webDriver.findElement(NEWSLETTER_TICK_BOX).click();
        return this;
    }

    public MyPersonalInfoPage clickTickBoxForSpecialOffers(){
        webDriver.findElement(SPECIAL_OFFERS_TICK_BOX).click();
        return this;
    }

    public MyPersonalInfoPage clickSaveButton(){
        webDriver.findElement(SAVE_BUTTON).click();
        return this;
    }
}
