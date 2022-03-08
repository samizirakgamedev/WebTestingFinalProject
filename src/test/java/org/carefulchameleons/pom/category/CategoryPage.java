package org.carefulchameleons.pom.category;

import org.carefulchameleons.pom.Page;
import org.carefulchameleons.pom.ProductSelection;
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
}
