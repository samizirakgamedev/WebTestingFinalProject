package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.webdrivers.WebDriverFactory;
import org.carefulchameleons.webdrivers.model.WebDriverManager;
import org.carefulchameleons.webdrivers.model.WebDriverType;
import org.openqa.selenium.WebDriver;

public class InformationStepDefs {

    private static WebDriver webDriver;
    private  static WebDriverManager driverManager;

    @When("I click on the Specials link")
    public void iClickOnTheSpecialsLink() {
        driverManager = WebDriverFactory.getManager(WebDriverType.CHROME);
        webDriver = driverManager.getDriver();
    }

    @Then("I am taken to the Specials page")
    public void iAmTakenToTheSpecialsPage() {

    }

    @When("I click on the New Products link")
    public void iClickOnTheNewProductsLink() {

    }

    @Then("I am taken to the New Products page")
    public void iAmTakenToTheNewProductsPage() {

    }

    @When("I click on the Best Sellers link")
    public void iClickOnTheBestSellersLink() {
    }

    @Then("I am taken to the Best Sellers page")
    public void iAmTakenToTheBestSellersPage() {
    }

    @When("I click on the Our Stores link")
    public void iClickOnTheOurStoresLink() {
    }

    @Then("I am taken to the Our Stores page")
    public void iAmTakenToTheOurStoresPage() {
    }

    @When("I click on the Contact us link")
    public void iClickOnTheContactUsLink() {
    }

    @Then("I am taken to the Contact us page")
    public void iAmTakenToTheContactUsPage() {
    }

    @When("I click on the Terms and conditions of use link")
    public void iClickOnTheTermsAndConditionsOfUseLink() {
    }

    @Then("I am taken to the Terms and conditions of use page")
    public void iAmTakenToTheTermsAndConditionsOfUsePage() {
    }

    @When("I click on the About us link")
    public void iClickOnTheAboutUsLink() {
    }

    @Then("I am taken to the About us page")
    public void iAmTakenToTheAboutUsPage() {
    }

    @When("I click on the Sitemap link")
    public void iClickOnTheSitemapLink() {
    }

    @Then("I am taken to the Sitemap page")
    public void iAmTakenToTheSitemapPage() {
    }

    @After
    public static void tearDown() {
        if(webDriver != null) {
            driverManager.quitDriver();
            System.out.println("tearDown information");
        }
    }

}
