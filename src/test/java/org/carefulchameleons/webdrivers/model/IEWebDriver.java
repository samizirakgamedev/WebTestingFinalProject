package org.carefulchameleons.webdrivers.model;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;


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
    protected void createPhoneDriver(MobilePhoneType type) {
        createDriver();
        System.out.println("!! IEWebDriver does not currently support mobile phone driver creation !!");
        System.out.println("!!------------- A standard IE web driver has been created -------------!!");
    }
}
