package org.carefulchameleons.pom.information;

import org.carefulchameleons.pageelements.*;
import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.Page;
import org.carefulchameleons.pom.SearchPage;
import org.carefulchameleons.pom.category.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class NewProductsPage extends Page {

    private WebDriver webDriver;
    private By searchBar;
    private By searchButton;
    private By homeNavIcon;
    private By womenNav;
    private By topsNav;
    public NewProductsPage(WebDriver webDriver){
        super(webDriver, "http://automationpractice.com/index.php?controller=new-products");
        this.webDriver = webDriver;
        homeNavIcon = By.className("home");
        womenNav = By.linkText("WOMEN");
        topsNav = By.linkText("TOPS");
    }

    public IndexPage clickLogo(){
        return new LogoButton(webDriver).click();
    }

    public IndexPage clickHomeNavIcon(){
        webDriver.findElement(homeNavIcon).click();
        return new IndexPage(webDriver);
    }

    public SearchBar searchBar(){
        return new SearchBar(webDriver);
    }

    public CategoryMenu categoryMenu(){
        return new CategoryMenu(webDriver);
    }

    public LeftColumn leftColumn(){
        return new LeftColumn(webDriver);
    }
}


