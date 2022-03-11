package org.carefulchameleons.pageelements.leftcoloumelements;

import org.carefulchameleons.pom.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SuppliersBlock{
    private WebDriver webDriver;
    private WebElement root;

    public SuppliersBlock(WebDriver webDriver, WebElement root){
        this.webDriver = webDriver;
        this.root = root;
    }

    public SearchPage clickSuppliers(){
        root.findElement(By.partialLinkText("SUPPLIERS")).click();
        return new SearchPage(webDriver, "");

    }
    public SearchPage clickFashionSupplier(){
        root.findElement(By.partialLinkText("Fashion Supplier")).click();
        return new SearchPage(webDriver, "");

    }
    public SearchPage selectFashionSupplier(){
        new Select(root.findElement(By.tagName("select"))).selectByIndex(1);
        return new SearchPage(webDriver, "");
    }
}

