package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.cart.*;
import org.carefulchameleons.pom.myaccounts.MyAccountPage;
import org.carefulchameleons.pom.myaccounts.SignInPage;
import org.openqa.selenium.WebDriver;

public class OrderStepdefs {

    private static WebDriver webDriver;
    private IndexPage indexPage;
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;
    private CartSummaryPage summaryPage;
    private CartAddressPage addressPage;
    private CartShippingPage shippingPage;
    private CartPaymentPage paymentPage;
    private CartPaymentConfirmationPage cartPaymentConfirmationPage;
    private CartBankWirePaymentPage cartBankWirePaymentPage;
    //private static WebDriverManager manager;

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        //manager = WebDriverFactory.getManager(WebDriverType.CHROME);
        //webDriver = manager.getDriver();
        webDriver.get("http://automationpractice.com/index.php");
    }

    @When("I click on the black Sign in button")
    public void iClickOnTheBlackSignInButton() {
        indexPage = new IndexPage(webDriver);
        //indexPage.clickSignInButton();
    }

    @And("I enter the Email Address {string} and  the Password {string}")
    public void iEnterTheEmailAddressAndThePassword(String email, String password) {
        signInPage = new SignInPage(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=my-account");
        signInPage.enterLoginEmail(email);
        signInPage.enterLoginPassword(password);
    }

    @And("I click Sign in green button")
    public void iClickSignInGreenButton() {
        signInPage.clickLoginButton();
    }

    @And("I move my cursor to the WOMEN tab")
    public void iMoveMyCursorToTheWOMENTab() {
        myAccountPage = new MyAccountPage(webDriver);
        //myAccountPage.METHOD?? hovering to women tab
    }

    @And("I click on the sub menu T-shirts")
    public void iClickOnTheSubMenuTShirts() {
        //myAccountPage.clickTShirts();   //url for T-shirts page: http://automationpractice.com/index.php?id_category=5&controller=category
    }

    @And("I hover over the first product displayed")
    public void iHoverOverTheFirstProductDisplayed() {
        //initialise tshirts page?
        //hovering over Faded short sleeve Tshirt  //TshirtPage.METHOD??
    }

    @And("I click on the More button")
    public void iClickOnTheMoreButton() {
        //on the dynamic thing
        //TshirtPage.clickMore();
    }

    @And("I click on the plus button to increase the quantity to two")
    public void iClickOnThePlusButtonToIncreaseTheQuantityToTwo() {
          //initialise this page?                                                      //this page's url: http://automationpractice.com/index.php?id_product=1&controller=product

        //thisPage.clickPlus();
    }

    @And("I select size M")
    public void iSelectSizeM() {
        //thisPage.clickSizeDropdown();
        //thisPage.clickM();
    }

    @And("I click on the Add to cart blue button")
    public void iClickOnTheAddToCartBlueButton() {
        //thisPage.clickAddToCart();
    }

    @And("I click on the green Proceed to checkout button")
    public void iClickOnTheGreenProceedToCheckoutButton() {
        //from the popped up thing
        //thisPage.clickProceedToCheckout();
    }

    @And("I click on the Proceed to checkout button on the summary page")
    public void iClickOnTheProceedToCheckoutButtonOnTheSummaryPage() {
        summaryPage = new CartSummaryPage(webDriver);
        //summaryPage.clickProceedToCheckout();
    }

    @And("I click on the Proceed to checkout button on the address page")
    public void iClickOnTheProceedToCheckoutButtonOnTheAddressPage() {
         addressPage = new CartAddressPage(webDriver);
        //addressPage.clickProceedToCheckout();
    }

    @And("I click on the agree to terms and conditions")
    public void iClickOnTheAgreeToTermsAndConditions() {
        shippingPage = new CartShippingPage(webDriver);
        //shippingPage.clickTermsAndConditions();
    }

    @And("I click on the Proceed to checkout button on the shipping page")
    public void iClickOnTheProceedToCheckoutButtonOnTheShippingPage() {
        //shippingPage.clickProceedToCheckout();
    }

    @And("I click on the Pay by bank wire button")
    public void iClickOnThePayByBankWireButton() {
    paymentPage = new CartPaymentPage(webDriver);

    //cartBankWirePaymentPage = new CartBankWirePaymentPage(webDriver);

        //paymentPage.clickPayByBankWire();
    }

    @And("I click on the I confirm my order button on the payment page")
    public void iClickOnTheIConfirmMyOrderButtonOnThePaymentPage() {
        cartBankWirePaymentPage = new CartBankWirePaymentPage(webDriver);
        cartBankWirePaymentPage.confirmOrder();
    }

    @Then("Your order on My Store is complete. should be displayed")
    public void yourOrderOnMyStoreIsCompleteShouldBeDisplayed() {
        //url is different in CartPageConfirmationPage
        //url for order confirmation page: http://automationpractice.com/index.php?controller=order-confirmation&id_cart=4308278&id_module=3&id_order=408994&key=bb5ced91d4f2089035d2b0d9f38876f5

        //CartPageConfirmationPage checkoutFinal = new CartPageConfirmationPage(webdriver);
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
