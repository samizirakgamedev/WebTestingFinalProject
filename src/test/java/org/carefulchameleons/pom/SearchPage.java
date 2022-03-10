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
    private final By SEARCH_RESULTS_TEXT = new By.ByClassName("heading-counter");
    private final By PRODUCT_CONTAINER = new By.ByClassName("product-image-container");
    private final By SORT_DROP_DOWN = new By.ById("uniform-selectProductSort");
    private final By DROP_DOWN_SPAN = new By.ByTagName("span");

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

    public String getSelectedSortByAsString(){
        return webDriver.findElement(SORT_DROP_DOWN)
                .findElement(DROP_DOWN_SPAN)
                .getText();
    }

    /**
     *
     * @param choice - Options: "price:asc", "price:desc", "name:asc", "name:desc", "quantity:desc", "reference:asc", "reference:desc"
     * @return
     */
    public SearchPage sortByGivenChoice(String choice){
        webDriver.findElement(SORT_BY_DROP_DOWN).click();
        List<WebElement> sortOptions = webDriver.findElements(SORT_BY_OPTIONS);

        for (WebElement element : sortOptions) {
            if (element.getAttribute("value").equals(choice)){
                element.click();
            }
        }
        return new SearchPage(webDriver, null);
    }

    public String getTextOfNumberOfSearchResults(){
        return webDriver.findElement(SEARCH_RESULTS_TEXT).getText();
    }

    public int getNumberOfItemsInSearchResults(){
        return webDriver.findElements(PRODUCT_CONTAINER).size();
    }


}
