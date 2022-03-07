package org.carefulchameleons.webdrivers;

import org.carefulchameleons.webdrivers.model.*;

public class WebDriverFactory {
    public static WebDriverManager getManager(WebDriverType type){
        WebDriverManager driverManager = null;

        switch (type){
            case CHROME -> driverManager = new ChromeWebDriver();
            case FIREFOX -> driverManager = new FirefoxWebDriver();
            case OPERA -> driverManager = new OperaWebDriver();
        }
        return driverManager;
    }
}
