package org.carefulchameleons.pom;

import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected WebDriver webDriver;
    private final PageHeader pageHeader;
    private final PageFooter pageFooter;

    private final String EXPECTED_URL;

    public Page(WebDriver webDriver, String expected_url) {
        this.webDriver = webDriver;
        EXPECTED_URL = expected_url;
        pageHeader = new PageHeader(webDriver);
        pageFooter = new PageFooter(webDriver);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public PageHeader getPageHeader(){
        return pageHeader;
    }

    public PageFooter pageFooter(){
        return pageFooter;
    }

    public String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }

    public boolean isUrlCorrect() {
        return getCurrentURL().equals(EXPECTED_URL);
    }
}
