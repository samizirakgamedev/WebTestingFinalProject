package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.PageFooter;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InformationStepDefs {
    private static WebDriver webDriver;
    private static PageFooter pageFooter;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
    }
    @After
    public void cleanUp() {
        webDriver.close();
        webDriver.quit();
    }

    @Given("I am on the Home page")
    public void IAmOnTheHomePage(){
        webDriver.get("http://automationpractice.com/index.php");
        pageFooter = new PageFooter(webDriver);
    }

    @When("I click on the Specials link")
    public void iClickOnTheSpecialsLink() {
        pageFooter.goToSpecials();
    }

    @Then("I am taken to the Specials page")
    public void iAmTakenToTheSpecialsPage() {
        String currentUrl = webDriver.getCurrentUrl();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=prices-drop", currentUrl);
    }

    @When("I click on the New Products link")
    public void iClickOnTheNewProductsLink() {
        pageFooter.goToNewProducts();
    }

    @Then("I am taken to the New Products page")
    public void iAmTakenToTheNewProductsPage() {
        String currentUrl = webDriver.getCurrentUrl();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=new-products", currentUrl);
    }

    @When("I click on the Best Sellers link")
    public void iClickOnTheBestSellersLink() {
        pageFooter.goToBestSellers();
    }

    @Then("I am taken to the Best Sellers page")
    public void iAmTakenToTheBestSellersPage() {
        String currentUrl = webDriver.getCurrentUrl();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=best-sales", currentUrl);
    }

    @When("I click on the Our Stores link")
    public void iClickOnTheOurStoresLink() {
        pageFooter.goToOurStores();
    }

    @Then("I am taken to the Our Stores page")
    public void iAmTakenToTheOurStoresPage() {
        String currentUrl = webDriver.getCurrentUrl();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=stores", currentUrl);
    }

    @When("I click on the Terms and conditions of use link")
    public void iClickOnTheTermsAndConditionsOfUseLink() {
        pageFooter.goToTermsAndConditions();
    }

    @Then("I am taken to the Terms and conditions of use page")
    public void iAmTakenToTheTermsAndConditionsOfUsePage() {
        String currentUrl = webDriver.getCurrentUrl();
        Assertions.assertEquals("http://automationpractice.com/index.php?id_cms=3&controller=cms", currentUrl);
    }

    @When("I click on the About us link")
    public void iClickOnTheAboutUsLink() {
        pageFooter.goToAboutUs();
    }

    @Then("I am taken to the About us page")
    public void iAmTakenToTheAboutUsPage() {
        String currentUrl = webDriver.getCurrentUrl();
        Assertions.assertEquals("http://automationpractice.com/index.php?id_cms=4&controller=cms", currentUrl);
    }

    @When("I click on the Sitemap link")
    public void iClickOnTheSitemapLink() {
        pageFooter.goToSitemap();
    }

    @Then("I am taken to the Sitemap page")
    public void iAmTakenToTheSitemapPage() {
        String currentUrl = webDriver.getCurrentUrl();
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=sitemap", currentUrl);
    }
}
