package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pageelements.WomenMenu;
import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.ProductPage;
import org.carefulchameleons.pom.ProductSelection;
import org.carefulchameleons.pom.cart.*;
import org.carefulchameleons.pom.category.CategoryPage;
import org.carefulchameleons.pom.enums.SizeSelection;
import org.carefulchameleons.pom.myaccounts.MyAccountPage;
import org.carefulchameleons.pom.myaccounts.SignInPage;
import org.carefulchameleons.webdrivers.WebDriverFactory;
import org.carefulchameleons.webdrivers.model.WebDriverManager;
import org.carefulchameleons.webdrivers.model.WebDriverType;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class OrderStepdefs {

    private static WebDriver webDriver;
    private  static WebDriverManager driverManager;
    private IndexPage indexPage;
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;
    private CartSummaryPage summaryPage;
    private CartAddressPage addressPage;
    private CartShippingPage shippingPage;
    private CartPaymentPage paymentPage;
    private CartPaymentConfirmationPage cartPaymentConfirmationPage;
    private CartBankWirePaymentPage cartBankWirePaymentPage;

    private WomenMenu womenMenu;
    private CategoryPage categoryPage;
    private ProductSelection productSelection;
    private ProductPage productPage;

    @Before("@order")
    public void setUp() {
        driverManager = WebDriverFactory.getManager(WebDriverType.CHROME);
        webDriver = driverManager.getDriver();
        webDriver.get("http://automationpractice.com/index.php");
    }

    @After("@order")
    public static void tearDown() {
        if(webDriver != null) {
            driverManager.quitDriver();
            System.out.println("tearDown order");
        }
    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
    }

    @When("I click on the black Sign in button")
    public void iClickOnTheBlackSignInButton() {
        indexPage = new IndexPage(webDriver);
        indexPage.getPageHeader().clickSignInButton();
    }

    @And("I enter the Email Address {string} and  the Password {string}")
    public void iEnterTheEmailAddressAndThePassword(String email, String password) {
        signInPage = new SignInPage(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=my-account");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        womenMenu = myAccountPage.getCategoryMenu().hoverOverWomen();
    }

    @And("I click on the sub menu T-shirts")
    public void iClickOnTheSubMenuTShirts() {
        categoryPage = womenMenu.clickOnTShirts();
    }

    @And("I hover over and click more on the first product displayed")
    public void iHoverOverAndClickMoreOnTheFirstProductDisplayed() {
            categoryPage.getProductSelection().hoverOverProduct(0);
            productPage = categoryPage.getProductSelection().clickOnMore(0);
    }

    @And("I click on the plus button to increase the quantity to two")
    public void iClickOnThePlusButtonToIncreaseTheQuantityToTwo() {
        productPage.increaseQuantity();
    }

    @And("I select size M")
    public void iSelectSizeM() {
        productPage.selectSize(SizeSelection.M);
    }

    @And("I click on the Add to cart blue button")
    public void iClickOnTheAddToCartBlueButton() {
        productSelection = productPage.addToCart();
    }

    @And("I click on the green Proceed to checkout button")
    public void iClickOnTheGreenProceedToCheckoutButton() {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        productSelection.proceedToCheckout();
    }

    @And("I click on the Proceed to checkout button on the summary page")
    public void iClickOnTheProceedToCheckoutButtonOnTheSummaryPage() {
        summaryPage = new CartSummaryPage(webDriver);
        summaryPage.proceedToCheckoutLoggedIn();
    }

    @And("I click on the Proceed to checkout button on the address page")
    public void iClickOnTheProceedToCheckoutButtonOnTheAddressPage() {
        addressPage = new CartAddressPage(webDriver);
         addressPage.proceedToCheckout();
    }

    @And("I click on the agree to terms and conditions")
    public void iClickOnTheAgreeToTermsAndConditions() {
        shippingPage = new CartShippingPage(webDriver);
        shippingPage.acceptTOS();
    }

    @And("I click on the Proceed to checkout button on the shipping page")
    public void iClickOnTheProceedToCheckoutButtonOnTheShippingPage() {
        shippingPage.proceedToCheckout();
    }

    @And("I click on the Pay by bank wire button")
    public void iClickOnThePayByBankWireButton() {
        paymentPage = new CartPaymentPage(webDriver);
        cartBankWirePaymentPage = paymentPage.payByBankWire();
    }

    @And("I click on the I confirm my order button on the payment page")
    public void iClickOnTheIConfirmMyOrderButtonOnThePaymentPage() {
        cartPaymentConfirmationPage =
                cartBankWirePaymentPage.confirmOrder();
    }

    @Then("I should be on the Cart Payment Confirmation page")
    public void iShouldBeOnTheCartPaymentConfirmationPage() {
        Assertions.assertTrue(cartPaymentConfirmationPage.getCurrentURL().contains("controller=order-confirmation"));
    }

}
