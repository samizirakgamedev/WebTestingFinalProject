package org.carefulchameleons.pageelements.leftcoloumelements;

import org.carefulchameleons.pom.information.OurStores;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OurStoresBlock{
    private WebDriver webDriver;
    private WebElement root;
    public OurStoresBlock(WebDriver webDriver, WebElement root){
        this.webDriver = webDriver;
        this.root = root;
    }
    public OurStores clickOurStores(){
        root.findElement(By.partialLinkText("OUR STORES")).click();
        return new OurStores(webDriver);
    }

    public  OurStores clickOurStoresImage(){
        root.findElement(By.tagName("img")).click();
        return new OurStores(webDriver);
    }

    public OurStores clickDiscoverOurStores(){
        root.findElement(By.partialLinkText("Discover our stores")).click();
        return new OurStores(webDriver);
    }
}


