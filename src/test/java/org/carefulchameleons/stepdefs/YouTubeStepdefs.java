package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.PageFooter;
import org.carefulchameleons.pom.myaccounts.MyAccountPage;
import org.carefulchameleons.pom.myaccounts.SignInPage;
import org.carefulchameleons.webdrivers.WebDriverFactory;
import org.carefulchameleons.webdrivers.model.WebDriverManager;
import org.carefulchameleons.webdrivers.model.WebDriverType;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.ArrayList;

public class YouTubeStepdefs {

    private static WebDriver webDriver;
    private IndexPage indexPage;
    private  static WebDriverManager driverManager;

    @Before("@youtube")
    public void setUp() {
        driverManager = WebDriverFactory.getManager(WebDriverType.CHROME);
        webDriver = driverManager.getDriver();
        webDriver.get("http://automationpractice.com/index.php");
    }

    @After("@youtube")
    public static void tearDown() {
        if(webDriver != null) {
            driverManager.quitDriver();
            System.out.println("tearDown youTube");
        }
    }

    @Given("I am on the Homepage")
    public void iAmOnTheHomepage() {
    }

    @When("I click on YouTube icon")
    public void iClickOnYouTubeIcon() {
        indexPage = new IndexPage(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        indexPage.getPageFooter().clickYoutubeIcon();
    }

    @Then("I will go to the YouTube page")
    public void iWillGoToTheYouTubePage() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Assertions.assertEquals("https://consent.youtube.com/m?continue=https%3A%2F%2Fwww.youtube.com%2Fchannel%2FUCHl59sI3SRjQ-qPcTrgt0tA%3Fcbrd%3D1&gl=GB&m=0&pc=yt&uxe=23983171&hl=en-GB&src=1", webDriver.switchTo().window(new ArrayList<>(webDriver.getWindowHandles()).get(1)).getCurrentUrl());
    }
}
