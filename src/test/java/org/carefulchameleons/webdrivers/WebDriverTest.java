package org.carefulchameleons.webdrivers;

import org.openqa.selenium.WebDriver;
import org.carefulchameleons.webdrivers.model.WebDriverManager;
import org.carefulchameleons.webdrivers.model.WebDriverType;

public class WebDriverTest {

    public static void chromeTest(){
        WebDriverManager driverManager;
        WebDriver driver;
        String desiredPage = "https://www.google.com/";

        driverManager = WebDriverFactory.getManager(WebDriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get(desiredPage);

        if (driver.getCurrentUrl().equals(desiredPage))
            System.out.println(">>> Chrome Driver Functioning <<<");
        driverManager.quitDriver();
    }

    public static void firefoxTest(){
        WebDriverManager driverManager;
        WebDriver driver;
        String desiredPage = "https://www.google.com/";

        driverManager = WebDriverFactory.getManager(WebDriverType.FIREFOX);
        driver = driverManager.getDriver();
        driver.get(desiredPage);

        if (driver.getCurrentUrl().equals(desiredPage))
            System.out.println(">>> Firefox Driver Functioning <<<");
        driverManager.quitDriver();
    }

    public static void ieTest(){
        WebDriverManager driverManager;
        WebDriver driver;
        String desiredPage = "https://www.google.com/";

        driverManager = WebDriverFactory.getManager(WebDriverType.IE);
        driver = driverManager.getHeadlessDriver();
        driver.get(desiredPage);

        if (driver.getCurrentUrl().equals(desiredPage))
            System.out.println(">>> IE Driver Functioning <<<");
        driverManager.quitDriver();
    }

    public static void operaTest(){
        WebDriverManager driverManager;
        WebDriver driver;
        String desiredPage = "https://www.google.com/";

        driverManager = WebDriverFactory.getManager(WebDriverType.OPERA);
        driver = driverManager.getDriver();
        driver.get(desiredPage);

        if (driver.getCurrentUrl().equals(desiredPage))
            System.out.println(">>> Opera Driver Functioning <<<");
        driverManager.quitDriver();
    }

    public static void safariTest(){
        WebDriverManager driverManager;
        WebDriver driver;
        String desiredPage = "https://www.google.com/";

        driverManager = WebDriverFactory.getManager(WebDriverType.SAFARI);
        driver = driverManager.getDriver();
        driver.get(desiredPage);

        if (driver.getCurrentUrl().equals(desiredPage))
            System.out.println(">>> Safari Driver Functioning <<<");
        driverManager.quitDriver();
    }

    public static void main(String[] args) {
//        operaTest();
//        chromeTest();
//        firefoxTest();
//        ieTest();
//        safariTest();
    }
}
