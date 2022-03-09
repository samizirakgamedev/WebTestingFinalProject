package org.carefulchameleons.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.ItemPage;
import org.carefulchameleons.pom.ProductPage;
import org.carefulchameleons.pom.ProductSelection;
import org.carefulchameleons.pom.cart.CartPage;
import org.carefulchameleons.pom.cart.CartSummaryPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartStepDefs {
    private static WebDriver webDriver;
    private static CartSummaryPage cartSummaryPage;
    private static IndexPage indexPage;
    private static ProductSelection productSelection;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
    }

    @Given("I am on the Cart Page")
    public void iAmInTheCartPage() {
        webDriver.get("http://automationpractice.com/index.php?controller=order");
        cartSummaryPage = new CartSummaryPage(webDriver);
    }
    
    @And("No items have been added")
    public void noItemsHaveBeenAdded() {}

    @Then("Cart should be empty")
    public void cartShouldBeEmpty() {
        Assertions.assertTrue(cartSummaryPage.isCartEmpty());
    }

    @And("Your shopping cart is empty. should appear")
    public void shouldAppear() {
        String message = cartSummaryPage.getEmptyAlert();
        Assertions.assertEquals("Your shopping cart is empty.", message);
    }

    @And("An item has been added")
    public void anItemHasBeenAdded() {
    }

    @Given("I have added an item to the cart")
    public void iHaveAddedAnItemToTheCart() {
        webDriver.get("http://automationpractice.com/index.php");
        indexPage = new IndexPage(webDriver);
        productSelection =  indexPage.featuredItems();
        productSelection.addItemToCart(0);
    }

    @When("I go to the Cart Page")
    public void iGoToTheCartPage() {
        cartSummaryPage = productSelection.proceedToCheckout();
    }

    @Then("Item should be shown in the page")
    public void itemShouldBeShownInThePage() {
        int products = cartSummaryPage.getCartSize();
        Assertions.assertEquals(1, products);
    }

    @And("I click on the remove item button next to the item")
    public void iClickOnTheRemoveItemButtonNextToTheItem() {
        cartSummaryPage.removeProductFromCart(1);
    }

    @When("I click on the minus button next to the item")
    public void iClickOnTheMinusButtonNextToTheItem() {
        cartSummaryPage.decrementQuantity(1);
    }

    @When("I click on the plus button next to the item")
    public void iClickOnThePlusButtonNextToTheItem() {
        cartSummaryPage.incrementQuantity(1);
    }

    @Then("Item's quantity should increase from {int} to {int}")
    public void itemSQuantityShouldIncreaseFromTo(int arg0, int arg1) {
        double totalProducts = cartSummaryPage.getTotalProducts();
        Assertions.assertEquals(arg1, totalProducts);
    }

    @And("An item has been added and its quantity increased")
    public void anItemHasBeenAddedAndItsQuantityIncreased() {
        //add item to cart

        cartSummaryPage.incrementQuantity(1);
    }

    @Then("Item's quantity should be {int}")
    public void itemSQuantityShouldBe(int arg0) {
        double totalProducts = cartSummaryPage.getTotalProducts();
        Assertions.assertEquals(arg0, totalProducts);
    }

    @When("I edit quantity text box with number {int}")
    public void iEditQuantityTextBoxWithNumber(int arg0) {
        //Edit text box

    }

    @Then("Item's quantity should be {int} and total should be updated")
    public void itemSQuantityShouldBeAndTotalShouldBeUpdated(int arg0) {

        double totalProducts = cartSummaryPage.getTotalProducts();
        Assertions.assertEquals(arg0, totalProducts);
    }

    @And("Total number of products should be {int}")
    public void totalNumberOfProductsShouldBe(int arg0) {
        double totalProducts = cartSummaryPage.getTotalProducts();
        Assertions.assertEquals(arg0, totalProducts);
    }
}
