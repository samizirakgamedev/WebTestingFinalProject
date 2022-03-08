package org.carefulchameleons.pom.enums;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public enum SizeSelection {

    S("layered_id_attribute_group_1"),
    M("layered_id_attribute_group_2"),
    L("layered_id_attribute_group_3");

    public String ID;

    SizeSelection(String id) {
        ID = id;
    }

    public void clickCheckbox(WebDriver webDriver){
        webDriver.findElement(new By.ById(S.ID)).click();
        webDriver.findElement(new By.ById(M.ID)).click();
        webDriver.findElement(new By.ById(L.ID)).click();

    }
}
