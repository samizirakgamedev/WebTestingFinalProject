package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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


    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
    }

    @When("I click on the company logo")
    public void iClickOnTheCompanyLogo() {
    }

    @Then("I go to the home page")
    public void iGoToTheHomePage() {
    }

    @When("I click on the women's category")
    public void iClickOnTheWomenSCategory() {
    }

    @Then("I am sent to the women's department")
    public void iAmSentToTheWomenSDepartment() {
    }

    @When("I click on the dresses category")
    public void iClickOnTheDressesCategory() {
    }

    @And("I am sent to the dress section")
    public void iAmSentToTheDressSection() {
    }

    @When("I click on the Best Sellers tab")
    public void iClickOnTheBestSellersTab() {
    }

    @Then("I can see the best selling items")
    public void iCanSeeTheBestSellingItems() {
    }

    @When("I click on the search button")
    public void iClickOnTheSearchButton() {
    }

    @Then("I am taken to my search results")
    public void iAmTakenToMySearchResults() {
    }

    @When("I click on the {string} panel")
    public void iClickOnThePanel(String arg0) {
    }

    @Then("I am taken to the {string} page")
    public void iAmTakenToThePage(String arg0) {
    }

    @When("I click on the button located in the Call Us section")
    public void iClickOnTheButtonLocatedInTheCallUsSection() {
    }

    @Then("I am taken to the organization's website")
    public void iAmTakenToTheOrganizationSWebsite() {
    }

    @When("I click on the {string} link")
    public void iClickOnTheLink(String arg0) {
    }

    @When("I click on the contact us tab")
    public void iClickOnTheContactUsTab() {
    }

    @Then("I am sent to the customer service page")
    public void iAmSentToTheCustomerServicePage() {
    }










    @After
    public static void tearDown() {
        if(webDriver != null) {
            //    manager.quitDriver();
            System.out.println("tearDown login");
        }
    }

}
