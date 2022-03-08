package org.carefulchameleons.pom;

import io.cucumber.java.bs.I;
import org.carefulchameleons.pageelements.CategoryMenu;
import org.carefulchameleons.pageelements.LogoButton;
import org.carefulchameleons.pageelements.SearchBar;
import org.carefulchameleons.pom.cart.CartSummaryPage;
import org.carefulchameleons.pom.category.*;
import org.carefulchameleons.pom.information.BestSellersPage;
import org.carefulchameleons.pom.information.NewProductsPage;
import org.carefulchameleons.pom.information.OurStores;
import org.carefulchameleons.pom.information.SpecialsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IndexPage extends Page {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php");
        //new NewProductsPage(webDriver).;
        new IndexPage(webDriver).featuredItems().clickOnEye(1);
        //webDriver.close();
        //webDriver.quit();
    }

    public class ProductAddedToCartPopUp{
        private WebDriver webDriver;
        private WebElement root;
        public ProductAddedToCartPopUp(WebDriver webDriver, WebElement root){
            this.webDriver = webDriver;
            this.root = root;
        }
        public IndexPage clickContinueShopping(){
            root.findElements(By.className("continue"));
            return new IndexPage(webDriver);
        }

        public CartSummaryPage clickProceesToCheckout(){
            root.findElement(By.partialLinkText("Proceed to checkout")).click();
            return new CartSummaryPage(webDriver);
        }

    }

    private class ItemFancyBox{

        public ItemFancyBox(WebDriver webDriver) {
            webDriver.switchTo().frame(webDriver.findElement(By.className("fancybox-iframe")));
        }

        public IndexPage clickExit(){
            webDriver.switchTo().frame(0);
            webDriver.findElement(By.className("fancybox-close")).click();
            return new IndexPage(webDriver);
        }
    }

    private class ItemDisplay{
        private WebDriver webDriver;
        private WebElement root;
        public ItemDisplay(WebDriver webDriver, WebElement root){
            this.webDriver = webDriver;

        }
        public void clickOnImage(int index){
            root.findElements(By.tagName("img")).get(index).click();
        }

        public ItemFancyBox clickOnEye(int index){
            root.findElements(By.className("quick-view-mobile")).get(index).click();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            return new ItemFancyBox(webDriver);
        }

        public void clickOnTitle(int index){
            root.findElements(By.className("product-name")).get(index).click();
            return;
        }


        public IndexPage getPrice(int index, String price){
            price = root.findElements(By.className("product-price")).get(index).getText();
            return new IndexPage(webDriver);
        }

        public ProductAddedToCartPopUp addItemToCart(int index){
            root.findElements(By.partialLinkText("Add to cart")).get(index).click();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
            return new ProductAddedToCartPopUp(webDriver, webDriver.findElement(By.id("layer_cart")));
        }



        public void clickOnMore(int index){
            root.findElements(By.partialLinkText("More")).get(index).click();

        }


    }

    public IndexPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php");
    }

    public CategoryMenu categoryMenu(){
        return new CategoryMenu(webDriver);
    }

    public IndexPage clickOnYourLogo(){
        return new LogoButton(webDriver).click();
    }

    public SearchPage doSearch(String entry){
        return new SearchBar(webDriver).doSearch(entry);
    }

    public IndexPage clickPopularButton(){
        webDriver.findElement(By.linkText("POPULAR")).click();
        return this;
    }

    public IndexPage clickBestSellerButton(){
        webDriver.findElement(By.linkText("BEST SELLERS")).click();
        return this;
    }

    public ItemDisplay featuredItems(){
        return new ItemDisplay(webDriver, webDriver.findElement(By.id("homefeatured")));
    }

    public PageFooter pageFooter(){
        return new PageFooter(webDriver);
    }

}
