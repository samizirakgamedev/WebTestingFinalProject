package org.carefulchameleons.webdrivers;

import org.carefulchameleons.webdrivers.model.MobilePhoneType;
import org.openqa.selenium.WebDriver;
import org.carefulchameleons.webdrivers.model.WebDriverManager;
import org.carefulchameleons.webdrivers.model.WebDriverType;

public class WebDriverTest {

    public static void testDriver(WebDriverType webDriverType){
        WebDriverManager driverManager;
        WebDriver driver;
        String desiredPage = "https://www.google.com/";

        driverManager = WebDriverFactory.getManager(webDriverType);
        driver = driverManager.getDriver();
        driver.get(desiredPage);

        if (driver.getCurrentUrl().equals(desiredPage))
            System.out.println(">>> " + webDriverType + " Driver Functioning <<<");
        driverManager.quitDriver();
    }

    public static void testHeadlessDriver(WebDriverType webDriverType){
        WebDriverManager driverManager;
        WebDriver driver;
        String desiredPage = "https://www.google.com/";

        driverManager = WebDriverFactory.getManager(webDriverType);
        driver = driverManager.getHeadlessDriver();
        driver.get(desiredPage);

        if (driver.getCurrentUrl().equals(desiredPage))
            System.out.println(">>> " + webDriverType + " Driver Functioning <<<");
        driverManager.quitDriver();
    }

    public static void testDriverMobile(WebDriverType webDriverType, MobilePhoneType mobilePhoneType){
        WebDriverManager driverManager;
        WebDriver driver;
        String desiredPage = "https://www.google.com/";

        driverManager = WebDriverFactory.getManager(webDriverType);
        driver = driverManager.getMobilePhoneDriver(mobilePhoneType);
        driver.get(desiredPage);

        if (driver.getCurrentUrl().equals(desiredPage))
            System.out.println(">>> " + webDriverType + " Driver Functioning <<<");
        driverManager.quitDriver();
    }

    public static void main(String[] args) {
        testDriver(WebDriverType.CHROME);
        testHeadlessDriver(WebDriverType.OPERA);
        testDriverMobile(WebDriverType.FIREFOX,MobilePhoneType.IPHONE11);
    }
}
