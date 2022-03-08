package org.carefulchameleons.pom.category;

import org.carefulchameleons.pom.enums.ColourSelection;
import org.carefulchameleons.pom.Page;
import org.carefulchameleons.pom.ProductSelection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends Page {
    private static final String URL_BASE = "http://automationpractice.com/index.php?id_category=%d&controller=category";

    public CategoryPage(WebDriver webDriver, int categoryId) {
        super(webDriver, makeUrl(categoryId));
    }

    private static String makeUrl(int categoryID) {
        return String.format(URL_BASE, categoryID);
    }

    public ProductSelection getProductSelection() {
        return new ProductSelection(webDriver, this);
    }

    public CategoryPage selectComposition(String composition){
        switch(composition) {
            case "cotton":
                webDriver.findElement(new By.ById("layered_id_feature_5")).click();
                break;
            case "polyester":
                webDriver.findElement(new By.ById("layered_id_feature_1")).click();
                break;
            case "viscose":
                webDriver.findElement(new By.ById("layered_id_feature_3")).click();
                break;
        }
        return this;
    }

    public CategoryPage selectStyle(String styles){
        switch(styles){
            case "casual":
                webDriver.findElement(new By.ById("layered_id_feature_11")).click();
                break;
            case "dressy":
                webDriver.findElement(new By.ByName("layered_id_feature_16")).click();
                break;
            case "girly":
                webDriver.findElement(new By.ByName("layered_id_feature_13")).click();
                break;
        }
        return this;
    }

    public CategoryPage selectSize(String size){
        switch(size){
            case "s":
                webDriver.findElement(new By.ByName("layered_id_attribute_group_1")).click();
                break;
            case "m":
                webDriver.findElement(new By.ByName("layered_id_attribute_group_2")).click();
                break;
            case "l":
                webDriver.findElement(new By.ByName("layered_id_attribute_group_3")).click();
                break;
        }
        return this;
    }

    public CategoryPage selectCategory(String category) {
        switch (category) {
            case "tops":
                webDriver.findElement(new By.ByName("layered_category_4")).click();
                break;
            case "dresses":
                webDriver.findElement(new By.ByName("layered_category_8")).click();
                break;
        }
        return this;
    }

    public CategoryPage selectProperties(String property){
        switch(property){
            case "colourful dress":
                webDriver.findElement(new By.ByName("layered_id_feature_18")).click();
                break;
            case "midi dress":
                webDriver.findElement(new By.ByName("layered_id_feature_20")).click();
                break;
            case "short sleeve":
                webDriver.findElement(new By.ByName("layered_id_feature_17")).click();
                break;
            case "maxi dress":
                webDriver.findElement(new By.ByName("layered_id_feature_21")).click();
                break;
            case "short dress":
                webDriver.findElement(new By.ByName("layered_id_feature_19")).click();
                break;
        }
        return this;
    }

    public CategoryPage selectAvailability(String availability) {
        switch (availability) {
            case "in stock":
                webDriver.findElement(new By.ByName("layered_quantity_1")).click();
                break;
        }
        return this;
    }

    public CategoryPage selectManufacturer(String manufacturer) {
        switch (manufacturer) {
            case "fashion manufacturer":
                webDriver.findElement(new By.ByName("layered_manufacturer_1")).click();
                break;
        }
        return this;
    }

    public CategoryPage selectCondition(String condition) {
        switch (condition) {
            case "new":
                webDriver.findElement(new By.ByName("layered_condition_new")).click();
                break;
        }
        return this;
    }

    public CategoryPage selectColour(ColourSelection colour) {
        colour.clickCheckbox(webDriver);
        return this;
    }
    public CategoryPage selectComposition(ColourSelection composition) {
        composition.clickCheckbox(webDriver);
        return this;
    }

    public CategoryPage selectCategory(ColourSelection category) {
        category.clickCheckbox(webDriver);
        return this;
    }

    public CategoryPage selectStyles(ColourSelection style) {
        style.clickCheckbox(webDriver);
        return this;
    }

    public CategoryPage selectSize(ColourSelection size) {
        size.clickCheckbox(webDriver);
        return this;
    }


}
