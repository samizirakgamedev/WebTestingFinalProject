package org.carefulchameleons.webdrivers.model;

import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;

public class SafariWebDriver extends WebDriverManager{

    private SafariDriverService safariDriverService;

    @Override
    protected void startService(String filepath) {
        startService();
    }

    @Override
    protected void startService() {
        if (null == safariDriverService) {
            try {
                safariDriverService = new SafariDriverService.Builder()
                        .usingAnyFreePort()
                        .build();
                safariDriverService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopService() {
        if (null != safariDriverService && safariDriverService.isRunning())
            safariDriverService.stop();
    }

    @Override
    protected void createDriver() {
        driver = new SafariDriver();
    }
}
