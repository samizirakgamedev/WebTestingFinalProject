package org.carefulchameleons.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends Page {

    private final By SEARCH_BAR = new By.ById("search_query_top");
    private final By SORT_BY_DROP_DOWN = new By.ById("selectProductSort");
    private final By SORT_BY_OPTIONS = new By.ByTagName("option");
    private final By GRID_VIEW = new By.ByClassName("icon-th-large");
    private final By LIST_VIEW = new By.ByClassName("icon-th-list");

    public SearchPage(WebDriver webDriver, String expected_url) {
        super(webDriver, null);
    }

    public ProductSelection getProductSelection(){
        return new ProductSelection(webDriver, this);
    }

    public String getTextInSearchBox(){
        return webDriver.findElement(SEARCH_BAR).getAttribute("value");
    }

    public SearchPage clickGridView(){
        webDriver.findElement(GRID_VIEW).click();
        return new SearchPage(webDriver, null);
    }

    public SearchPage clickListView(){
        webDriver.findElement(LIST_VIEW).click();
        return new SearchPage(webDriver, null);
    }

    public SearchPage sortByPriceLowestToHighest(){
        webDriver.findElement(SORT_BY_DROP_DOWN).click();
        List<WebElement> sortOptions = webDriver.findElements(SORT_BY_OPTIONS);

        for (WebElement element : sortOptions) {
            if (element.getAttribute("value").equals("price:asc")){
                element.click();
            }
        }
        return new SearchPage(webDriver, null);
    }

    public SearchPage sortByPriceHighestToLowest(){
        webDriver.findElement(SORT_BY_DROP_DOWN).click();
        List<WebElement> sortOptions = webDriver.findElements(SORT_BY_OPTIONS);

        for (WebElement element : sortOptions) {
            if (element.getAttribute("value").equals("price:desc")){
                element.click();
            }
        }
        return new SearchPage(webDriver, null);
    }

    public SearchPage sortByProductNameAToZ(){
        webDriver.findElement(SORT_BY_DROP_DOWN).click();
        List<WebElement> sortOptions = webDriver.findElements(SORT_BY_OPTIONS);

        for (WebElement element : sortOptions) {
            if (element.getAttribute("value").equals("name:asc")){
                element.click();
            }
        }
        return new SearchPage(webDriver, null);
    }

    public SearchPage sortByProductNameZToA(){
        webDriver.findElement(SORT_BY_DROP_DOWN).click();
        List<WebElement> sortOptions = webDriver.findElements(SORT_BY_OPTIONS);

        for (WebElement element : sortOptions) {
            if (element.getAttribute("value").equals("name:desc")){
                element.click();
            }
        }
        return new SearchPage(webDriver, null);
    }

    public SearchPage sortByQuantityInDesc(){
        webDriver.findElement(SORT_BY_DROP_DOWN).click();
        List<WebElement> sortOptions = webDriver.findElements(SORT_BY_OPTIONS);

        for (WebElement element : sortOptions) {
            if (element.getAttribute("value").equals("quantity:desc")){
                element.click();
            }
        }
        return new SearchPage(webDriver, null);
    }

    public SearchPage sortByReferenceLowestFirst(){
        webDriver.findElement(SORT_BY_DROP_DOWN).click();
        List<WebElement> sortOptions = webDriver.findElements(SORT_BY_OPTIONS);

        for (WebElement element : sortOptions) {
            if (element.getAttribute("value").equals("reference:asc")){
                element.click();
            }
        }
        return new SearchPage(webDriver, null);
    }

    public SearchPage sortByReferenceHighestFirst(){
        webDriver.findElement(SORT_BY_DROP_DOWN).click();
        List<WebElement> sortOptions = webDriver.findElements(SORT_BY_OPTIONS);

        for (WebElement element : sortOptions) {
            if (element.getAttribute("value").equals("reference:desc")){
                element.click();
            }
        }
        return new SearchPage(webDriver, null);
    }
}
