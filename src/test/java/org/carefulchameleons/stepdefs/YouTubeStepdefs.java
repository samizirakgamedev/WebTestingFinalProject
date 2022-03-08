package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class YouTubeStepdefs {

    private static WebDriver webDriver;
    //private Homepage homePage;
    //private LoginPage loginPage;
    //private MyAccountPage myAccountPage;
    //private static WebDriverManager manager;

    @Given("I am on the Homepage")
    public void iAmOnTheHomepage() {
        //manager = WebDriverFactory.getManager(WebDriverType.CHROME);
        //webDriver = manager.getDriver();
        webDriver.get("http://automationpractice.com/index.php");

    }

    @When("I click on YouTube icon")
    public void iClickOnYouTubeIcon() {
        //homePage = new homePage(webDriver);
        //homePage.clickYouTubeButton();
    }

    @Then("I will go to the YouTube page")
    public void iWillGoToTheYouTubePage() {
        //Assertions.assertEquals("https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA", webDriver.switchTo().window(new ArrayList<>(webDriver.getWindowHandles()).get(1)).getCurrentUrl());
    }

    @After
    public static void tearDown() {
        if(webDriver != null) {
            //    manager.quitDriver();
            System.out.println("tearDown youTube");
        }
    }
}
