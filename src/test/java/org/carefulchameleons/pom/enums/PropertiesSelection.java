package org.carefulchameleons.pom.enums;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public enum PropertiesSelection {

    COLORFUL_DRESS("layered_id_feature_18"),
    MIDI_DRESS("layered_id_feature_20"),
    SHORT_SLEEVE("layered_id_feature_17"),
    MAXI_DRESS("layered_id_feature_21"),
    SHORT_DRESS("layered_id_feature_19");

    public String ID;

    PropertiesSelection(String id){
        ID = id;
    }

    public void clickCheckbox(WebDriver webDriver) {
        webDriver.findElement(new By.ById(ID)).click();
    }
}
