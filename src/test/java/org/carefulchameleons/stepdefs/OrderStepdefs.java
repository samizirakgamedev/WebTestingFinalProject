package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class OrderStepdefs {

    private static WebDriver webDriver;
    //private Homepage homePage;
    //private LoginPage loginPage;
    //private MyAccountPage myAccountPage;
    //private static WebDriverManager manager;
    //private CheckoutFinal check;

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        //manager = WebDriverFactory.getManager(WebDriverType.CHROME);
        //webDriver = manager.getDriver();
        webDriver.get("http://automationpractice.com/index.php");

    }

    @When("I click on the black Sign in button")
    public void iClickOnTheBlackSignInButton() {
        //homePage = new homePage(webDriver);
        //homePage.clickSignInButton();
    }

    @And("I enter the Email Address {string} and  the Password {string}")
    public void iEnterTheEmailAddressAndThePassword(String email, String password) {
        //loginPage = new LoginPage(webDriver);
        //loginPage.enterUsername(username);
        //loginPage.enterPassword(password);
    }

    @And("I click Sign in green button")
    public void iClickSignInGreenButton() {
        //loginPage.clickLogInButton();
    }

    @And("I move my cursor to the WOMEN tab")
    public void iMoveMyCursorToTheWOMENTab() {
        //add the method call
    }

    @And("I click on the sub menu T-shirts")
    public void iClickOnTheSubMenuTShirts() {
        //add the method call
    }

    @And("I hover over the first product displayed")
    public void iHoverOverTheFirstProductDisplayed() {
        //add the method call
    }

    @And("I click on the More button")
    public void iClickOnTheMoreButton() {
        //add the method call
    }

    @And("I click on the plus button to increase the quantity to two")
    public void iClickOnThePlusButtonToIncreaseTheQuantityToTwo() {
        //add the method call
    }

    @And("I select size M")
    public void iSelectSizeM() {
        //add the method call
    }

    @And("I click on the Add to cart blue button")
    public void iClickOnTheAddToCartBlueButton() {
        //add the method call
    }

    @And("I click on the green Proceed to checkout button")
    public void iClickOnTheGreenProceedToCheckoutButton() {
        //add the method call
    }

    @And("I click on the Proceed to checkout button on the summary page")
    public void iClickOnTheProceedToCheckoutButtonOnTheSummaryPage() {
        //add the method call
    }

    @And("I click on the Proceed to checkout button on the address page")
    public void iClickOnTheProceedToCheckoutButtonOnTheAddressPage() {
        //add the method call
    }

    @And("I click on the agree to terms and conditions")
    public void iClickOnTheAgreeToTermsAndConditions() {
        //add the method call
    }

    @And("I click on the Proceed to checkout button on the shipping page")
    public void iClickOnTheProceedToCheckoutButtonOnTheShippingPage() {
        //add the method call
    }

    @And("I click on the Pay by bank wire button")
    public void iClickOnThePayByBankWireButton() {
        //add the method call
    }

    @And("I click on the I confirm my order button on the payment page")
    public void iClickOnTheIConfirmMyOrderButtonOnThePaymentPage() {
        //add the method call
    }

    @Then("Your order on My Store is complete. should be displayed")
    public void yourOrderOnMyStoreIsCompleteShouldBeDisplayed() {
        //Assertions.assertEquals("Your order on My Store is complete.", checkoutFinal.getTitle());
    }

    @After
    public static void tearDown() {
        if(webDriver != null) {
            //    manager.quitDriver();
            System.out.println("tearDown login");
        }
    }
}
