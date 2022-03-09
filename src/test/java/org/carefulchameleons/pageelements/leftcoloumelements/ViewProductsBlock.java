package org.carefulchameleons.pageelements.leftcoloumelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ViewProductsBlock{
    WebDriver webDriver;
    WebElement root;

    public ViewProductsBlock(WebDriver webDriver, WebElement root) {
        this.webDriver = webDriver;
        this.root = root;
    }

    public void clickProductImage(int index){
        root.findElements(By.tagName("li")).get(index)
                .findElement(By.tagName("img")).click();

    }

    public void clickProductTitle(int index){
        root.findElements(By.tagName("li")).get(index)
                .findElement(By.className("product-name")).click();
    }
}