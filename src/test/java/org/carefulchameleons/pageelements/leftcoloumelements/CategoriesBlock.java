package org.carefulchameleons.pageelements.leftcoloumelements;

import org.carefulchameleons.pom.category.CategoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class CategoriesBlock {
    private WebDriver webDriver;
    private WebElement root;
    private By womenButton = By.linkText("Women");
    private By topsButton = By.linkText("Tops");
    private By tShirtButton = By.linkText("T-shirts");
    private By dressesButton = By.linkText("Dresses");
    private By casualDressesButton = By.linkText("Casual Dresses");
    private By eveningDressesButton = By.linkText("Evening Dresses");
    private By summerDressesButton = By.linkText("Summer Dresses");
    private By blousesButton = By.linkText("Blouses");
    public CategoriesBlock(WebDriver webDriver, WebElement root){
        this.webDriver = webDriver;
        this.root = root;

        List<WebElement> elements = root.findElements(new By.ByClassName("grower")) ;
        elements.forEach(e -> e.click());
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

    }

    public CategoryPage clickOnWomen(){
        root.findElement(womenButton).click();
        return new CategoryPage(webDriver, 3);
    }

    public CategoryPage clickOnTops(){
        root.findElement(topsButton).click();
        return new CategoryPage(webDriver, 4);
    }

    public CategoryPage clickOnTShirts(){

        root.findElement(tShirtButton).click();
        return new CategoryPage(webDriver, 5);
    }

    public CategoryPage clickOnBlouses(){
        root.findElement(blousesButton).click();
        return new CategoryPage(webDriver, 7);

    }

    public CategoryPage clickOnDresses(){
        root.findElement(dressesButton).click();
        return new CategoryPage(webDriver, 8);
    }

    public CategoryPage clickOnCasualDresses(){
        root.findElement(casualDressesButton).click();
        return new CategoryPage(webDriver, 9);
    }

    public CategoryPage clickOnEveningDresses(){
        root.findElement(eveningDressesButton).click();
        return new CategoryPage(webDriver, 10);

    }
    public CategoryPage clickOnSummerDresses() {
        root.findElement(summerDressesButton).click();
        return new CategoryPage(webDriver, 11);
    }
}
