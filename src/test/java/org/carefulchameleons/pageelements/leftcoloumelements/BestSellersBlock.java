package org.carefulchameleons.pageelements.leftcoloumelements;

import org.carefulchameleons.pom.ItemPage;
import org.carefulchameleons.pom.SearchPage;
import org.carefulchameleons.pom.information.BestSellersPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BestSellersBlock {
    public class BestSellerItem{
        private WebElement root;
        private By image = By.tagName("img");
        private By itemName = By.className("product-name");
        public BestSellerItem(WebDriver webDriver, WebElement root) {
            this.root = root;
        }

        public ItemPage clickImage(){
            root.findElement(image).click();
            return new ItemPage(webDriver);
        }

        public ItemPage clickItemName(){
            root.findElement(itemName).click();
            return new ItemPage(webDriver);
        }
    }

    private WebDriver webDriver;
    private By root = By.id("best-sellers_block_right");
    private By topSellers = By.linkText("TOP SELLERS");
    private By bestSellers = By.className("lnk");
    private By items = By.className("products-block");
    private By singleItem = By.tagName("li");
    public BestSellersBlock(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public SearchPage clickTopSellers(){
        this.webDriver.findElement(root).findElement(topSellers).click();
        return new SearchPage(webDriver, "");
    }

    public BestSellersPage clickAllBestSellers(){
        webDriver.findElement(root).findElement(bestSellers).click();
        return new BestSellersPage(webDriver);
    }

    public BestSellerItem getBestSellerItem(int i){
        WebElement element = webDriver.findElement(root)
                .findElement(items)
                .findElements(singleItem)
                .get(i);
        return new BestSellerItem(webDriver, element);
    }
}