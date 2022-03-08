package org.carefulchameleons.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public enum ColourSelection {

//    GREEN("green"),
//    YELLOW("yellow"),
//    BLUE("blue"),
//    ORANGE("orange"),
//    BEIGE("beige"),
//    WHITE("white"),
//    PINK("pink"),
//    BLACK("black");
//
//    public String NAME;

    GREEN("layered_id_attribute_group_15"),
    YELLOW("layered_id_attribute_group_16"),
    BLUE("layered_id_attribute_group_14"),
    ORANGE("layered_id_attribute_group_13"),
    BEIGE("layered_id_attribute_group_7"),
    WHITE("layered_id_attribute_group_8"),
    PINK("layered_id_attribute_group_24"),
    BLACK("layered_id_attribute_group_11");

    public String ID;

    ColourSelection(String id) {
        ID = id;
    }

    public void clickCheckbox(WebDriver webDriver){
        webDriver.findElement(new By.ById(GREEN.ID)).click();
        webDriver.findElement(new By.ById(YELLOW.ID)).click();
        webDriver.findElement(new By.ById(BLUE.ID)).click();
        webDriver.findElement(new By.ById(ORANGE.ID)).click();
        webDriver.findElement(new By.ById(BEIGE.ID)).click();
        webDriver.findElement(new By.ById(WHITE.ID)).click();
        webDriver.findElement(new By.ById(PINK.ID)).click();
        webDriver.findElement(new By.ById(BLACK.ID)).click();
    }
}
