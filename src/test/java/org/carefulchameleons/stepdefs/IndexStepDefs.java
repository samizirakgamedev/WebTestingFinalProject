package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.PageHeader;
import org.carefulchameleons.pom.myaccounts.RegistrationPage;
import org.carefulchameleons.webdrivers.WebDriverFactory;
import org.carefulchameleons.webdrivers.model.WebDriverManager;
import org.carefulchameleons.webdrivers.model.WebDriverType;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.function.BooleanSupplier;

public class IndexStepDefs {
    private  static WebDriverManager driverManager;
    private static WebDriver webDriver;
    private IndexPage indexPage;

    @Before("@index")
    public void setup() {
        driverManager = WebDriverFactory.getManager(WebDriverType.CHROME);
        webDriver = driverManager.getDriver();
        indexPage = new IndexPage(webDriver);
        webDriver.navigate().to("http://automationpractice.com/");
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        Assertions.assertEquals("http://automationpractice.com/index.php", indexPage.getCurrentURL());
    }

    @Given("I am on the website")
    public void iAmOnTheWebsite() {
        webDriver.get("http://automationpractice.com/index.php");
        Assertions.assertEquals("http://automationpractice.com/index.php", indexPage.getCurrentURL());

    }

    @When("I click on the company logo")
    public void iClickOnTheCompanyLogo() {
        indexPage.clickOnYourLogo();
    }

    @Then("I go to the home page")
    public void iGoToTheHomePage() {
        Assertions.assertEquals("http://automationpractice.com/index.php", indexPage.getCurrentURL());
    }

    @When("I click on the women's category")
    public void iClickOnTheWomenSCategory() {

        indexPage.categoryMenu().clickWomen();

    }

    @Then("I am sent to the women's department")
    public void iAmSentToTheWomenSDepartment() {
        Assertions.assertEquals("http://automationpractice.com/index.php?id_category=8&controller=category", indexPage.getCurrentURL());

    }

    @When("I click on the dresses category")
    public void iClickOnTheDressesCategory() {

        indexPage.categoryMenu().clickDresses();

    }

    @And("I am sent to the dress section")
    public void iAmSentToTheDressSection() {
        Assertions.assertEquals("http://automationpractice.com/index.php?id_category=8&controller=category", indexPage.getCurrentURL());

    }

    @When("I click on the Best Sellers tab")
    public void iClickOnTheBestSellersTab() {
        indexPage.clickBestSellerButton();
    }

    @Then("I can see the best selling items")
    public void iCanSeeTheBestSellingItems() {

        indexPage.clickBestSellerButton().featuredItems().getTitle(0);
        indexPage.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assertions.assertEquals("Printed Chiffon Dress",  indexPage.clickBestSellerButton().featuredItems().getTitle(0));

    }

    @When("I click on the search button")
    public void iClickOnTheSearchButton() {
        indexPage.doSearch("dress");

    }

    @Then("I am taken to my search results")
    public void iAmTakenToMySearchResults() {

        Assertions.assertEquals("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=", indexPage.getCurrentURL());

    }

    @When("I click on the {string} panel")
    public void iClickOnThePanel(String name) {


    }

    @Then("I am taken to the {string} page")
    public void iAmTakenToThePage(String name) {

        switch (name) {
            case ("My orders"):
                Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=history", indexPage.getCurrentURL());
            case ("My credit slips"):
                Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=order-slip", indexPage.getCurrentURL());
            case ("My addresses"):
                Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=addresses", indexPage.getCurrentURL());
            case ("My personal info"):
                Assertions.assertEquals("http://automationpractice.com/index.php?controller=authentication&back=identity", indexPage.getCurrentURL());
        }

    }


    @Then("I am taken to the {string} section.")
    public void iAmTakenToTheSection(String name) {
        switch (name) {
            case ("Specials"):
                Assertions.assertEquals("http://automationpractice.com/index.php?controller=prices-drop", indexPage.getCurrentURL());
            case ("New products"):
                Assertions.assertEquals("http://automationpractice.com/index.php?controller=new-products", indexPage.getCurrentURL());
            case ("Best sellers"):
                Assertions.assertEquals("http://automationpractice.com/index.php?controller=best-sales", indexPage.getCurrentURL());
            case ("Our stores"):
                Assertions.assertEquals("http://automationpractice.com/index.php?controller=stores", indexPage.getCurrentURL());
            case ("Terms and conditions of use"):
                Assertions.assertEquals("http://automationpractice.com/index.php?id_cms=3&controller=cms", indexPage.getCurrentURL());
            case ("About us"):
                Assertions.assertEquals("http://automationpractice.com/index.php?id_cms=4&controller=cms", indexPage.getCurrentURL());
            case ("Sitemap"):
                Assertions.assertEquals("http://automationpractice.com/index.php?controller=sitemap", indexPage.getCurrentURL());
        }
    }

    @When("I click on the button within the Call Us section")
    public void iClickOnTheButtonWithinTheCallUsSection() {

      //  indexPage.

    }

    @Then("I am taken to the organization's website")
    public void iAmTakenToTheOrganizationSWebsite() {
        Assertions.assertEquals("http://www.seleniumframework.com/", indexPage.getCurrentURL());

    }

    @When("I click on the {string} link")
    public void iClickOnTheLink(String name) {

        switch (name) {
            case ("Specials"):
                indexPage.pageFooter().goToSpecials();
                break;
            case ("New products"):
                indexPage.pageFooter().goToNewProducts();
                break;
            case ("Best sellers"):
                indexPage.pageFooter().goToBestSellers();
                break;
            case ("Our stores"):
                indexPage.pageFooter().goToOurStores();
                break;
            case ("Terms and conditions of use"):
                indexPage.pageFooter().goToTermsAndConditions();
                break;
            case ("About us"):
                indexPage.pageFooter().goToAboutUs();
                break;
            case ("Sitemap"):
                indexPage.pageFooter().goToSitemap();
                break;
            case ("My orders"):
            case ("My credit slips"):
                indexPage.pageFooter().goToMyOrders();
                break;
            case ("My addresses"):
                indexPage.pageFooter().goToMyAddresses();
                break;
            case ("My personal info"):
                indexPage.pageFooter().goToMyPersonalInfo();
                break;
        }

    }

    @When("I click on the contact us button")
    public void iClickOnTheContactUsButton() {
        indexPage.getPageHeader().clickContactUsButton();

    }

    @Then("I am taken to the contact us page")
    public void iAmTakenToTheContactUsPage() {
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=contact", indexPage.getCurrentURL());

    }

    @After("@index")
    public static void tearDown() {
        if(webDriver != null) {
            driverManager.quitDriver();
            System.out.println("tearDown index");
        }
    }

    @When("I enter my email address and submit it")
    public void iEnterMyEmailAddress() {
        indexPage.getPageFooter().enterNewsletterEmailAndClickSubmit("dpbtest@test.com");
    }

    @Then("I will register myself for the email newsletter")
    public void iWillRegisterMyselfForTheEmailNewsletter() {
        Assertions.assertTrue((BooleanSupplier) webDriver.findElement(By.className("alert_alert-success")));
    }
}
