package org.carefulchameleons.pageelements;


import org.carefulchameleons.pom.category.CategoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public CategoryPage clickOnTops(){
        webDriver.findElement(rootElement).findElement(tops).click();
        return new CategoryPage(webDriver, 4);
    }

    public CategoryPage clickOnTShirts() {
        webDriver.findElement(rootElement).findElement(tShirts).click();
        return new CategoryPage(webDriver, 5);
    }

    public CategoryPage clickOnBlouses() {
        webDriver.findElement(rootElement).findElement(blouses).click();
        return new CategoryPage(webDriver, 7);

    }

    public CategoryPage clickOnDresses() {
        webDriver.findElement(rootElement).findElement(dresses);
        return new CategoryPage(webDriver, 8);
    }

    public CategoryPage clickOnSummerDresses() {
        webDriver.findElement(rootElement).findElement(summerDresses);
        return new CategoryPage(webDriver, 11);
    }

    public CategoryPage clickOnCasualDresses() {
        webDriver.findElement(rootElement).findElement(casualDresses);
        return new CategoryPage(webDriver, 9);
    }

    public CategoryPage clickOnEveningDresses() {
        webDriver.findElement(rootElement).findElement(eveningDresses);
        return new CategoryPage(webDriver, 10);
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