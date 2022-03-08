package org.carefulchameleons.pom.myaccounts;

import org.carefulchameleons.pom.Page;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Page {
    public SignInPage(WebDriver webDriver, String expected_url) {
        super(webDriver, expected_url);
    }
}
