package org.carefulchameleons.pom.myaccounts;

import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountSharedPage extends Page {

    private final By TOP_NAVIGATION = new By.ByClassName("breadcrumb");
    private final By FOOTER_LINKS = new By.ByClassName("footer_links");

    public MyAccountSharedPage(WebDriver webDriver, String expectedUrl) {
        super(webDriver, expectedUrl);
    }

    public IndexPage clickTopNavigationHome() {

        webDriver.findElement(TOP_NAVIGATION)
                .findElement(By.className("home"))
                .click();

        return new IndexPage(webDriver);
    }

    public MyAccountPage clickTopNavigationMyAccount() {

        webDriver.findElement(TOP_NAVIGATION)
                .findElement(By.linkText(" My account "))
                .click();

        return new MyAccountPage(webDriver);
    }

    public IndexPage clickHomeButton() {

        webDriver.findElement(FOOTER_LINKS)
                .findElements(By.className("btn"))
                .get(1)
                .click();

        return new IndexPage(webDriver);
    }

}
