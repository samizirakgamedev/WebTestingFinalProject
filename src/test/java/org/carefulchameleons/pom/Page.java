package org.carefulchameleons.pom;

import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected WebDriver webDriver;
    private final PageHeader PAGE_HEADER;
    private final PageFooter PAGE_FOOTER;

    private final String EXPECTED_URL;

    public Page(WebDriver webDriver, String expected_url) {
        this.webDriver = webDriver;
        EXPECTED_URL = expected_url;
        PAGE_HEADER = new PageHeader(webDriver);
        PAGE_FOOTER = new PageFooter(webDriver);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public PageHeader getPageHeader(){
        return PAGE_HEADER;
    }

    public PageFooter getPageFooter() {
        return PAGE_FOOTER;
    }

    public String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }

    public boolean isUrlCorrect() {
        return getCurrentURL().equals(EXPECTED_URL);
    }

}
