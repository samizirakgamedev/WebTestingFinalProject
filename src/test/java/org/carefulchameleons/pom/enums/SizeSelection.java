package org.carefulchameleons.pom.enums;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public enum SizeSelection {

    S(1),
    M(2),
    L(3);

    public int ID;

    SizeSelection(int id) {
        ID = id;
    }

    public void clickCheckbox(WebDriver webDriver){
        webDriver.findElement(new By.ById(String.format("layered_id_attribute_group_%d", ID))).click();
    }
}
