package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.myaccounts.MyAccountPage;
import org.carefulchameleons.pom.myaccounts.SignInPage;
import org.carefulchameleons.webdrivers.WebDriverFactory;
import org.carefulchameleons.webdrivers.model.WebDriverManager;
import org.carefulchameleons.webdrivers.model.WebDriverType;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class LoginStepdefs {

    private static WebDriver webDriver;
    private  static WebDriverManager driverManager;
    private IndexPage indexPage;
    private SignInPage signinPage;
    private MyAccountPage myAccountPage;

    @Before("@google")
    public static void setUp() {
        driverManager = WebDriverFactory.getManager(WebDriverType.CHROME);
        webDriver = driverManager.getDriver();
        webDriver.get("http://automationpractice.com/index.php");
    }

    @After("@login")
    public static void tearDown() {
        if(webDriver != null) {
            driverManager.quitDriver();
            System.out.println("tearDown login");
        }
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        indexPage = new IndexPage(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        indexPage.getPageHeader().clickSignInButton();
    }

    @When("I enter my registered email")
    public void iEnterMyRegisteredEmail() {
        //??expectedUrl??
        signinPage = new SignInPage(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=my-account");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signinPage.enterLoginEmail("finalproject@test.com");
    }

    @And("I enter my correct password")
    public void iEnterMyCorrectPassword() {
        signinPage.enterLoginPassword("SpartaGlobal");
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        signinPage.clickLoginButton();
    }

    @Then("I will go to the My Account page")
    public void iWillGoToTheMyAccountPage() {
        myAccountPage = new MyAccountPage(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=my-account", myAccountPage.getCurrentURL());
    }

    @And("I should see my account information")
    public void iShouldSeeMyAccountInformation() {
        //myAccountPage.isInformationPresent();
    }

    @When("I insert an unregistered email")
    public void iInsertAnUnregisteredEmail() {
        signinPage = new SignInPage(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=my-account");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signinPage.enterLoginEmail("finalproject1@test.com");
    }

    @And("I insert a valid password")
    public void iInsertAValidPassword() {
        signinPage.enterLoginPassword("SpartaGlobal");
    }

    @Then("I will stay in the Login Page")
    public void iWillStayInTheLoginPage() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication", signinPage.getCurrentURL());
    }

    @When("I insert a registered email")
    public void iInsertARegisteredEmail() {
        signinPage = new SignInPage(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=my-account");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signinPage.enterLoginEmail("finalproject@test.com");
    }

    @And("I insert an invalid password")
    public void iInsertAnInvalidPassword() {
        signinPage.enterLoginPassword("SpartaGlobal1");
    }

}
