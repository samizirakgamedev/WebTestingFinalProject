package org.carefulchameleons.pom;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends Page {

    private final By searchBar = new By.ById("search_query_top");
    private final By sortByDropDown = new By.ById("selectProductSort");
    private final By sortByOptions = new By.ByTagName("option");
    private final By gridView = new By.ByClassName("icon-th-large");
    private final By listView = new By.ByClassName("icon-th-list");

    public SearchPage(WebDriver webDriver, String expected_url) {
        super(webDriver, null);
    }

    public ProductSelection getProductSelection(){
        return new ProductSelection(webDriver, this);
    }

    public String getTextInSearchBox(){
        return webDriver.findElement(searchBar).getAttribute("value");
    }

    public SearchPage clickGridView(){
        webDriver.findElement(gridView).click();
        return new SearchPage(webDriver, null);
    }

    public SearchPage clickListView(){
        webDriver.findElement(listView).click();
        return new SearchPage(webDriver, null);
    }

    public SearchPage sortByPriceLowestToHighest(){
        webDriver.findElement(sortByDropDown).click();
        List<WebElement> sortOptions = webDriver.findElements(sortByOptions);

        for (WebElement element : sortOptions) {
            if (element.getAttribute("value").equals("price:asc")){
                element.click();
            }
        }
        return new SearchPage(webDriver, null);
    }

    public SearchPage sortByPriceHighestToLowest(){
        webDriver.findElement(sortByDropDown).click();
        List<WebElement> sortOptions = webDriver.findElements(sortByOptions);

        for (WebElement element : sortOptions) {
            if (element.getAttribute("value").equals("price:desc")){
                element.click();
            }
        }
        return new SearchPage(webDriver, null);
    }

    public SearchPage sortByProductNameAToZ(){
        webDriver.findElement(sortByDropDown).click();
        List<WebElement> sortOptions = webDriver.findElements(sortByOptions);

        for (WebElement element : sortOptions) {
            if (element.getAttribute("value").equals("name:asc")){
                element.click();
            }
        }
        return new SearchPage(webDriver, null);
    }

    public SearchPage sortByProductNameZToA(){
        webDriver.findElement(sortByDropDown).click();
        List<WebElement> sortOptions = webDriver.findElements(sortByOptions);

        for (WebElement element : sortOptions) {
            if (element.getAttribute("value").equals("name:desc")){
                element.click();
            }
        }
        return new SearchPage(webDriver, null);
    }

    public SearchPage sortByQuantityInDesc(){
        webDriver.findElement(sortByDropDown).click();
        List<WebElement> sortOptions = webDriver.findElements(sortByOptions);

        for (WebElement element : sortOptions) {
            if (element.getAttribute("value").equals("quantity:desc")){
                element.click();
            }
        }
        return new SearchPage(webDriver, null);
    }

    public SearchPage sortByReferenceLowestFirst(){
        webDriver.findElement(sortByDropDown).click();
        List<WebElement> sortOptions = webDriver.findElements(sortByOptions);

        for (WebElement element : sortOptions) {
            if (element.getAttribute("value").equals("reference:asc")){
                element.click();
            }
        }
        return new SearchPage(webDriver, null);
    }

    public SearchPage sortByReferenceHighestFirst(){
        webDriver.findElement(sortByDropDown).click();
        List<WebElement> sortOptions = webDriver.findElements(sortByOptions);

        for (WebElement element : sortOptions) {
            if (element.getAttribute("value").equals("reference:desc")){
                element.click();
            }
        }
        return new SearchPage(webDriver, null);
    }
}
