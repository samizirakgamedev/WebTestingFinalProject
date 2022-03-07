package org.carefulchameleons.pom.myaccounts;

import org.carefulchameleons.pom.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Page {

    private WebDriver webDriver;

    private final By EMAIL = new By.ById("email");
    private final By PASSWORD = new By.ById("passwd");
    private final By LOGIN_BUTTON = new By.ById("SubmitLogin");

    private final By CREATE_EMAIL = new By.ById("email_create");
    private final By CREATE_BUTTON = new By.ById("SubmitCreate");

    public SignInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public SignInPage enterLoginEmail(String emailString) {
        webDriver.findElement(EMAIL).sendKeys(emailString);
        return this;
    }

    public SignInPage enterLoginPassword(String passwordString) {
        webDriver.findElement(PASSWORD).sendKeys(passwordString);
        return this;
    }

    public void clickLoginButton() {
        webDriver.findElement(LOGIN_BUTTON).click();
    }

    public void login(String emailString, String passwordString) {
        enterLoginEmail(emailString).enterLoginPassword(passwordString).clickLoginButton();
    }

    public SignInPage enterCreateEmail(String emailString) {
        webDriver.findElement(CREATE_EMAIL).sendKeys(emailString);
        return this;
    }

    public void clickCreateButton() {
        webDriver.findElement(CREATE_BUTTON).click();
    }

}
