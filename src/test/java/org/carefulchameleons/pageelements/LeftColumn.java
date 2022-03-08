package org.carefulchameleons.pageelements;

import io.cucumber.java.eo.Se;
import org.carefulchameleons.pom.ItemPage;
import org.carefulchameleons.pom.SearchPage;
import org.carefulchameleons.pom.category.*;
import org.carefulchameleons.pom.information.BestSellersPage;
import org.carefulchameleons.pom.information.OurStores;
import org.carefulchameleons.pom.information.TermsAndConditionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class LeftColumn {

    public class InformationBlock {
        private WebDriver webDriver;
        private WebElement root;
        private By termsAndConditionsButton = By.linkText("Terms and conditions of use");

        InformationBlock(WebDriver webDriver, WebElement root){
            this.webDriver = webDriver;
            this.root = root;
        }

        TermsAndConditionsPage clickTermsAndCondition(){
            root.findElement(termsAndConditionsButton).click();
            return new TermsAndConditionsPage(webDriver);
        }
    }

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

        public BestSellersPage clickToSellers(){
            this.webDriver.findElement(root).findElement(topSellers).click();
            return new BestSellersPage(webDriver);
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

    public class CategoriesBlock {
        private WebDriver webDriver;
        private WebElement root;
        private By womenButton = By.linkText("Women");
        private By topsButton = By.linkText("Tops");
        private By tShirtButton = By.linkText("T-shirts");
        private By dressesButton = By.linkText("Dresses");
        private By casualDressesButton = By.linkText("Casual Dresses");
        private By eveningDressesButton = By.linkText("Evening Dresses");
        private By summerDressesButton = By.linkText("Summer Dresses");

        CategoriesBlock(WebDriver webDriver, WebElement root){
            this.webDriver = webDriver;
            this.root = root;

            List<WebElement> elements = root.findElements(new By.ByClassName("grower")) ;
            elements.forEach(e -> e.click());
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        }

        public WomenPage clickOnWomen(){
            root.findElement(womenButton).click();
            return new WomenPage(webDriver);
        }

        public TopsPage clickOnTops(){
            root.findElement(topsButton).click();
            return new TopsPage(webDriver);
        }

        public TShirtsPage clickOnTShirts(){

            root.findElement(tShirtButton).click();
            return new TShirtsPage(webDriver);
        }

//        public  clickOnBlouses(){
//            openWomen();
//            openTops();
//            root.findElement(blousesButton).click();
//        }

        public DressesPage clickOnDresses(){
            root.findElement(dressesButton).click();
            return new DressesPage(webDriver);
        }

        public CasualDressPage clickOnCasualDresses(){
            root.findElement(casualDressesButton).click();
            return new CasualDressPage(webDriver);
        }

        public EveningDressPage clickOnEveningDresses(){
            root.findElement(eveningDressesButton).click();
            return new EveningDressPage(webDriver);

        }
        public SummerDressPage clickOnSummerDresses() {
            root.findElement(summerDressesButton).click();
            return new SummerDressPage(webDriver);
        }
    }

    public class ManufacturersBlock{
        WebElement root;
        WebDriver webDriver;
        By fashionManufacturerButton = By.partialLinkText("Fashion Manufacturer");
        By manufacturerSelection = By.tagName("select");
        public ManufacturersBlock( WebDriver webDriver, WebElement root) {
            this.root = root;
            this.webDriver = webDriver;
        }

        public SearchPage clickFashionManufacturer(){
            webDriver.findElement(fashionManufacturerButton).click();
            return new SearchPage(webDriver);
        }

        public SearchPage selectAFashionManufacturer(){
            new Select(root.findElement(manufacturerSelection)).selectByIndex(1);
            return new SearchPage(webDriver);
        }
    }

    public class SpecialsBlock{
        private WebDriver webDriver;
        private WebElement root;
        public SpecialsBlock(WebDriver webDriver, WebElement root){
            this.webDriver = webDriver;
            this.root = root;

        }

        public SearchPage clickAllSpecials(){
            root.findElement(By.partialLinkText("All specials")).click();
            return new SearchPage(webDriver);
        }



        public SearchPage clickSpecials(){
            root.findElement(By.partialLinkText("SPECIALS")).click();
            return new SearchPage(webDriver);
        }

    }

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

    public class SuppliersBlock{
        private WebDriver webDriver;
        private WebElement root;

        public SuppliersBlock(WebDriver webDriver, WebElement root){
            this.webDriver = webDriver;
            this.root = root;
        }

        public SearchPage clickSuppliers(){
            root.findElement(By.partialLinkText("SUPPLIERS")).click();
            return new SearchPage(webDriver);

        }
        public SearchPage clickFashionSupplier(){
            root.findElement(By.partialLinkText("Fashion Supplier")).click();
            return new SearchPage(webDriver);

        }
        public SearchPage selectFashionSupplier(){
            new Select(root.findElement(By.tagName("select"))).selectByIndex(1);
            return new SearchPage(webDriver);

        }

    }

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

    private WebDriver webDriver;
    private By root = By.id("left_column");
    public LeftColumn(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public BestSellersBlock topSellersBlock(){
        return new BestSellersBlock(webDriver);
    }

    public CategoriesBlock categoriesBlock(){
        return new CategoriesBlock(webDriver, webDriver.findElement(By.id("categories_block_left")));
    }

    public SpecialsBlock specialsBlock(){
        return new SpecialsBlock(webDriver, webDriver.findElement(By.id("special_block_right")));
    }
    public ManufacturersBlock manufacturersBlock(){
        return new ManufacturersBlock(webDriver, webDriver.findElement(By.id("suppliers_block_left")));
    }

    public InformationBlock informationBlock(){
        return new InformationBlock(webDriver, webDriver.findElement(By.id("informations_block_left_1")));
    }

    public  OurStoresBlock ourStoresBlock(){
        return new OurStoresBlock(webDriver, webDriver.findElement(By.id("stores_block_left")));
    }

    public  SuppliersBlock suppliersBlock(){
        return new SuppliersBlock(webDriver, webDriver.findElement(By.id("suppliers_block_left")));
    }

    public ViewProductsBlock viewProductsBlock(){
        return new ViewProductsBlock(webDriver, webDriver.findElement(By.id("viewed-products_block_left")));
    }

}
