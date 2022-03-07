package org.carefulchameleons.webdrivers.model;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeWebDriver extends WebDriverManager{

    private ChromeDriverService chromeDriverService;

    @Override
    protected void startService() {
        if (null == chromeDriverService) {
            try {
                chromeDriverService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File("src/test/resources/chromedriver.exe"))
                        .usingAnyFreePort()
                        .build();
                chromeDriverService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void stopService() {
        if (null != chromeDriverService && chromeDriverService.isRunning())
            chromeDriverService.stop();
    }

    @Override
    protected void createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(chromeDriverService, options);
    }
}
