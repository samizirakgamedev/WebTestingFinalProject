package org.carefulchameleons.stepdefs;
import org.carefulchameleons.pom.myaccounts.MyPersonalInfoPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pom.myaccounts.MyAccountPage;
import org.carefulchameleons.pom.myaccounts.AddressDetailsPage;
import org.carefulchameleons.pom.myaccounts.MyOrderHistoryPage;
import org.carefulchameleons.pom.myaccounts.MyAddressPage;

public class MyAccountStepdefs {

    private static WebDriver webDriver;

    private MyAccountPage myAccountPage = new MyAccountPage(webDriver);
    private AddressDetailsPage addressDetailsPage = new AddressDetailsPage(webDriver);
    private MyOrderHistoryPage myOrderHistoryPage = new MyOrderHistoryPage(webDriver);
    private MyPersonalInfoPage myPersonalInfoPage = new MyPersonalInfoPage(webDriver);
    private MyAddressPage myAddressPage = new MyAddressPage(webDriver);

    @Given("I am on my account page")
    public boolean iAmOnMyAccountPage() {
        boolean myAccountPageOpen = false;
        webDriver.navigate().to("http://automationpractice.com/index.php?controller=my-account");
        if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account")) myAccountPageOpen = true;
        return myAccountPageOpen;
    }

    @When("I click the Sign out link")
    public void iClickTheSignOutLink() {
        myAccountPage.getPageHeader().clickSignOutButton();
    }

    @And("The registration page opens")
    public boolean theRegistrationPageOpens() {
        boolean registrationPageOpen = false;
        if (webDriver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=authentication")) registrationPageOpen = true;
        return registrationPageOpen;
    }

    @And("I click back on my browser")
    public void iClickBackOnMyBrowser() {
        webDriver.navigate().back();
    }

    @And("I click any link")
    public void iClickAnyLink() {
        //clickity click
        myAccountPage.goToMyOrderHistoryPage();
    }

    @Then("I should see the authentication form")
    public boolean iShouldSeeTheAuthenticationForm() {
        boolean authenticationPresent = false;
        if (webDriver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=authentication")) authenticationPresent = true;
        return authenticationPresent;
    }

    @When("I click on the Order History And Details button")
    public void iClickOnTheOrderHistoryAndDetailsButton() {
        myAccountPage.goToMyOrderHistoryPage();
    }

    @Then("The Order History And Details page should open")
    public boolean theOrderHistoryAndDetailsPageShouldOpen() {
        boolean orderHistoryPageOpen = false;
        if (webDriver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=history")) orderHistoryPageOpen = true;
        return orderHistoryPageOpen;
    }

    @When("I click on the Credit Slips button")
    public void iClickOnTheCreditSlipsButton() {
        myAccountPage.goToMyCreditSlipsPage();
    }

    @Then("The Credit Slips page should open")
    public boolean theCreditSlipsPageShouldOpen() {
        boolean creditSlipsPageOpen = false;
        if (webDriver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=order-slip")) creditSlipsPageOpen = true;
        return creditSlipsPageOpen;
    }

    @When("I click on the My Addresses button")
    public void iClickOnTheMyAddressesButton() {
        myAccountPage.goToMyAddressesPage();
    }

    @Then("The My Addresses page should open")
    public boolean theMyAddressesPageShouldOpen() {
        boolean myAddressPageOpen = false;
        if (webDriver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=addresses")) myAddressPageOpen = true;
        return myAddressPageOpen;
    }

    @When("I click on the My Personal Information button")
    public void iClickOnTheMyPersonalInformationButton() {
        myAccountPage.goToMyPersonalInfoPage();
    }

    @Then("The My Personal Information page should open")
    public boolean theMyPersonalInformationPageShouldOpen() {
        boolean myPersonalInfoOpen = false;
        if (webDriver.getCurrentUrl().contains("http://automationpractice.com/index.php?controller=identity")) myPersonalInfoOpen = true;
        return myPersonalInfoOpen;
    }

    @When("I click on the My Wishlist button")
    public void iClickOnTheMyWishlistButton() {
        myAccountPage.goToMyWishListsPage();
    }

    @Then("The My Wishlist page should open")
    public boolean theMyWishlistPageShouldOpen() {
        boolean myWishlistOpen = false;
        if (webDriver.getCurrentUrl().contains("http://automationpractice.com/index.php?fc=module&module=blockwishlist")) myWishlistOpen = true;
        return myWishlistOpen;
    }

    @Given("I am on Order History page")
    public void iAmOnOrderHistoryPage() {
        myAccountPage.goToMyOrderHistoryPage();
    }

    @When("I click the Back to your account. button")
    public void iClickTheBackToYourAccountButton() {
        myOrderHistoryPage.clickTopNavigationMyAccount();
    }

    @Then("I should be on My Account page")
    public boolean iShouldBeOnMyAccountPage() {
        boolean myAccountPageOpen = false;
        if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account")) myAccountPageOpen = true;
        return myAccountPageOpen;
    }

    @Given("I am on My Addresses page")
    public void iAmOnMyAddressesPage() {
        myAccountPage.goToMyAddressesPage();
    }

    @When("I click the Add a new address button")
    public void iClickTheAddANewAddressButton() {
        myAddressPage.addNewAddressDetails();
    }

    @Then("The page to add new address should open")
    public boolean thePageToAddNewAddressShouldOpen() {
        boolean pageToAddNewAddress = false;
        if (webDriver.getPageSource().contains("To add a new address, please fill out the form below.")) pageToAddNewAddress = true;
        return pageToAddNewAddress;
    }

    @When("I click the Delete button")
    public void iClickTheDeleteButton() {
        // index is the address you want to delete out of all the addresses
        myAddressPage.deleteAddress(0);
    }

    @And("I confirm the deletion")
    public void iConfirmTheDeletion() {
        // index is the address you want to delete out of all the addresses
        myAddressPage.confirmDeleteAddress(0);
    }

    @Then("The address should be deleted")
    public void theAddressShouldBeDeleted() {
        // use the expect amount of addresses you want to see
        Assertions.assertEquals(0, myAddressPage.getAddressSize());
    }

    @When("I click the Update button")
    public void iClickTheUpdateButton() {
        myAddressPage.updateAddressDetails(0);
    }

    @Then("The page to update the address should open")
    public boolean thePageToUpdateTheAddressShouldOpen() {
        boolean updateAdressOpen = false;
        if (webDriver.getPageSource().contains("Modify address \"My address\"")) updateAdressOpen = true;
        return updateAdressOpen;
    }

    @Given("I am on the update address page")
    public boolean iAmOnTheUpdateAddressPage() {
        boolean updateAdressOpen = false;
        if (webDriver.getPageSource().contains("Modify address \"My address\"")) updateAdressOpen = true;
        return updateAdressOpen;
    }

    @When("I edit the fields")
    public void iEditTheFields() {
        addressDetailsPage.inputFirstName("test");
        addressDetailsPage.inputLastName("test");
        addressDetailsPage.inputAddressOne("1, test street");
        addressDetailsPage.inputCity("testCity");
        addressDetailsPage.chooseStateByName("Florida");
        addressDetailsPage.inputZipCode("12345");
        addressDetailsPage.chooseCountryByName("United States");
        addressDetailsPage.inputMobilePhone("12345678");
        addressDetailsPage.inputAddressAlias("my test address");
    }

    @And("click the button Save")
    public void clickTheButtonSave() {
        addressDetailsPage.clickSaveButton();
    }

    @Then("the address should be updated")
    public boolean theAddressShouldBeUpdated() {
        boolean addressIsUpdated = false;
        if (addressDetailsPage.getFIRST_NAME().equals("test") && addressDetailsPage.getLAST_NAME().equals("test") && addressDetailsPage.getAddressOne().equals("1, test street") &&
        addressDetailsPage.getCITY().equals("testCity") && addressDetailsPage.getZIP_CODE().equals("12345") && addressDetailsPage.getMOBILE_PHONE().equals("12345678")) addressIsUpdated = true;
        return addressIsUpdated;
    }

    @Given("I am on My Personal Information page")
    public void iAmOnMyPersonalInformationPage() {
        myAccountPage.goToMyPersonalInfoPage();
    }

    @When("I edit the first name field")
    public void iEditTheFirstNameField() {
        myPersonalInfoPage.enterTextInFirstNameTextBox("test");
    }

    @And("I click the button Save")
    public void iClickTheButtonSave() {
        myPersonalInfoPage.clickSaveButton();
    }

    @Then("the first name should be updated")
    public boolean theFirstNameShouldBeUpdated() {
        boolean firstNameUpdated = false;
        //if (myPersonalInfoPage.getFIRST_NAME().equals("test")) firstNameUpdated = true;
        return firstNameUpdated;
    }

    @When("I edit the last name field")
    public void iEditTheLastNameField() {
        myPersonalInfoPage.enterTextInLastNameTextBox("test");
    }

    @Then("the last name should be updated")
    public boolean theLastNameShouldBeUpdated() {
        boolean lastNameUpdated = false;
        //if (myPersonalInfoPage.getLAST_NAME().equals("test")) lastNameUpdated = true;
        return lastNameUpdated;
    }

    @When("I edit the email address field")
    public void iEditTheEmailAddressField() {
        myPersonalInfoPage.enterTextInEmailTextBox("test@test.com");
    }

    @Then("the email address should be updated")
    public boolean theEmailAddressShouldBeUpdated() {
        boolean emailAddressUpdated = false;
        //if (myPersonalInfoPage.getEmail().equals("test@test.com")) emailAddressUpdated = true;
        return emailAddressUpdated;
    }

    @When("I edit the email address field with an invalid value")
    public void iEditTheEmailAddressFieldWithAnInvalidValue() {
        myPersonalInfoPage.enterTextInEmailTextBox("test@test");
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        //locator for error message
    }

    @When("I fill the new password field")
    public void iFillTheNewPasswordField() {
        myPersonalInfoPage.enterTextInNewPasswordTextBox("1234test");
    }

    @And("the confirmation password field with the same password")
    public void theConfirmationPasswordFieldWithTheSamePassword() {
        myPersonalInfoPage.enterTextInConfirmPasswordTextBox("1234test");
    }

    @Then("the password should be updated")
    public void thePasswordShouldBeUpdated() {
        //not a clue
    }

    @And("the confirmation password field with different password")
    public void theConfirmationPasswordFieldWithDifferentPassword() {
        myPersonalInfoPage.enterTextInConfirmPasswordTextBox("12test34");
    }

    @Then("the error The password and confirmation do not match. should be displayed")
    public void theErrorThePasswordAndConfirmationDoNotMatchShouldBeDisplayed() {
        //locator for error message
    }

    @Given("I am on My Wishlist page")
    public void iAmOnMyWishlistPage() {
        myAccountPage.goToMyWishListsPage();
    }

    @When("I fill the name field for my wishlist")
    public void iFillTheNameFieldForMyWishlist() {
    }

    @Then("the wishlist should be created")
    public void theWishlistShouldBeCreated() {
    }

    @When("I click the delete button next to my wishlist")
    public void iClickTheDeleteButtonNextToMyWishlist() {
    }

    @Then("the wishlist should be deleted")
    public void theWishlistShouldBeDeleted() {
    }

    @When("I click on the wishlist name")
    public void iClickOnTheWishlistName() {
    }

    @Then("the content of my wishlist should be loaded")
    public void theContentOfMyWishlistShouldBeLoaded() {
    }

    @And("the content of my wishlist is loaded")
    public void theContentOfMyWishlistIsLoaded() {
    }

    @When("I click on the delete button next to the item's name")
    public void iClickOnTheDeleteButtonNextToTheItemSName() {
    }

    @Then("the item should be removed from my wishlist")
    public void theItemShouldBeRemovedFromMyWishlist() {
    }

    @Given("I am on the Order History page")
    public void iAmOnTheOrderHistoryPage() {
        myAccountPage.goToMyOrderHistoryPage();
    }

    @When("I click on Order Reference link")
    public void iClickOnOrderReferenceLink() {
        myOrderHistoryPage.clickDetailsButton();
    }

    @Then("the order details should load")
    public boolean theOrderDetailsShouldLoad() {
        boolean orderDetailsLoaded = false;
        if (webDriver.findElement(By.id("order-list")) == null); //not a clue if it works
        return orderDetailsLoaded;
    }

    @And("the order details are loaded")
    public boolean theOrderDetailsAreLoaded() {
        boolean orderDetailsLoaded = false;
        if (webDriver.findElement(By.id("order-list")) == null); //not a clue if it works
        return orderDetailsLoaded;
    }

    @When("I click on the Invoice link")
    public void iClickOnTheInvoiceLink() {
        webDriver.findElement(By.linkText("PDF")).click();
    }

    @Then("the invoice pdf should open")
    public void theInvoicePdfShouldOpen() {
        //it's actually downloading for me
    }

}
