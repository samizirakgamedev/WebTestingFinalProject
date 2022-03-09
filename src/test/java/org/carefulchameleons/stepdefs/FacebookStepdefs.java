package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class FacebookStepdefs {

    private static WebDriver webDriver;
    //private Homepage homePage;
    //private LoginPage loginPage;
    //private MyAccountPage myAccountPage;
    //private static WebDriverManager manager;

//    @Given("I am on the Home page")
//    public void iAmOnTheHomePage() {
//        //manager = WebDriverFactory.getManager(WebDriverType.CHROME);
//        //webDriver = manager.getDriver();
//        webDriver.get("http://automationpractice.com/index.php");
//
//    }

    @When("I click on FACEBOOK icon")
    public void iClickOnFACEBOOKIcon() {
        //homePage = new homePage(webDriver);
        //homePage.clickFacebookButton();

    }

    @Then("I will go to the FACEBOOK page")
    public void iWillGoToTheFACEBOOKPage() {
        //Assertions.assertEquals("https://www.facebook.com/groups/525066904174158/", webDriver.switchTo().window(new ArrayList<>(webDriver.getWindowHandles()).get(1)).getCurrentUrl());
    }

    @After
    public static void tearDown() {
        if(webDriver != null) {
            //    manager.quitDriver();
            System.out.println("tearDown facebook");
        }
    }
}
