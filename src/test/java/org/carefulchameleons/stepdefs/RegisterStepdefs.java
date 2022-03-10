package org.carefulchameleons.stepdefs;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pom.myaccounts.SignInPage;
import org.carefulchameleons.webdrivers.WebDriverFactory;
import org.carefulchameleons.webdrivers.model.WebDriverManager;
import org.carefulchameleons.webdrivers.model.WebDriverType;
import org.openqa.selenium.WebDriver;
import org.carefulchameleons.pom.myaccounts.RegistrationPage;
import org.carefulchameleons.pom.myaccounts.SignInPage;
import org.carefulchameleons.pom.PageHeader;

public class RegisterStepdefs {
    private  static WebDriverManager driverManager;
    private static WebDriver webDriver;
    private RegistrationPage registrationPage;
    private PageHeader pageHeader;
    private SignInPage signInPage;

    @Given("I open the Home Page")
    public void iOpenTheHomePage() {
        driverManager = WebDriverFactory.getManager(WebDriverType.CHROME);
        webDriver = driverManager.getDriver();
        registrationPage = new RegistrationPage(webDriver);
        pageHeader = new PageHeader(webDriver);
        webDriver.navigate().to("http://automationpractice.com/");
    }

    @When("I click on Sign in button")
    public void iClickOnSignInButton() {
        pageHeader.clickSignInButton();
    }

    @Given("The registration page is open")
    public boolean theRegistrationPageIsOpen() {
        boolean theRegistrationPageOpen = false;
        driverManager = WebDriverFactory.getManager(WebDriverType.CHROME);
        webDriver = driverManager.getDriver();
        registrationPage = new RegistrationPage(webDriver);
        webDriver.navigate().to("http://automationpractice.com/index.php?controller=authentication");
        if (webDriver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=authentication")) theRegistrationPageOpen = true;
        return theRegistrationPageOpen;
    }

    @And("I click the Create an account button")
    public void iClickTheCreateAnAccountButton() {
        signInPage.clickCreateButton();
    }

    @Then("The Create an account page should open")
    public boolean theCreateAnAccountPageShouldOpen() {
        boolean createAccountPageOpen = false;
        if (webDriver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation")) createAccountPageOpen = true;
        return createAccountPageOpen;
    }

    @Then("The error An account using this email address has already been registered. should be displayed on the screen")
    public boolean theErrorMessageShouldBeDisplayed() {
        boolean isEmailError = false;
        if (webDriver.getPageSource().contains("An account using this email address has already been registered.")) isEmailError = true;
        return isEmailError;
    }

    @When("I type a valid test@test.com email address")
    public void iTypeAValidEmailAddress() {
        signInPage = new SignInPage(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
        signInPage.enterCreateEmail("test@test.com");
    }

    @Given("The Create an account page is open")
    public boolean theCreateAnAccountPageIsOpen() throws InterruptedException {
        boolean createAccountPageOpen = false;
        driverManager = WebDriverFactory.getManager(WebDriverType.CHROME);
        webDriver = driverManager.getDriver();
        registrationPage = new RegistrationPage(webDriver);
        webDriver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
        signInPage = new SignInPage(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
        signInPage.enterCreateEmail("test@test.comment");
        signInPage.clickCreateButton();
        Thread.sleep(3000);
        signInPage.clickCreateButton();
        Thread.sleep(3000);
        if (webDriver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation")) createAccountPageOpen = true;
        return createAccountPageOpen;
    }

    @When("I type my test first name")
    public void iTypeMyFirstNameTest() {
        registrationPage.enterTextInFirstNameTextBox("test");
    }

    @When("I type my first name")
    public void iTypeMyFirstNameEmpty() {
        registrationPage.enterTextInFirstNameTextBox("");
    }

    @And("I type my test last name")
    public void iTypeMyLastNameTest() {
        registrationPage.enterTextInLastNameTextBox("test");
    }

    @And("I type my last name")
    public void iTypeMyLastNameEmpty() {
        registrationPage.enterTextInLastNameTextBox("");
    }

    @And("I type my test address")
    public void iTypeMyAddressTest() {
        registrationPage.enterTextInAddressOneTextBox("test");
    }

    @And("I type my address")
    public void iTypeMyAddressEmptyt() {
        registrationPage.enterTextInAddressOneTextBox("");
    }

    @And("I type my test city")
    public void iTypeMyCityTest() {
        registrationPage.enterTextInCityTextBox("test");
    }

    @And("I type my city")
    public void iTypeMyCityEmptyt() {
        registrationPage.enterTextInCityTextBox("");
    }

    @And("I select my state from the list")
    public void iSelectMyState() {
        registrationPage.selectStateAtIndex(8);
    }

    @And("I choose my Florida state")
    public void iSelectMyStateFlorida() {
        registrationPage.selectStateAtIndex(9);
    }

    @And("I choose my state")
    public void iSelectMyStateEmpty() {
        registrationPage.selectStateAtIndex(0);
    }

    @And("I type my 12345 zipcode")
    public void iTypeMyZipCode() {
        registrationPage.enterTextInPostCodeTextBox("12345");
    }

    @And("I type my zipcode")
    public void iTypeMyZipCodeEmpty() {
        registrationPage.enterTextInPostCodeTextBox("");
    }

    @And("I type my 12345678 mobile phone")
    public void iTypeMyMobilePhone() {
        registrationPage.enterTextInMobilePhoneTextBox("12345678");
    }

    @And("I type my mobile phone")
    public void iTypeMyMobilePhoneEmpty() {
        registrationPage.enterTextInMobilePhoneTextBox("");
    }

    @And("I click the Register button")
    public void iClickTheRegisterButton() {
        registrationPage.clickRegisterButton();
    }

    @Then("The My Account page should open")
    public boolean theMyAccountPageShouldOpen() {
        boolean myAccountPageOpen = false;
        if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account")) myAccountPageOpen = true;
        return myAccountPageOpen;
    }

    @When("I type a valid email address")
    public void iTypeAValidEmail() {
        signInPage = new SignInPage(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
        signInPage.enterCreateEmail("test@test.commment");
    }

    @When("I type an invalid test email")
    public void iTypeAnInvalidEmail() {
        signInPage = new SignInPage(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
        signInPage.enterCreateEmail("test");
    }

    @When("I type an invalid email")
    public void i_type_an_invalid_email() {
        signInPage = new SignInPage(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
        signInPage.enterCreateEmail("");
    }

    @When("I type an invalid test@test email")
    public void iTypeAnInvalidTestAtTestEmail() {
        signInPage = new SignInPage(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
        signInPage.enterCreateEmail("test@test");
    }

    @When("I type an invalid test.com email")
    public void iTypeAnInvalidTestDotComEmail() {
        signInPage = new SignInPage(webDriver, "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
        signInPage.enterCreateEmail("test.com");
    }

    @Then("The error Invalid email address. should be displayed")
    public boolean theErrorMessageShouldIsDisplayed() {
        boolean isEmailError = false;
        if (webDriver.getPageSource().contains("Invalid email address.")) isEmailError = true;
        return isEmailError;
    }

    @Then("The This country requires you to choose a State. message should be displayed")
    public boolean theErrorMessageCountryShouldBeShown() {
        return registrationPage.isCountryErrorPresent();
    }

    @Then("The firstname is required. message should be displayed")
    public boolean theErrorMessageFirstNameShouldBeShown() {
        return registrationPage.isFirstNameErrorPresent();
    }

    @Then("The lastname is required. message should be displayed")
    public boolean theErrorMessageLastNameShouldBeShown() {
        return registrationPage.isLastNameErrorPresent();
    }

    @Then("The address1 is required. message should be displayed")
    public boolean theErrorMessageAddressShouldBeShown() {
        return registrationPage.isAddressOneErrorPresent();
    }

    @Then("The city is required. message should be displayed")
    public boolean theErrorMessageCityShouldBeShown() {
        return registrationPage.isCityErrorPresent();
    }

    @Then("The The Zip/Postal code you've entered is invalid. It must follow this format: 00000 message should be displayed")
    public boolean theErrorMessageZipCodeShouldBeShown() {
        return registrationPage.isZipPostCodeErrorPresent();
    }

    @Then("The You must register at least one phone number. message should be displayed")
    public boolean theErrorMessagePhoneNumberShouldBeShown() {
        return registrationPage.isPhoneNumberErrorPresent();
    }

    @After
    public static void tearDown() {
        if(webDriver != null) {
            //driverManager.quitDriver();
            System.out.println("tearDown register");
        }
    }
}
