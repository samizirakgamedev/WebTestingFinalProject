package org.carefulchameleons.pageelements.leftcoloumelements;

import org.carefulchameleons.pom.SearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ManufacturerBlock{
    WebElement root;
    WebDriver webDriver;
    By fashionManufacturerButton = By.partialLinkText("Fashion Manufacturer");
    By manufacturerSelection = By.tagName("select");
    public ManufacturerBlock( WebDriver webDriver, WebElement root) {
        this.root = root;
        this.webDriver = webDriver;
    }

    public SearchPage clickFashionManufacturer(){
        webDriver.findElement(fashionManufacturerButton).click();
        return new SearchPage(webDriver, "");
    }

    public SearchPage selectAFashionManufacturer(){
        new Select(root.findElement(manufacturerSelection)).selectByIndex(1);
        return new SearchPage(webDriver, "");
    }
}
