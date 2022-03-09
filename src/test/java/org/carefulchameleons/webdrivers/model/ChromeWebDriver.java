package org.carefulchameleons.webdrivers.model;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeWebDriver extends WebDriverManager{

    private ChromeDriverService chromeDriverService;

    @Override
    protected void startService(String filepath) {
        if (null == chromeDriverService) {
            try {
                chromeDriverService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(filepath))
                        .usingAnyFreePort()
                        .build();
                chromeDriverService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void startService() {
        startService("src/test/resources/drivers/chromedriver.exe");
    }
    @Override
    protected void stopService() {
        if (null != chromeDriverService && chromeDriverService.isRunning())
            chromeDriverService.stop();
    }
    @Override
    protected void createDriver() {
        driver = new ChromeDriver(chromeDriverService);
    }
    @Override
    protected void createHeadlessDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(chromeDriverService, options);
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
