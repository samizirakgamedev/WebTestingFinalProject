package org.carefulchameleons.webdrivers.model;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class IEWebDriver extends WebDriverManager {

    private InternetExplorerDriverService internetExplorerDriverService;

    @Override
    protected void startService(String filepath) {
        if (null == internetExplorerDriverService) {
            try {
                System.setProperty("webdriver.ie.driver", filepath);
                internetExplorerDriverService = new InternetExplorerDriverService.Builder().
                        usingDriverExecutable(new File(filepath))
                        .usingAnyFreePort()
                        .build();
                internetExplorerDriverService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void startService() {
        startService("src/test/resources/drivers/IEDriverServer.exe");
    }
    @Override
    protected void stopService() {
        if (null != internetExplorerDriverService && internetExplorerDriverService.isRunning())
            internetExplorerDriverService.stop();
    }
    @Override
    protected void createDriver() {
        driver = new InternetExplorerDriver(internetExplorerDriverService);
    }
    @Override
    protected void createHeadlessDriver() {
        createDriver();
        System.out.println("!! IE does not support running in headless mode!!");
        System.out.println("!!- A standard IE web driver has been created -!!");
    }
    @Override
    protected void createDriverWithIPhoneElevenResolution() {
//        createDriver();
//
//        Dimension iPhoneEleven = new Dimension(414,896);
//        driver.manage().window().setSize(iPhoneEleven);
//        WebElement html = driver.findElement(By.id("html"));
//        html.sendKeys("IE mode",Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
    }
}
