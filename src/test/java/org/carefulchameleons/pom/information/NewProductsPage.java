package org.carefulchameleons.pom.information;

import org.carefulchameleons.pageelements.CartMenu;
import org.carefulchameleons.pageelements.CategoryMenu;
import org.carefulchameleons.pageelements.LogoButton;
import org.carefulchameleons.pageelements.SearchBar;
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
//
//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
//
//        WebDriver webDriver = new ChromeDriver();
//        webDriver.get("http://automationpractice.com/index.php?controller=new-products");
////        new NewProductsPage(webDriver).clickOnTShirtsInWomen();
//        new CartMenu(webDriver).hoverOnShoppingCart().clickCheckout();
//
//        //webDriver.close();
//        //webDriver.quit();
//    }


    private WebDriver webDriver;
    private By searchBar;
    private By searchButton;
    private By homeNavIcon;
    private By womenNav;
    private By topsNav;
    NewProductsPage(WebDriver webDriver){
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

    public SearchPage doSearch(String entry){

        return new SearchBar(webDriver).doSearch(entry);
    }

    public DressesPage clickDresses(){
        return new CategoryMenu(webDriver).clickDresses();
    }

    public CategoryMenu categoryMenu(){
        return new CategoryMenu(webDriver);
    }

    //In dress


    public EveningDressPage clickEveningDressNav(){
        return new CategoryMenu(webDriver).hoverOverDress().clickOnEveningDress();
    }

    public SummerDressPage clickSummerDressNav(){
        return new CategoryMenu(webDriver).hoverOverDress().clickOnSummerDress();
    }

    public CasualDressPage clickCasualDresses(){
        return new CategoryMenu(webDriver).hoverOverDress().clickOnCasualDress();
    }


    public WomenPage clickWomen(){
        return new CategoryMenu(webDriver).clickWomen();
    }

    private WebElement getElementInWomen(By byElement){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(womenNav), 10, 10);
        actions.perform();
        FluentWait fluentWait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
        WebElement element = (WebElement) fluentWait.until(ExpectedConditions.presenceOfElementLocated(byElement));
        return element;
    }

    public TopsPage clickOnTopsInWomen(){
        return new CategoryMenu(webDriver).hoverOverWomen().clickOnTops();

    }

    public TShirtsPage clickOnTShirtsInWomen(){
        return new CategoryMenu(webDriver).hoverOverWomen().clickOnTShirts();
    }
//    public BlousesPage clickOnBlousesInWomen(){
//        return new CategoryMenu(webDriver).hoverOverWomen().clickOnBlouses();
//    }
//
    public DressesPage clickOnDressesInWomen(){
        return new CategoryMenu(webDriver).hoverOverWomen().clickOnDresses();
    }

    public CasualDressPage clickOnCasualDressesInWomen(){
        return new CategoryMenu(webDriver).hoverOverWomen().clickOnCasualDresses();
    }

    public EveningDressPage clickOnEveningDressesInWomen(){
        return new CategoryMenu(webDriver).hoverOverWomen().clickOnEveningDresses();
    }

    public  SummerDressPage clickOnSummerDressesInWomen(){
        return new CategoryMenu(webDriver).hoverOverWomen().clickOnSummerDresses();
    }

    public TShirtsPage clickOnTShirtsNav(){
        return new CategoryMenu(webDriver).clickTShirt();
    }


}


