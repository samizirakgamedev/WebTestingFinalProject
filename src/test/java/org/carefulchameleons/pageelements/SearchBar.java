package org.carefulchameleons.pageelements;

import org.carefulchameleons.pom.SearchPage;
import org.carefulchameleons.pom.information.NewProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBar {
    private WebDriver webDriver;
    private By searchBar;
    private By searchButton;


    public SearchBar(WebDriver webDriver){
        this.webDriver = webDriver;
        searchBar = By.name("search_query");
        searchButton = By.name("submit_search");
    }


    public SearchPage doSearch(String entry){
        webDriver.findElement(searchBar).sendKeys(entry);
        webDriver.findElement(searchButton).click();
        return new SearchPage(webDriver);
    }

    public SearchBar assignSearchBarInput(By inputBox){
        searchBar = inputBox;
        return this;
    }

    public SearchBar assignSearchBarButton(By button){
        searchButton = button;
        return this;
    }
}
