package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class HomeStepdefs {

    private static WebDriver webDriver;
    //private Homepage homePage;
    //private LoginPage loginPage;
    //private MyAccountPage myAccountPage;
    //private static WebDriverManager manager;

    //@Before will only be staying in one StepDef
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        System.out.println("setup");
    }













    @After
    public static void tearDown() {
        if(webDriver != null) {
            //    manager.quitDriver();
            System.out.println("tearDown login");
        }
    }

}
