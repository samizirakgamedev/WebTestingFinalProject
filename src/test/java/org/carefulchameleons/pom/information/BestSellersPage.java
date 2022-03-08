package org.carefulchameleons.pom.information;

import org.carefulchameleons.pom.Page;
import org.openqa.selenium.WebDriver;

public class BestSellersPage extends Page{

    public BestSellersPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?controller=best-sales");
    }

    public String getCurrentURL() {
        return getWebDriver().getCurrentUrl();
    }
}
