package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.SearchPage;
import org.carefulchameleons.webdrivers.WebDriverFactory;
import org.carefulchameleons.webdrivers.model.WebDriverManager;
import org.carefulchameleons.webdrivers.model.WebDriverType;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SearchStepdefs {

    private static WebDriver webDriver;
    private  static WebDriverManager driverManager;
    private IndexPage indexPage;
    private SearchPage searchPage;

    @Before("@search")
    public void setUp() {
        driverManager = WebDriverFactory.getManager(WebDriverType.CHROME);
        webDriver = driverManager.getDriver();
        webDriver.get("http://automationpractice.com/index.php");
    }

    @Given("I am on the Index page")
    public void iAmOnTheIndexPage() {
    }

    @When("I enter the word {string}")
    public void iEnterTheWord(String searchInput) {
        indexPage = new IndexPage(webDriver);
        indexPage.doSearch(searchInput);
    }

    @And("I click on search button")
    public void iClickOnSearchButton() {
        indexPage.getPageHeader().clickSearchButton();
    }

    @Then("I will see the number of results equal to {string}")
    public void iWillSeeTheNumberOfResultsEqualTo(String expectedResult) {
        searchPage = new SearchPage(webDriver, "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=Printed+dress&submit_search=");
        Assertions.assertTrue(searchPage.getTextOfNumberOfSearchResults().contains(expectedResult)); //?
    }

    @And("I will see that total number of items displayed is equal to the {string}")
    public void iWillSeeThatTotalNumberOfItemsDisplayedIsEqualToThe(String expectedValue) {
        Assertions.assertEquals(Integer.parseInt(expectedValue), searchPage.getNumberOfItemsInSearchResults() - 1);
    }

    @And("I can see numbers of results equals to {string}")
    public void iCanSeeNumbersOfResultsEqualsTo(String expectedResult) {
        searchPage = new SearchPage(webDriver, "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=Printed+dress&submit_search=");
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assertions.assertTrue(searchPage.getTextOfNumberOfSearchResults().contains(expectedResult));
    }

    @And("I click on the dropdown Sort by")
    public void iClickOnTheDropdownSortBy() {
    }

    @And("I click on {string}")
    public void iClickOn(String sortBy) {
        searchPage.sortByGivenChoice(sortBy);
    }

    @Then("I will see that results are correctly sorted by {string}")
    public void iWillSeeThatResultsAreCorrectlySortedBy(String sorted) {
        Assertions.assertEquals(sorted, searchPage.getSelectedSortByAsString());
    }

    @After("@search")
    public static void tearDown() {
        if (webDriver != null) {
            driverManager.quitDriver();
            System.out.println("tearDown searchPage");
        }
    }
}
