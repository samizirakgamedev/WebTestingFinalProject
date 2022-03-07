package org.carefulchameleons.pom.category;

import org.openqa.selenium.WebDriver;

public class WomenPage extends CategoryPage {
    private String url = "http://automationpractice.com/index.php?id_category=3&controller=category";


    public WomenPage(WebDriver webDriver) {
        super(webDriver, 3);
    }

}
