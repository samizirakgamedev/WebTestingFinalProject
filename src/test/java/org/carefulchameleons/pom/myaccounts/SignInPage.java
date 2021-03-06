package org.carefulchameleons.pom.myaccounts;

import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Page {

    private final By EMAIL = new By.ById("email");
    private final By PASSWORD = new By.ById("passwd");
    private final By LOGIN_BUTTON = new By.ById("SubmitLogin");

    private final By CREATE_EMAIL = new By.ById("email_create");
    private final By CREATE_BUTTON = new By.ById("SubmitCreate");

    private final By TOP_HOME_BUTTON = new By.ByClassName("home");

    public SignInPage(WebDriver webDriver, String expectedUrl) {
        super(webDriver, expectedUrl);
    }

    public SignInPage enterLoginEmail(String emailString) {
        webDriver.findElement(EMAIL).sendKeys(emailString);
        return this;
    }

    public SignInPage enterLoginPassword(String passwordString) {
        webDriver.findElement(PASSWORD).sendKeys(passwordString);
        return this;
    }

    public SignInPage clickLoginButton() {
        webDriver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    /**
     * Attempts to log a user in
     *
     * @param emailString email input
     * @param passwordString password input
     *
     * @return {@link SignInPage} if login is intended to work call {@link #goToMyAccountPage()},
     * else stay on the page
     */
    public SignInPage login(String emailString, String passwordString) {
        enterLoginEmail(emailString).enterLoginPassword(passwordString).clickLoginButton();
        return this;
    }

    public SignInPage enterCreateEmail(String emailString) {
        webDriver.findElement(CREATE_EMAIL).sendKeys(emailString);
        return this;
    }

    public SignInPage clickCreateButton() {
        webDriver.findElement(CREATE_BUTTON).click();
        return this;
    }

    public IndexPage clickHomeButtonTop() {
        webDriver.findElement(TOP_HOME_BUTTON).click();
        return new IndexPage(webDriver);
    }

    public MyAccountPage goToMyAccountPage() {
        return new MyAccountPage(webDriver);
    }
}
