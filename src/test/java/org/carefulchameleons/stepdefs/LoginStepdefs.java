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
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepdefs {

    private static WebDriver webDriver;
    private IndexPage indexPage;
    private SignInPage signinPage;
    private MyAccountPage myAccountPage;
    //private static WebDriverManager manager;

    //@Before will only be staying in one StepDef
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        System.out.println("setup");
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        //manager = WebDriverFactory.getManager(WebDriverType.CHROME);
        //webDriver = manager.getDriver();
        webDriver.get("http://automationpractice.com/index.php");

        indexPage = new IndexPage(webDriver);
        //indexPage.clickSignInButton();
    }

    @When("I enter my registered email")
    public void iEnterMyRegisteredEmail() {
        signinPage = new SignInPage(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=my-account");
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
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=my-account", myAccountPage.getCurrentURL());
    }

    @And("I should see my account information")
    public void iShouldSeeMyAccountInformation() {
        //myAccountPage.isInformationPresent();
    }

    @When("I insert an unregistered email")
    public void iInsertAnUnregisteredEmail() {
        signinPage = new SignInPage(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=my-account");
        signinPage.enterLoginEmail("finalproject1@test.com");
    }

    @And("I insert a valid password")
    public void iInsertAValidPassword() {
        signinPage.enterLoginPassword("SpartaGlobal");
    }

    @Then("I will stay in the Login Page")
    public void iWillStayInTheLoginPage() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=my-account", signinPage.getCurrentURL());
    }

    @When("I insert a registered email")
    public void iInsertARegisteredEmail() {
        signinPage = new SignInPage(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=my-account");
        signinPage.enterLoginEmail("finalproject@test.com");
    }

    @And("I insert an invalid password")
    public void iInsertAnInvalidPassword() {
        signinPage.enterLoginPassword("SpartaGlobal1");
    }

    @After
    public static void tearDown() {
        if(webDriver != null) {
            //    manager.quitDriver();
            System.out.println("tearDown login");
        }
    }
}
