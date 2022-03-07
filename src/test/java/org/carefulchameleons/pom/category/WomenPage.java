package org.carefulchameleons.pom.category;

import org.carefulchameleons.pom.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WomenPage extends Page {
    private WebDriver driver;
    private String url = "http://automationpractice.com/index.php?id_category=3&controller=category";


    public WomenPage(WebDriver driver) {
        this.driver = driver;
    }

}
