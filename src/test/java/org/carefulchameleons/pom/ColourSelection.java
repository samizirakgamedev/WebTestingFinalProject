package org.carefulchameleons.pom;

import org.openqa.selenium.By;

public enum ColourSelection {

    GREEN("green"),
    YELLOW("yellow"),
    BLUE("blue"),
    ORANGE("orange"),
    BEIGE("beige"),
    WHITE("white"),
    PINK("pink"),
    BLACK("black");
    
    public String NAME;

    ColourSelection(String name) {
        NAME = name;
    }
}
