package org.carefulchameleons.pom.myaccounts;

import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends Page {

    private final By MY_ACCOUNT_LIST = new By.ByClassName("myaccount-link-list");
    private final By HOME_BUTTON = new By.ByXPath("//a[@title='Home']");

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=my-account");
    }

    public MyOrderHistoryPageMy goToMyOrderHistoryPage() {
        webDriver.findElement(MY_ACCOUNT_LIST).findElement(By.xpath("//a[@title='Orders']")).click();
        return new MyOrderHistoryPageMy(webDriver);
    }

    public MyAddressPageMy goToMyAddressesPage() {
        webDriver.findElement(MY_ACCOUNT_LIST).findElement(By.xpath("//a[@title='Addresses']")).click();
        return new MyAddressPageMy(webDriver);
    }

    public MyPersonalInfoPageMy goToMyPersonalInfoPage() {
        webDriver.findElement(MY_ACCOUNT_LIST).findElement(By.xpath("//a[@title='Information']")).click();
        return new MyPersonalInfoPageMy(webDriver);
    }

    public IndexPage goToBackToHome() {
        webDriver.findElement(HOME_BUTTON).click();
        return new IndexPage(webDriver);
    }

}
