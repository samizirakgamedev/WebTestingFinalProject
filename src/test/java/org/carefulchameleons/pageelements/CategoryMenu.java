package org.carefulchameleons.pageelements;


import org.carefulchameleons.pom.category.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class CategoryMenu{

    public class DressesMenu{
        private WebDriver webDriver;
        private By casualDressesNav;
        private By eveningDressesNav;
        private By summerDressesNav;
        public DressesMenu(WebDriver webDriver){
            this.webDriver = webDriver;
            casualDressesNav = By.linkText("CASUAL DRESSES");
            eveningDressesNav = By.linkText("EVENING DRESSES");
            summerDressesNav = By.linkText("SUMMER DRESSES");
        }

        public EveningDressPage clickOnEveningDress(){
            webDriver.findElement(eveningDressesNav).click();
            return new EveningDressPage(webDriver);
        }

        public CasualDressPage clickOnCasualDress(){
            webDriver.findElement(casualDressesNav).click();
            return new CasualDressPage(webDriver);
        }

        public SummerDressPage clickOnSummerDress(){
            webDriver.findElement(summerDressesNav).click();
            return new SummerDressPage(webDriver);
        }

        public DressesMenu assignCasualDressesNav(By casualDressesNav) {
            this.casualDressesNav = casualDressesNav;
            return this;
        }

        public DressesMenu assignEveningDressesNav(By eveningDressesNav) {
            this.eveningDressesNav = eveningDressesNav;
            return this;
        }

        public DressesMenu assignSummerDressesNav(By summerDressesNav) {
            this.summerDressesNav = summerDressesNav;
            return this;
        }
    }

    public class WomenMenu{
        private WebDriver webDriver;
        private By rootElement = By.id("block_top_menu");
        private By tShirts = By.linkText("T-shirts");
        private By blouses = By.linkText("Blouses");
        private By tops = By.linkText("TOPS");
        private By dresses = By.linkText("DRESSES");
        private By casualDresses = By.linkText("Casual Dresses");
        private By eveningDresses = By.linkText("Evening Dresses");
        private By summerDresses = By.linkText("Summer Dresses");

        public WomenMenu(WebDriver webDriver) {
            this.webDriver = webDriver;
        }

        public TopsPage clickOnTops(){
            webDriver.findElement(rootElement).findElement(tops).click();
            return new TopsPage(webDriver);
        }

        public TShirtsPage clickOnTShirts() {
            webDriver.findElement(rootElement).findElement(tShirts).click();
            return new TShirtsPage(webDriver);
        }

//            public BlousesPage clickOnBlouses() {
//                webDriver.findElement(rootElement).findElement(blouses).click();
//                return new BlousesPage()
//
//            }

        public DressesPage clickOnDresses() {
            webDriver.findElement(rootElement).findElement(dresses);
            return new DressesPage(webDriver);
        }

        public SummerDressPage clickOnSummerDresses() {
            webDriver.findElement(rootElement).findElement(summerDresses);
            return new SummerDressPage(webDriver);
        }

        public CasualDressPage clickOnCasualDresses() {
            webDriver.findElement(rootElement).findElement(casualDresses);
            return new CasualDressPage(webDriver);
        }

        public EveningDressPage clickOnEveningDresses() {
            webDriver.findElement(rootElement).findElement(eveningDresses);
            return new EveningDressPage(webDriver);
        }

        public WomenMenu assignRootElement(By rootElement) {
            this.rootElement = rootElement;
            return this;

        }

        public WomenMenu assignBlouses(By blouses) {
            this.blouses = blouses;
            return this;
        }

        public WomenMenu assignTops(By tops) {
            this.tops = tops;
            return this;

        }

        public WomenMenu assignDresses(By dresses) {
            this.dresses = dresses;
            return this;

        }

        public WomenMenu assignCasualDresses(By casualDresses) {
            this.casualDresses = casualDresses;
            return this;

        }

        public WomenMenu assignEveningDresses(By eveningDresses) {
            this.eveningDresses = eveningDresses;
            return this;

        }

        public WomenMenu assignSummerDresses(By summerDresses) {
            this.summerDresses = summerDresses;
            return this;

        }
    }

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

    public DressesPage clickDresses(){
        webDriver.findElement(dressesNav).click();
        return new DressesPage(webDriver);
    }

    public TShirtsPage clickTShirt(){
        webDriver.findElement(tShirtsNav).click();
        return new TShirtsPage(webDriver);
    }
    public WomenPage clickWomen(){
        webDriver.findElement(womenNav).click();
        return new WomenPage(webDriver);
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

    public CategoryMenu assignDressesNav(By dressesNav) {
        this.dressesNav = dressesNav;
        return this;
    }

    public CategoryMenu assigntShirtsNav(By tShirtsNav) {
        this.tShirtsNav = tShirtsNav;
        return this;

    }

    public CategoryMenu assignWomenNav(By womenNav) {
        this.womenNav = womenNav;
        return this;

    }
}