package org.carefulchameleons.pom.category;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DressesPage extends WomenPage {
    protected WebDriver webDriver;
    private final String EXPECTED_URL;

    public DressesPage(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

}
