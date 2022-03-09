package org.carefulchameleons.webdrivers.model;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
    @Override
    protected void createHeadlessDriver() {
        createDriver();
        System.out.println("!! Safari does not support running in headless mode!!");
        System.out.println("!! A standard Safari web driver has been created !!");
    }
    @Override
    protected void createPhoneDriver(MobilePhoneType type) {
        createDriver();
        Dimension iPhoneEleven = new Dimension(type.width,type.height);
        WebElement html = driver.findElement(By.tagName("html"));
        driver.manage().window().setSize(iPhoneEleven);
        html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
    }
}
