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
        //WomensPage womensPage = new WomensPage(webdriver);
        //womensPage.clickTShirts();
    }

    @And("I hover over the first product displayed")
    public void iHoverOverTheFirstProductDisplayed() {
        //add the method call
    }

    @And("I click on the More button")
    public void iClickOnTheMoreButton() {
        ////womensPage.clickMore();
    }

    @And("I click on the plus button to increase the quantity to two")
    public void iClickOnThePlusButtonToIncreaseTheQuantityToTwo() {
        //ItemPage itemPage = new ItemPage(webdriver);
        //itemPage.clickPlus();
    }

    @And("I select size M")
    public void iSelectSizeM() {
        //itemPage.clickSizeDropdown();
        //itemPage.clickM();
    }

    @And("I click on the Add to cart blue button")
    public void iClickOnTheAddToCartBlueButton() {
        //itemPage.clickAddToCart();
    }

    @And("I click on the green Proceed to checkout button")
    public void iClickOnTheGreenProceedToCheckoutButton() {
        //itemPage.clickProceedToCheckout();
    }

    @And("I click on the Proceed to checkout button on the summary page")
    public void iClickOnTheProceedToCheckoutButtonOnTheSummaryPage() {
        //SummaryPage summaryPage = new SummaryPage(webdriver);
        //summaryPage.clickProceedToCheckout();
    }

    @And("I click on the Proceed to checkout button on the address page")
    public void iClickOnTheProceedToCheckoutButtonOnTheAddressPage() {
        //AddressPage addressPage = new AddressPage(webdriver);
        //addressPage.clickProceedToCheckout();
    }

    @And("I click on the agree to terms and conditions")
    public void iClickOnTheAgreeToTermsAndConditions() {
        //ShippingPage shippingPage = new ShippingPage(webdriver);
        //shippingPage.clickTermsAndConditions();
    }

    @And("I click on the Proceed to checkout button on the shipping page")
    public void iClickOnTheProceedToCheckoutButtonOnTheShippingPage() {
        //shippingPage.clickProceedToCheckout();
    }

    @And("I click on the Pay by bank wire button")
    public void iClickOnThePayByBankWireButton() {

        //paymentPage.clickPayByBankWire();
    }

    @And("I click on the I confirm my order button on the payment page")
    public void iClickOnTheIConfirmMyOrderButtonOnThePaymentPage() {
        //PaymentPage paymentPage = new PaymentPage(webdriver);
        //paymentPage.clickConfirmMyOrder();
    }

    @Then("Your order on My Store is complete. should be displayed")
    public void yourOrderOnMyStoreIsCompleteShouldBeDisplayed() {
        //CheckoutFinal checkoutFinal = new CheckoutFinal(webdriver);
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
