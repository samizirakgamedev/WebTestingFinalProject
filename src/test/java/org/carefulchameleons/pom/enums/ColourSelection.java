package org.carefulchameleons.pom.enums;

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
        webDriver.findElement(new By.ById(ID)).click();

    }
}
