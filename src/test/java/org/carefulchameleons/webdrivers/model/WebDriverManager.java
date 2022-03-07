package org.carefulchameleons.webdrivers.model;

import org.openqa.selenium.WebDriver;

public abstract class WebDriverManager {
    protected WebDriver driver;
    protected abstract void startService(String filepath);
    protected abstract void startService();
    protected abstract void stopService();
    protected abstract void createDriver();

    public void quitDriver() {
        if (null != driver) {
            stopService();
            driver.quit();
            driver = null;
        }
    }
    public WebDriver getDriver() {
        if (null == driver) {
            startService();
            createDriver();
        }
        return driver;
    }
}
