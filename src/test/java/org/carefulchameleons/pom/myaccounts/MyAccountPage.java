package org.carefulchameleons.pom.myaccounts;

import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends Page {

    private final By MY_ACCOUNT_LIST = new By.ByClassName("myaccount-link-list");
    private final By BOTTOM_HOME_BUTTON = new By.ByXPath("//a[@title='Home']");
    private final By TOP_HOME_BUTTON = new By.ByClassName("home");

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=my-account");
    }

    public MyOrderHistoryPage goToMyOrderHistoryPage() {
        webDriver.findElement(MY_ACCOUNT_LIST).findElement(By.xpath("//a[@title='Orders']")).click();
        return new MyOrderHistoryPage(webDriver);
    }

    public MyAddressPage goToMyAddressesPage() {
        webDriver.findElement(MY_ACCOUNT_LIST).findElement(By.xpath("//a[@title='Addresses']")).click();
        return new MyAddressPage(webDriver);
    }

    public MyPersonalInfoPage goToMyPersonalInfoPage() {
        webDriver.findElement(MY_ACCOUNT_LIST).findElement(By.xpath("//a[@title='Information']")).click();
        return new MyPersonalInfoPage(webDriver);
    }

    public IndexPage clickHomeButtonTop() {
        webDriver.findElement(TOP_HOME_BUTTON).click();
        return new IndexPage(webDriver);
    }

    public IndexPage clickHomeButtonBottom() {
        webDriver.findElement(BOTTOM_HOME_BUTTON).click();
        return new IndexPage(webDriver);
    }

}
