package org.carefulchameleons.pageelements;

import org.carefulchameleons.pageelements.leftcoloumelements.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftColumn {

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
    public ManufacturerBlock manufacturersBlock(){
        return new ManufacturerBlock(webDriver, webDriver.findElement(By.id("suppliers_block_left")));
    }

    public InformationBlock informationBlock(){
        return new InformationBlock(webDriver, webDriver.findElement(By.id("informations_block_left_1")));
    }

    public OurStoresBlock ourStoresBlock(){
        return new OurStoresBlock(webDriver, webDriver.findElement(By.id("stores_block_left")));
    }

    public SuppliersBlock suppliersBlock(){
        return new SuppliersBlock(webDriver, webDriver.findElement(By.id("suppliers_block_left")));
    }

    public ViewProductsBlock viewProductsBlock(){
        return new ViewProductsBlock(webDriver, webDriver.findElement(By.id("viewed-products_block_left")));
    }

}
