package org.carefulchameleons.pom.enums;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public enum StyleSelection {

    CASUAL("layered_id_feature_11"),
    DRESSY("layered_id_feature_16"),
    GIRLY("layered_id_feature_13");

    public String ID;

    StyleSelection(String id) {
        ID = id;
    }

    public void clickCheckbox(WebDriver webDriver){
        webDriver.findElement(new By.ById(ID)).click();
    }
}
