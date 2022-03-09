package org.carefulchameleons.pageelements;

import org.carefulchameleons.pom.category.CategoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DressesMenu{
    private WebDriver webDriver;
    private By casualDresses;
    private By eveningDresses;
    private By summerDresses;
    public DressesMenu(WebDriver webDriver){
        this.webDriver = webDriver;
        casualDresses = By.linkText("CASUAL DRESSES");
        eveningDresses = By.linkText("EVENING DRESSES");
        summerDresses = By.linkText("SUMMER DRESSES");
    }

    public CategoryPage clickOnEveningDress(){
        webDriver.findElement(eveningDresses).click();
        return new CategoryPage(webDriver, 10);
    }

    public CategoryPage clickOnCasualDress(){
        webDriver.findElement(casualDresses).click();
        return new CategoryPage(webDriver, 9);
    }

    public CategoryPage clickOnSummerDress(){
        webDriver.findElement(summerDresses).click();
        return new CategoryPage(webDriver, 11);
    }

    public DressesMenu assignCasualDresses(By casualDresses) {
        this.casualDresses = casualDresses;
        return this;
    }

    public DressesMenu assignEveningDressesNav(By eveningDresses) {
        this.eveningDresses = eveningDresses;
        return this;
    }

    public DressesMenu assignSummerDressesNav(By summerDresses) {
        this.summerDresses = summerDresses;
        return this;
    }
}