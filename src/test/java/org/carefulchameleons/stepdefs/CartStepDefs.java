package org.carefulchameleons.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pom.cart.CartPage;
import org.openqa.selenium.WebDriver;

public class CartStepDefs {
    private static WebDriver webDriver;
    private static CartPage cartPage;

    @Before
    public void setup() {

    }


    @Given("I am on the Cart Page")
    public void iAmInTheCartPage() {
        webDriver.get("http://automationpractice.com/index.php?controller=order");
    }
    
    @And("No items have been added")
    public void noItemsHaveBeenAdded() {

    }

    @Then("Cart should be empty")
    public void cartShouldBeEmpty() {
        
        
    }

    @And("{string} should appear")
    public void shouldAppear(String arg0) {
        
    }

    @And("An item has been added")
    public void anItemHasBeenAdded() {
        
    }

    @Then("Item should be shown in the page")
    public void itemShouldBeShownInThePage() {
    }

    @When("I click on the remove item button next to the item")
    public void iClickOnTheRemoveItemButtonNextToTheItem() {
        
    }

    @When("I click on the minus button next to the item")
    public void iClickOnTheMinusButtonNextToTheItem() {
        
    }

    @When("I click on the plus button next to the item")
    public void iClickOnThePlusButtonNextToTheItem() {
    }

    @Then("Item's quantity should increase from {int} to {int}")
    public void itemSQuantityShouldIncreaseFromTo(int arg0, int arg1) {
    }

    @And("An item has been added and its quantity increased")
    public void anItemHasBeenAddedAndItsQuantityIncreased() {
    }

    @Then("Item's quantity should be {int}")
    public void itemSQuantityShouldBe(int arg0) {
        
    }

    @When("I edit quantity text box with number {int}")
    public void iEditQuantityTextBoxWithNumber(int arg0) {
    }

    @Then("Item's quantity should be {int} and total should be updated")
    public void itemSQuantityShouldBeAndTotalShouldBeUpdated(int arg0) {
    }

    @And("Total number of products should be {int}")
    public void totalNumberOfProductsShouldBe(int arg0) {
    }
}
