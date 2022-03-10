package org.carefulchameleons.pom;

import org.carefulchameleons.pageelements.CategoryMenu;
import org.carefulchameleons.pageelements.LogoButton;
import org.carefulchameleons.pageelements.SearchBar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage extends Page {

    public IndexPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php");
    }

    public CategoryMenu categoryMenu(){
        return new CategoryMenu(webDriver);
    }

    public IndexPage clickOnYourLogo(){
        return new LogoButton(webDriver).click();
    }

    public SearchPage doSearch(String entry){
        return new SearchBar(webDriver).doSearch(entry);
    }

    public IndexPage clickPopularButton(){
        webDriver.findElement(By.linkText("POPULAR")).click();
        return this;
    }

    public IndexPage clickBestSellerButton(){
        webDriver.findElement(By.linkText("BEST SELLERS")).click();
        return this;
    }

    public ProductSelection featuredItems(){
        return new ProductSelection(webDriver, this);
    }


    public PageFooter pageFooter(){
        return new PageFooter(webDriver);
    }
}
