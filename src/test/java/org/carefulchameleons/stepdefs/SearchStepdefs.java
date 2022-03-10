package org.carefulchameleons.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pom.IndexPage;
import org.carefulchameleons.pom.SearchPage;
import org.carefulchameleons.pom.information.FashionSupplierPage;
import org.carefulchameleons.pom.information.OurStores;
import org.carefulchameleons.pom.myaccounts.MyAccountPage;
import org.carefulchameleons.pom.myaccounts.SignInPage;
import org.carefulchameleons.webdrivers.WebDriverFactory;
import org.carefulchameleons.webdrivers.model.WebDriverManager;
import org.carefulchameleons.webdrivers.model.WebDriverType;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class SearchStepdefs {

    private static WebDriver webDriver;
    private  static WebDriverManager driverManager;
    private IndexPage indexPage;
    private SignInPage signInPage;
    private MyAccountPage myAccountPage;
    private SearchPage searchPage;
    private OurStores ourStores;
    private FashionSupplierPage fashionSupplierPage;

    @Before("@search")
    public void setUp() {
        driverManager = WebDriverFactory.getManager(WebDriverType.CHROME);
        webDriver = driverManager.getDriver();
        webDriver.get("http://automationpractice.com/index.php");
    }

    @After("@search")
    public static void tearDown() {
        if (webDriver != null) {
            driverManager.quitDriver();
            System.out.println("tearDown searchPage");
        }
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
        //Assertions.assertEquals(expectedResult, searchPage.getTheNumberOfResultsFound().toString());
    }

    //opt
    @And("I will see that every result which have been found will contain the word {string}")
    public void iWillSeeThatEveryResultWhichHaveBeenFoundWillContainTheWord(String searchInput) {
        //Assertions.assertTrue(??.contains(searchInput)); Need this method
    }

    @And("I can see numbers of results equals to {string}")
    public void iCanSeeNumbersOfResultsEqualsTo(String expectedResult) {
        searchPage = new SearchPage(webDriver, "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=Printed+dress&submit_search=");
        //Assertions.assertEquals(expectedResult, searchPage.getTheNumberOfResultsFound().toString());
    }

    @And("I click on the dropdown Sort by")
    public void iClickOnTheDropdownSortBy() {
        //searchPage.clickOnSortBy(); Need this method
    }

    @And("I click on {string}")
    public void iClickOn(String sortBy) {
        //searchPage.click(sortBy); Need this method ?make a sort choosing/selector method in the search page?
    }

    @Then("I will see that results are correctly sorted by {string}")
    public void iWillSeeThatResultsAreCorrectlySortedBy(String sorted) {
        //Assertions.assertEquals(sorted, searchPage.getDropdownText()); Need this method
    }

    @When("I enter any word in the search bar")
    public void iEnterAnyWordInTheSearchBar() {
        indexPage = new IndexPage(webDriver);
        indexPage.doSearch("1234");
    }

    @And("I click on black Discover our stores button")
    public void iClickOnBlackDiscoverOurStoresButton() {
        //searchPage.clickDiscoverOurStoresButton(); Need this method
    }

    @Then("I will go to the Our stores page")
    public void iWillGoToTheOurStoresPage() {
        ourStores = new OurStores(webDriver);
        Assertions.assertEquals("http://automationpractice.com/index.php?controller=stores", ourStores.getCurrentURL());
    }

    //opt
    @And("I click on Fashion Supplier button")
    public void iClickOnFashionSupplierButton() {
        //searchPage.clickFashionSupplierButton(); Need this method
    }

    @Then("I will go to the Fashion Supplier page")
    public void iWillGoToTheFashionSupplierPage() {
       fashionSupplierPage = new FashionSupplierPage(webDriver);
        Assertions.assertEquals("http://automationpractice.com/index.php?id_supplier=1&controller=supplier", fashionSupplierPage.getCurrentURL());
    }

}
