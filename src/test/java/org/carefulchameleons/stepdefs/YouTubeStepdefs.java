package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.PageFooter;
import org.carefulchameleons.pom.myaccounts.MyAccountPage;
import org.carefulchameleons.pom.myaccounts.SignInPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;

public class YouTubeStepdefs {

    private static WebDriver webDriver;
    private IndexPage indexPage;
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;
    private PageFooter pageFooter;
    //private static WebDriverManager manager;

    @Given("I am on the Homepage")
    public void iAmOnTheHomepage() {
        //manager = WebDriverFactory.getManager(WebDriverType.CHROME);
        //webDriver = manager.getDriver();
        webDriver = new ChromeDriver();
        webDriver.get("http://automationpractice.com/index.php");

    }

    @When("I click on YouTube icon")
    public void iClickOnYouTubeIcon() {
        indexPage = new IndexPage(webDriver);
        pageFooter = new PageFooter(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        indexPage.getPageFooter().clickYoutubeIcon();

    }

    @Then("I will go to the YouTube page")
    public void iWillGoToTheYouTubePage() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Assertions.assertEquals("https://www.youtube.com/channel/UCHl59sI3SRjQ-qPcTrgt0tA", webDriver.switchTo().window(new ArrayList<>(webDriver.getWindowHandles()).get(1)).getCurrentUrl());
    }

    @After
    public static void tearDown() {
        if(webDriver != null) {
            webDriver.quit();
            System.out.println("tearDown youTube");
        }
    }
}
