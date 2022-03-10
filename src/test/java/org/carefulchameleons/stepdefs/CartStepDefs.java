package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.ProductSelection;
import org.carefulchameleons.pom.cart.CartSummaryPage;
import org.carefulchameleons.webdrivers.WebDriverFactory;
import org.carefulchameleons.webdrivers.model.WebDriverManager;
import org.carefulchameleons.webdrivers.model.WebDriverType;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartStepDefs {
    private static WebDriver driver;
    private static WebDriverManager driverManager;
    private static CartSummaryPage cartSummaryPage;
    private static IndexPage indexPage;
    private static ProductSelection productSelection;

    @Before
    public void setUp() {
        driverManager = WebDriverFactory.getManager(WebDriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Given("I am on the Cart Page")
    public void iAmInTheCartPage() {
        driver.get("http://automationpractice.com/index.php?controller=order");
        cartSummaryPage = new CartSummaryPage(driver);
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
        driver.get("http://automationpractice.com/index.php");
        indexPage = new IndexPage(driver);
        productSelection =  indexPage.featuredItems();
        productSelection.addItemToCart(0);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]")));
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
        cartSummaryPage.removeProductFromCart(0);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I click on the minus button next to the item")
    public void iClickOnTheMinusButtonNextToTheItem() {
        cartSummaryPage.decrementQuantity(0);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @When("I click on the plus button next to the item")
    public void iClickOnThePlusButtonNextToTheItem() {
        cartSummaryPage.incrementQuantity(0);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("Item's quantity should increase from {int} to {int}")
    public void itemSQuantityShouldIncreaseFromTo(int arg0, int arg1) {
        double totalProducts = cartSummaryPage.getProductQuantity(0);
        Assertions.assertEquals(arg1, totalProducts);
    }

    @Then("Item's quantity should be {int}")
    public void itemSQuantityShouldBe(int arg0) {
        double totalProducts = cartSummaryPage.getProductQuantity(0);
        Assertions.assertEquals(arg0, totalProducts);
    }


    @After("@cart")
    public static void tearDown() {
        if (driverManager.getDriver() != null) {
            driverManager.quitDriver();
            System.out.println("tearDown cart");
        }
    }

}
