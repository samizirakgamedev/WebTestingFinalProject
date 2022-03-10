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

public class GooglePlusStepdefs {

    private static WebDriver webDriver;
    private IndexPage indexPage;
    private  static WebDriverManager driverManager;

    @Before("@google")
    public static void setUp() {
        driverManager = WebDriverFactory.getManager(WebDriverType.CHROME);
        webDriver = driverManager.getDriver();
        webDriver.get("http://automationpractice.com/index.php");
    }

    @After("@google")
    public static void tearDown() {
        if(webDriver != null) {
            driverManager.quitDriver();
            System.out.println("tearDown googlePlus");
        }
    }

    @Given("I am on the HomePage")
    public void iAmOnTheHomePage() {
    }

    @When("I click on Google plus icon")
    public void iClickOnGooglePlusIcon() {
        indexPage = new IndexPage(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        indexPage.getPageFooter().clickGoogleIcon();
    }

    @Then("I will go to the Google plus page")
    public void iWillGoToTheGooglePlusPage() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assertions.assertEquals("https://accounts.google.com/signin/v2/identifier?passive=1209600&osid=1&continue=https%3A%2F%2Fplus.google.com%2F111979135243110831526%2Fposts&followup=https%3A%2F%2Fplus.google.com%2F111979135243110831526%2Fposts&flowName=GlifWebSignIn&flowEntry=ServiceLogin", webDriver.switchTo().window(new ArrayList<>(webDriver.getWindowHandles()).get(1)).getCurrentUrl());

    }
}
