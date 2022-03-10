package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
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
    //private ProductFancyPage
    private ProductPage productPage;

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        driverManager = WebDriverFactory.getManager(WebDriverType.CHROME);
        webDriver = driverManager.getDriver();
        webDriver.get("http://automationpractice.com/index.php");
    }

    @When("I click on the black Sign in button")
    public void iClickOnTheBlackSignInButton() {
        indexPage = new IndexPage(webDriver);
        indexPage.getPageHeader().clickSignInButton();
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
        womenMenu = myAccountPage.getCategoryMenu().hoverOverWomen();
    }

    @And("I click on the sub menu T-shirts")
    public void iClickOnTheSubMenuTShirts() {
        categoryPage = womenMenu.clickOnTShirts();
    }

    @And("I click on the first product displayed")
    public void iClickOnTheFirstProductDisplayed() {
        categoryPage.getProductSelection().clickOnMore(0);
    }

//    @And("I click on the More button")
//    public void iClickOnTheMoreButton() {
//    //categoryPage.
//    }

    @And("I click on the plus button to increase the quantity to two")
    public void iClickOnThePlusButtonToIncreaseTheQuantityToTwo() {
                                                     //this page's url: http://automationpractice.com/index.php?id_product=1&controller=product
        productPage.increaseQuantity();
    }

    @And("I select size M")
    public void iSelectSizeM() {
        productPage.selectSize(SizeSelection.M);
    }

    @And("I click on the Add to cart blue button")
    public void iClickOnTheAddToCartBlueButton() {

        //productPage.addToCart();
    }

    @And("I click on the green Proceed to checkout button")
    public void iClickOnTheGreenProceedToCheckoutButton() {
        //from the popped up thing
        //thisPage.clickProceedToCheckout();
    }

    @And("I click on the Proceed to checkout button on the summary page")
    public void iClickOnTheProceedToCheckoutButtonOnTheSummaryPage() {
        summaryPage.proceedToCheckoutLoggedIn();
    }

    @And("I click on the Proceed to checkout button on the address page")
    public void iClickOnTheProceedToCheckoutButtonOnTheAddressPage() {
         addressPage.proceedToCheckout();
    }

    @And("I click on the agree to terms and conditions")
    public void iClickOnTheAgreeToTermsAndConditions() {
        shippingPage.clickTOS();
        //shippingPage.isTOSChecked();
    }

    @And("I click on the Proceed to checkout button on the shipping page")
    public void iClickOnTheProceedToCheckoutButtonOnTheShippingPage() {
        shippingPage.proceedToCheckout();
    }

    @And("I click on the Pay by bank wire button")
    public void iClickOnThePayByBankWireButton() {
    paymentPage.payByBankWire();

    //cartBankWirePaymentPage = new CartBankWirePaymentPage(webDriver);

        //paymentPage.clickPayByBankWire(); Need this method
    }

    @And("I click on the I confirm my order button on the payment page")
    public void iClickOnTheIConfirmMyOrderButtonOnThePaymentPage() {
        cartBankWirePaymentPage.confirmOrder();
    }

    @Then("Your order on My Store is complete. should be displayed")
    public void yourOrderOnMyStoreIsCompleteShouldBeDisplayed() {
        //url is different in CartPageConfirmationPage
        //url for order confirmation page: http://automationpractice.com/index.php?controller=order-confirmation&id_cart=4308278&id_module=3&id_order=408994&key=bb5ced91d4f2089035d2b0d9f38876f5

        cartPaymentConfirmationPage = new CartPaymentConfirmationPage(webDriver);
        Assertions.assertEquals("Your order on My Store is complete.", cartPaymentConfirmationPage.getOrderCompleteText());
    }

    @After
    public static void tearDown() {
        if(webDriver != null) {
            driverManager.quitDriver();
            System.out.println("tearDown order");
        }
    }
}
