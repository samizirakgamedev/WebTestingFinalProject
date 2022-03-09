package org.carefulchameleons.webdrivers.model;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaOptions;

import java.io.File;

public class OperaWebDriver extends WebDriverManager{

    private OperaDriverService operaDriverService;

    @Override
    protected void startService(String filepath) {
        if (null == operaDriverService) {
            try {
                operaDriverService = new OperaDriverService.Builder()
                        .usingDriverExecutable(new File(filepath))
                        .usingAnyFreePort()
                        .build();
                operaDriverService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void startService() {
        startService("src/test/resources/drivers/operadriver.exe");
    }
    @Override
    protected void stopService() {
        if (null != operaDriverService && operaDriverService.isRunning())
            operaDriverService.stop();
    }
    @Override
    protected void createDriver() {
        driver = new OperaDriver(operaDriverService);
    }
    @Override
    protected void createHeadlessDriver() {
        OperaOptions options = new OperaOptions();
        options.addArguments("headless");
        driver = new OperaDriver(operaDriverService,options);
    }
    @Override
    protected void createDriverWithIPhoneElevenResolution() {
        createDriver();

        Dimension iPhoneEleven = new Dimension(414,896);
        WebElement html = driver.findElement(By.tagName("html"));
        driver.manage().window().setSize(iPhoneEleven);
        html.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
    }
}
