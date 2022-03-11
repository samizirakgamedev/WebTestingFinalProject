package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.webdrivers.WebDriverFactory;
import org.carefulchameleons.webdrivers.model.WebDriverManager;
import org.carefulchameleons.webdrivers.model.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.carefulchameleons.pom.category.CategoryPage;

public class CategoryStepdefs {

    private static WebDriver webDriver;
    private  static WebDriverManager driverManager;

    private CategoryPage categoryPage;

    @Before("@categories")
    public void setUp() {
        driverManager = WebDriverFactory.getManager(WebDriverType.CHROME);
        webDriver = driverManager.getDriver();
        webDriver.get("http://automationpractice.com/index.php");
    }

    @After("@categories")
    public static void tearDown() {
        if(webDriver != null) {
            driverManager.quitDriver();
            System.out.println("tearDown register");
        }
    }

    @Given("I am on the category 3 page")
    public void iAmOnTheCategoryPage() {
        categoryPage = new CategoryPage(webDriver, 3);
        String catID = "3";
        webDriver.navigate().to("http://automationpractice.com/index.php?id_category=" + catID + "&controller=category");
    }

    @When("I select a composition cotton")
    public void iSelectACompositionCotton() {
        categoryPage.selectComposition("cotton");
    }

    @When("I select a composition polyester")
    public void iSelectACompositionPolyester() {
        categoryPage.selectComposition("polyester");
    }

    @When("I select a composition viscose")
    public void iSelectACompositionViscose() {
        categoryPage.selectComposition("viscose");
    }

    @Then("only the products with correct composition should appear")
    public boolean onlyTheRelevantProductsShouldAppear() {
        boolean isCompositionSelected = false;
        if (categoryPage.getCurrentURL().contains("compositions-")) isCompositionSelected = true;
        return isCompositionSelected;
    }

    @When("I select a style casual")
    public void iSelectAStyleCasual() {
        categoryPage.selectStyle("casual");
    }

    @When("I select a style dressy")
    public void iSelectAStyleDressy() {
        categoryPage.selectStyle("dressy");
    }

    @When("I select a style girly")
    public void iSelectAStyleGirly() {
        categoryPage.selectStyle("girly");
    }

    @Then("only the products with correct style should appear")
    public boolean onlyTheProductsWithCorrectStyleShouldAppear() {
        boolean isCorrectStyle = false;
        if (categoryPage.getCurrentURL().contains("styles-")) isCorrectStyle = true;
        return isCorrectStyle;
    }

    @When("I select a size s")
    public void iSelectASizeS() {
        categoryPage.selectSize("s");
    }

    @When("I select a size m")
    public void iSelectASizeM() {
        categoryPage.selectSize("m");
    }

    @When("I select a size l")
    public void iSelectASizeL() {
        categoryPage.selectSize("l");
    }

    @Then("Only the products with correct size should appear")
    public boolean onlyTheProductsWithCorrectSizeShouldAppear() {
        boolean isCorrectSize = false;
        if (categoryPage.getCurrentURL().contains("size-")) isCorrectSize = true;
        return isCorrectSize;
    }

    @When("I select category tops")
    public void iSelectCategoryTops() {
        categoryPage.selectCategory("tops");
    }

    @When("I select category dresses")
    public void iSelectCategoryDresses() {
        categoryPage.selectCategory("dresses");
    }

    @Then("Only the products from correct category should appear")
    public boolean onlyTheProductsFromCorrectCategoryShouldAppear() {
        boolean isCorrectCategory = false;
        if (categoryPage.getCurrentURL().contains("categories-")) isCorrectCategory = true;
        return isCorrectCategory;
    }

    @When("I select property colourful dress")
    public void iSelectPropertyColourfulDress() {
        categoryPage.selectProperties("colourful dress");
    }

    @When("I select property midi dress")
    public void iSelectPropertyMidiDress() {
        categoryPage.selectProperties("midi dress");
    }

    @When("I select property short sleeve")
    public void iSelectPropertyShortSleeve() {
        categoryPage.selectProperties("short sleeve");
    }

    @When("I select property maxi dress")
    public void iSelectPropertyMaxiDress() {
        categoryPage.selectProperties("maxi dress");
    }

    @When("I select property short dress")
    public void iSelectPropertyShortDress() {
        categoryPage.selectProperties("short dress");
    }

    @Then("only the products with selected property should appear")
    public boolean onlyTheProductsWithSelectedPropertyShouldAppear() {
        boolean isPropertySelected = false;
        if (categoryPage.getCurrentURL().contains("properties-")) isPropertySelected = true;
        return isPropertySelected;
    }

    @When("I select in stock option")
    public void iSelectInStockOption() {
        categoryPage.selectAvailability("in stock");
    }

    @Then("only products in stock should appear")
    public boolean onlyProductsInStockShouldAppear() {
        boolean isInStockSelected = false;
        if (categoryPage.getCurrentURL().contains("availability-in_stock")) isInStockSelected = true;
        return isInStockSelected;
    }

    @When("I select the manufacturer")
    public void iSelectTheManufacturer() {
        categoryPage.selectManufacturer("fashion manufacturer");
    }

    @Then("only products from the manufacturer should appear")
    public boolean onlyProductsFromTheManufacturerShouldAppear() {
        boolean isManufacturerSelected = false;
        if (categoryPage.getCurrentURL().contains("manufacturer-")) isManufacturerSelected = true;
        return isManufacturerSelected;
    }

    @When("I select the condition new")
    public void iSelectTheConditionNew() {
        categoryPage.selectCondition("new");
    }

    @Then("only products with condition new should appear")
    public boolean onlyProductsWithConditionNewShouldAppear() {
        boolean isConditionNewSelected = false;
        if (categoryPage.getCurrentURL().contains("condition-new")) isConditionNewSelected = true;
        return isConditionNewSelected;
    }
}