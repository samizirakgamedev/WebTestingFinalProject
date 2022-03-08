package org.carefulchameleons.pom.enums;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public enum PropertiesSelection {

    COLORFUL_DRESS(""),
    MIDI_DRESS(""),
    SHORT_SLEEVE(""),
    MAXI_DRESS(""),
    SHORT_DRESS("");

    public String ID;

    PropertiesSelection(String id){
        ID = id;
    }

    public void clickCheckbox(WebDriver webDriver) {
        webDriver.findElement(new By.ById(COLORFUL_DRESS.ID)).click();
        webDriver.findElement(new By.ById(MIDI_DRESS.ID)).click();
        webDriver.findElement(new By.ById(SHORT_SLEEVE.ID)).click();
        webDriver.findElement(new By.ById(MAXI_DRESS.ID)).click();
        webDriver.findElement(new By.ById(SHORT_DRESS.ID)).click();
    }
}
