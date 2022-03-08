package org.carefulchameleons.pom.enums;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public enum ColourSelection {

    GREEN(15),
    YELLOW(16),
    BLUE(14),
    ORANGE(13),
    BEIGE(7),
    WHITE(8),
    PINK(24),
    BLACK(11);

    public int ID;

    ColourSelection(int id) {
        ID = id;
    }

    public void clickCheckbox(WebDriver webDriver){
        webDriver.findElement(new By.ById(String.format("layered_id_attribute_group_%d", ID))).click();

    }
}
