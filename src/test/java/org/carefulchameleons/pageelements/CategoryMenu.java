package org.carefulchameleons.pageelements;

import org.carefulchameleons.pom.category.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class CategoryMenu{

    private WebDriver webDriver;
    private By dressesNav;
    private By tShirtsNav;
    private By womenNav;
    public CategoryMenu(WebDriver webDriver){
        this.webDriver = webDriver;
        dressesNav = By.linkText("DRESSES");
        tShirtsNav = By.linkText("T-SHIRTS");
        womenNav = By.linkText("WOMEN");
    }

    public CategoryPage clickDresses(){
        webDriver.findElement(dressesNav).click();
        return new CategoryPage(webDriver, 8);
    }

    public CategoryPage clickTShirt(){
        webDriver.findElement(tShirtsNav).click();
        return new CategoryPage(webDriver, 5);
    }
    public CategoryPage clickWomen(){
        webDriver.findElement(womenNav).click();
        return new CategoryPage(webDriver, 3);
    }

    public DressesMenu hoverOverDress(){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(dressesNav), 10, 10);
        actions.perform();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return new DressesMenu(webDriver);
    }

    public WomenMenu hoverOverWomen(){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(womenNav), 10, 10);
        actions.perform();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        return new WomenMenu(webDriver);
    }

    public CategoryMenu assignDresses(By dresses) {
        this.dressesNav = dressesNav;
        return this;
    }
    public CategoryMenu assignTShirts(By tShirts) {
        this.tShirtsNav = tShirtsNav;
        return this;
    }

    public CategoryMenu assignWomen(By women) {
        this.womenNav = womenNav;
        return this;
    }
}