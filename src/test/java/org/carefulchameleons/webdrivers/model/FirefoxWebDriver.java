package org.carefulchameleons.webdrivers.model;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;

public class FirefoxWebDriver extends WebDriverManager{

    private GeckoDriverService firefoxDriverService;

    @Override
    protected void startService(String filepath) {
        if (null == firefoxDriverService) {
            try {
                firefoxDriverService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File(filepath))
                        .usingAnyFreePort()
                        .build();
                firefoxDriverService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void startService() {
        startService("src/test/resources/drivers/geckodriver.exe");
    }

    @Override
    protected void stopService() {
        if (null != firefoxDriverService && firefoxDriverService.isRunning())
            firefoxDriverService.stop();
    }

    @Override
    protected void createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
        options.setHeadless(true);
        driver = new FirefoxDriver(firefoxDriverService,options);
    }
}
