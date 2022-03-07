package org.carefulchameleons.pom.category;

import org.carefulchameleons.pom.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WomenPage extends Page {
    private WebDriver driver;
    private String url = "http://automationpractice.com/index.php?id_category=3&controller=category";
    protected final By BY_PRODUCT_CONTAINER = new By.ByClassName("product-container");
    protected final By BY_PRODUCT_NAME = new By.ByClassName("product-name");

    public WomenPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean areProductsInOrder(List<String> expectedOrder) {

    }

    private List<WebElement> getProducts() {
        return driver.findElements(BY_PRODUCT_CONTAINER);
    }

    private String getProductName(WebElement w) {
        return w.findElement(BY_PRODUCT_NAME).getText();
    }
}
