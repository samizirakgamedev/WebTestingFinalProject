package org.carefulchameleons.pom.myaccounts;

import org.carefulchameleons.pom.Page;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends Page {
    public MyAccountPage(WebDriver webDriver, String expected_url) {
        super(webDriver, expected_url);
    }
}
