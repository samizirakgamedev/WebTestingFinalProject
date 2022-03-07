package org.carefulchameleons.pom.category;

import org.carefulchameleons.pom.Page;
import org.openqa.selenium.WebDriver;

public class CategoryPage extends Page implements HasProducts{
    private static final String URL_BASE = "http://automationpractice.com/index.php?id_category=%d&controller=category";

    public CategoryPage(WebDriver webDriver, int categoryId) {
        super(webDriver, makeUrl(categoryId));
    }

    private static String makeUrl(int categoryID) {
        return String.format(URL_BASE, categoryID);
    }

    public void addToCart(Product p) {
        
    }
}
