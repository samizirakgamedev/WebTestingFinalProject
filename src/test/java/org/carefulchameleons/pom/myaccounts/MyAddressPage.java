package org.carefulchameleons.pom.myaccounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAddressPage extends AccountDetailsPage {

    private final By ALERT = new By.ByClassName("alert-warning");

    public MyAddressPage(WebDriver webDriver) {
        super(webDriver);
    }



}
