package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.myaccounts.MyAccountPage;
import org.carefulchameleons.pom.myaccounts.SignInPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class GooglePlusStepdefs {

    private static WebDriver webDriver;
    private IndexPage indexPage;
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;
    //private static WebDriverManager manager;

    @Given("I am on the HomePage")
    public void iAmOnTheHomePage() {
        //manager = WebDriverFactory.getManager(WebDriverType.CHROME);
        //webDriver = manager.getDriver();
        webDriver.get("http://automationpractice.com/index.php");

    }

    @When("I click on Google plus icon")
    public void iClickOnGooglePlusIcon() {
        indexPage = new IndexPage(webDriver);
        //indexPage.clickGooglePlusButton();
    }

    @Then("I will go to the Google plus page")
    public void iWillGoToTheGooglePlusPage() {
        Assertions.assertEquals("https://plus.google.com/111979135243110831526/posts", webDriver.switchTo().window(new ArrayList<>(webDriver.getWindowHandles()).get(1)).getCurrentUrl());

    }
    @After
    public static void tearDown() {
        if(webDriver != null) {
            //    manager.quitDriver();
            System.out.println("tearDown googlePlus");
        }
    }
}
