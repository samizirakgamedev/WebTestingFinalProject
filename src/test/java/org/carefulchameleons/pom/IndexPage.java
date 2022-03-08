package org.carefulchameleons.pom;

import org.openqa.selenium.WebDriver;

public class IndexPage extends Page {


    public IndexPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php");
    }

}
