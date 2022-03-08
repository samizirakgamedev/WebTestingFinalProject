package org.carefulchameleons.pom.enums;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public enum CategorySelection {

    TOPS("layered_category_4"),
    DRESSES("layered_category_8");

    public String ID;

    CategorySelection(String id) {
        ID = id;
    }

    public void clickCheckbox(WebDriver webDriver){
        webDriver.findElement(new By.ById(ID)).click();


    }
}
