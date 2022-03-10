package org.carefulchameleons.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductFancyPage {

    private WebDriver webDriver;
    public ProductFancyPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.switchTo().frame(webDriver.findElement(By.className("fancybox-iframe")));
    }


    public ProductFancyPage clickSubtract(){
        webDriver.findElement(By.className("button-minus")).click();
        return this;
    }

    public ProductFancyPage clickPlus(){
        webDriver.findElement(By.className("button-plus")).click();
        return this;
    }

    public ProductFancyPage enterQuantity(String quantity){
        webDriver.findElement(By.id("quantity_wanted")).sendKeys(quantity);
        return this;
    }

    public ProductFancyPage selectSize(int index){
        new Select(webDriver.findElement(By.id("group_1"))).selectByIndex(index);
        return this;
    }

    public ProductFancyPage selectColor(int index){
        webDriver.findElement(By.id("color_to_pick_list")).findElements(By.tagName("li")).get(index).click();
        return this;
    }

    public ProductPage clickAddToCart(){
        webDriver.findElement(By.id("add_to_cart")).click();
        webDriver.switchTo().defaultContent();
        return new ProductPage(webDriver, "");
    }

    public ProductFancyPage clickAddToWishList(){
        webDriver.findElement(By.id("wishlist_button")).click();
        return this;
    }


    public IndexPage clickExit(){
        webDriver.switchTo().defaultContent();
        webDriver.findElement(By.className("fancybox-close")).click();
        return new IndexPage(webDriver);
    }

    public ProductFancyPage clickTweet(){
        webDriver.findElement(By.className("btn-twitter")).click();
        return this;
    }

    public ProductFancyPage clickFacebook(){
        webDriver.findElement(By.className("btn-facebook")).click();
        return this;
    }

    public ProductFancyPage clickGooglePlus(){
        webDriver.findElement(By.className("btn-google-plus")).click();
        return this;
    }

    public ProductFancyPage clickPinterest(){
        webDriver.findElement(By.className("btn-pinterest")).click();
        return this;
    }
}
