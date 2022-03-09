package org.carefulchameleons.pageelements.leftcoloumelements;

import org.carefulchameleons.pom.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpecialsBlock{
    private WebDriver webDriver;
    private WebElement root;
    public SpecialsBlock(WebDriver webDriver, WebElement root){
        this.webDriver = webDriver;
        this.root = root;

    }

    public SearchPage clickAllSpecials(){
        root.findElement(By.partialLinkText("All specials")).click();
        return new SearchPage(webDriver, "");
    }



    public SearchPage clickSpecials(){
        root.findElement(By.partialLinkText("SPECIALS")).click();
        return new SearchPage(webDriver, "");
    }

}
