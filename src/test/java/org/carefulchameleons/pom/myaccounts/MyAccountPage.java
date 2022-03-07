package org.carefulchameleons.pom.myaccounts;

import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends Page {

    private WebDriver webDriver;

    private final By myAccountList = new By.ByClassName("myaccount-link-list");

    public MyAccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public MyOrderHistoryPage goToMyOrderHistoryPage() {
        webDriver.findElement(myAccountList).findElement(By.xpath("//a[@title='Orders']")).click();
        return new MyOrderHistoryPage();
    }

    public MyCreditSlipsPage goToMyCreditSlipsPage() {
        webDriver.findElement(myAccountList).findElement(By.xpath("//a[@title='Credit slips']")).click();
        return new MyCreditSlipsPage();
    }

    public MyAddressPage goToMyAddressesPage() {
        webDriver.findElement(myAccountList).findElement(By.xpath("//a[@title='Addresses']")).click();
        return new MyAddressPage();
    }

    public MyPersonalInfoPage goToMyPersonalInfoPage() {
        webDriver.findElement(myAccountList).findElement(By.xpath("//a[@title='Information']")).click();
        return new MyPersonalInfoPage();
    }

    public MyWishListPage goToMyWishListPage() {
        webDriver.findElement(myAccountList).findElement(By.xpath("//a[@title='My wishlists']")).click();
        return new MyWishListPage();
    }

}
