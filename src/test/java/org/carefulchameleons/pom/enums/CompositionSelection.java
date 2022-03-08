package org.carefulchameleons.pom.enums;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public enum CompositionSelection {

    COTTON("layered_id_feature_5"),
    POLYESTER("layered_id_feature_1"),
    VISCOSE("layered_id_feature_3");

    public String ID;

    CompositionSelection(String id) {
        ID = id;
    }

    public void clickCheckbox(WebDriver webDriver){
        webDriver.findElement(new By.ById(ID)).click();

    }
}
