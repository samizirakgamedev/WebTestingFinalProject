package org.carefulchameleons.pom.information;

import org.carefulchameleons.pom.Page;
import org.openqa.selenium.WebDriver;

public class TermsAndConditionsPage extends Page {

    public TermsAndConditionsPage(WebDriver webDriver) {
        super(webDriver, "http://automationpractice.com/index.php?id_cms=3&controller=cms");
    }

    public String getCurrentURL() {
        return getWebDriver().getCurrentUrl();
    }
}
