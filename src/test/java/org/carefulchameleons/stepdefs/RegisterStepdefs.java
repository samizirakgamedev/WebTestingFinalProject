package org.carefulchameleons.stepdefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterStepdefs {
    private static WebDriver webDriver;

    @Given("I open the Home Page")
    public void iOpenTheHomePage() {
        webDriver.navigate().to("http://automationpractice.com/");
    }

    @When("I click on Sign in button")
    public void iClickOnSignInButton() {
    }

    @Given("The registration page is open")
    public boolean theRegistrationPageIsOpen() {
        boolean theRegistrationPageOpen = false;
        if (webDriver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=authentication")) theRegistrationPageOpen = true;
        return theRegistrationPageOpen;
    }

    @And("I click the Create an account button")
    public void iClickTheCreateAnAccountButton() {
    }

    @Then("The Create an account page should open")
    public boolean theCreateAnAccountPageShouldOpen() {
        boolean createAccountPageOpen = false;
        if (webDriver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation")) createAccountPageOpen = true;
        return createAccountPageOpen;
    }

    @When("I type an invalid <email> address")
    public void iTypeAnInvalidEmailAddress() {
    }

    @Then("The error An account using this email address has already been registered. should be displayed on the screen")
    public void theErrorMessageShouldBeDisplayed() {
    }

    @When("I type a valid test@test.com email address")
    public void iTypeAValidEmailAddress() {
    }

    @Given("The Create an account page is open")
    public boolean theCreateAnAccountPageIsOpen() {
        boolean createAccountPageOpen = false;
        if (webDriver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation")) createAccountPageOpen = true;
        return createAccountPageOpen;
    }

    @When("I type my test first name")
    public void iTypeMyFirstNameTest() {
    }

    @When("I type my first name")
    public void iTypeMyFirstNameEmpty() {
    }

    @And("I type my test last name")
    public void iTypeMyLastNameTest() {
    }

    @And("I type my last name")
    public void iTypeMyLastNameEmpty() {
    }

    @And("I type my test address")
    public void iTypeMyAddressTest() {
    }

    @And("I type my address")
    public void iTypeMyAddressEmptyt() {
    }

    @And("I type my test city")
    public void iTypeMyCityTest() {
    }

    @And("I type my city")
    public void iTypeMyCityEmptyt() {
    }

    @And("I select my state from the list")
    public void iSelectMyState() {
    }

    @And("I choose my Florida state")
    public void iSelectMyStateFlorida() {
    }

    @And("I choose my state")
    public void iSelectMyStateEmpty() {
    }

    @And("I type my 12345 zipcode")
    public void iTypeMyZipCode() {
    }

    @And("I type my zipcode")
    public void iTypeMyZipCodeEmpty() {
    }

    @And("I type my 12345678 mobile phone")
    public void iTypeMyMobilePhone() {
    }

    @And("I type my mobile phone")
    public void iTypeMyMobilePhoneEmpty() {
    }

    @And("I click the Register button")
    public void iClickTheRegisterButton() {
    }

    @Then("The My Account page should open")
    public boolean theMyAccountPageShouldOpen() {
        boolean myAccountPageOpen = false;
        if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account")) myAccountPageOpen = true;
        return myAccountPageOpen;
    }

    @When("I type my <firstname>")
    public void iTypeMyFirstname() {
    }

    @When("I type a valid email address")
    public void iTypeAValidEmail() {
    }

    @When("I type an invalid test email")
    public void iTypeAnInvalidEmail() {
    }

    @When("I type an invalid email")
    public void iTypeAnInvalidEmptyEmail() {
    }

    @When("I type an invalid test@test email")
    public void iTypeAnInvalidTestAtTestEmail() {
    }

    @When("I type an invalid test.com email")
    public void iTypeAnInvalidTestDotComEmail() {
    }

    @Then("The error Invalid email address. should be displayed")
    public boolean theErrorMessageShouldIsDisplayed() {
        boolean isCorrectError = false;
        //error message: Invalid email address.
        return isCorrectError;
    }

    @Then("The This country requires you to choose a State. message should be displayed")
    public void theErrorMessageCountryShouldBeShown() {
    }

    @Then("The firstname is required. message should be displayed")
    public void theErrorMessageFirstNameShouldBeShown() {
    }

    @Then("The lastname is required. message should be displayed")
    public void theErrorMessageLastNameShouldBeShown() {
    }

    @Then("The address1 is required. message should be displayed")
    public void theErrorMessageAddressShouldBeShown() {
    }

    @Then("The city is required. message should be displayed")
    public void theErrorMessageCityShouldBeShown() {
    }

    @Then("The The Zip/Postal code you've entered is invalid. It must follow this format: 00000 message should be displayed")
    public void theErrorMessageZipCodeShouldBeShown() {
    }

    @Then("The You must register at least one phone number. message should be displayed")
    public void theErrorMessagePhoneNumberShouldBeShown() {
    }
}
