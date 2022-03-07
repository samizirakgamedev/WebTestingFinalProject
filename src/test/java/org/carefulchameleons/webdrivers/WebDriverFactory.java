package org.carefulchameleons.webdrivers;

import org.carefulchameleons.webdrivers.model.ChromeWebDriver;
import org.carefulchameleons.webdrivers.model.FirefoxWebDriver;
import org.carefulchameleons.webdrivers.model.WebDriverManager;
import org.carefulchameleons.webdrivers.model.WebDriverType;

public class WebDriverFactory {
    public static WebDriverManager getManager(WebDriverType type){
        WebDriverManager driverManager = null;

        switch (type){
            case CHROME -> driverManager = new ChromeWebDriver();
            case FIREFOX -> driverManager = new FirefoxWebDriver();
        }
        return driverManager;
    }
}
