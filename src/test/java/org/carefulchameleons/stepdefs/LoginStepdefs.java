package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepdefs {

    private static WebDriver webDriver;
    //private Homepage homePage;
    //private LoginPage loginPage;
    //private MyAccountPage myAccountPage;
    //private static WebDriverManager manager;

    //@Before will only be staying in one StepDef
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.out.println("setup");
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        //manager = WebDriverFactory.getManager(WebDriverType.CHROME);
        //webDriver = manager.getDriver();
        webDriver.get("https://www.saucedemo.com");

        //homePage = new homePage(webDriver);
        //homePage.clickSignInButton();
    }

    @When("I enter my registered email")
    public void iEnterMyRegisteredEmail() {
        //loginPage = new LoginPage(webDriver);
        //loginPage.enterUsername("finalproject@test.com");
    }

    @And("I enter my correct password")
    public void iEnterMyCorrectPassword() {
        //loginPage.enterPassword("SpartaGlobal");
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        //loginPage.clickLogInButton();
    }

    @Then("I will go to the My Account page")
    public void iWillGoToTheMyAccountPage() {
        //myAccountPage = new MyAccountPage(webdriver);
        //Assertions.assertEquals("", myAccountPage.getCurrentURL());
    }

    @And("I should see my account information")
    public void iShouldSeeMyAccountInformation() {
        //myAccountPage.isInformationPresent();
    }

    @When("I insert an unregistered email")
    public void iInsertAnUnregisteredEmail() {
        //loginPage = new LoginPage(webDriver);
        //loginPage.enterUsername("finalproject1@test.com");
    }

    @And("I insert a valid password")
    public void iInsertAValidPassword() {
        //loginPage.enterPassword("SpartaGlobal");
    }

    @Then("I will stay in the Login Page")
    public void iWillStayInTheLoginPage() {
        //Assertions.assertEquals("", loginPage.getCurrentURL());
    }

    @When("I insert a registered email")
    public void iInsertARegisteredEmail() {
        //loginPage = new LoginPage(webDriver);
        //loginPage.enterUsername("finalproject@test.com");
    }

    @And("I insert an invalid password")
    public void iInsertAnInvalidPassword() {
        //loginPage.enterPassword("SpartaGlobal1");
    }

    @After
    public static void tearDown() {
        if(webDriver != null) {
            //    manager.quitDriver();
            System.out.println("tearDown li");
        }
    }
}
