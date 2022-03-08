package org.carefulchameleons.stepdefs;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.carefulchameleons.pom.myaccounts.MyAccountPage;

public class MyAccountStepdefs {
    private static WebDriver webDriver;
    private MyAccountPage myAccountPage = new MyAccountPage(webDriver);

    @Given("I am on my account page")
    public boolean iAmOnMyAccountPage() {
        boolean myAccountPageOpen = false;
        webDriver.navigate().to("http://automationpractice.com/index.php?controller=my-account");
        if (webDriver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account")) myAccountPageOpen = true;
        return myAccountPageOpen;
    }

    @When("I click the Sign out link")
    public void iClickTheSignOutLink() {
        //myAccountPage.clickSignoutLink();
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
        myAccountPage.goToMyWishListPage();
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
        //clickity click Back to your account.
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

    }

    @Then("The page to add new address should open")
    public void thePageToAddNewAddressShouldOpen() {
    }

    @When("I click the Delete button")
    public void iClickTheDeleteButton() {
    }

    @And("I confirm the deletion")
    public void iConfirmTheDeletion() {
    }

    @Then("The address should be deleted")
    public void theAddressShouldBeDeleted() {
    }

    @When("I click the Update button")
    public void iClickTheUpdateButton() {
    }

    @Then("The page to update the address should open")
    public void thePageToUpdateTheAddressShouldOpen() {
    }

    @Given("I am on the update address page")
    public void iAmOnTheUpdateAddressPage() {
    }

    @When("I edit the fields")
    public void iEditTheFields() {
    }

    @And("click the button Save")
    public void clickTheButtonSave() {
    }

    @Then("the address should be updated")
    public void theAddressShouldBeUpdated() {
    }

    @Given("I am on My Personal Information page")
    public void iAmOnMyPersonalInformationPage() {
        myAccountPage.goToMyPersonalInfoPage();
    }

    @When("I edit the first name field")
    public void iEditTheFirstNameField() {
    }

    @And("I click the button Save")
    public void iClickTheButtonSave() {
    }

    @Then("the first name should be updated")
    public void theFirstNameShouldBeUpdated() {
    }

    @When("I edit the last name field")
    public void iEditTheLastNameField() {
    }

    @Then("the last name should be updated")
    public void theLastNameShouldBeUpdated() {
    }

    @When("I edit the email address field")
    public void iEditTheEmailAddressField() {
    }

    @Then("the email address should be updated")
    public void theEmailAddressShouldBeUpdated() {
    }

    @When("I edit the email address field with an invalid value")
    public void iEditTheEmailAddressFieldWithAnInvalidValue() {
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
    }

    @When("I fill the new password field")
    public void iFillTheNewPasswordField() {
    }

    @And("the confirmation password field with the same password")
    public void theConfirmationPasswordFieldWithTheSamePassword() {
    }

    @Then("the password should be updated")
    public void thePasswordShouldBeUpdated() {
    }

    @And("the confirmation password field with different password")
    public void theConfirmationPasswordFieldWithDifferentPassword() {
    }

    @Then("the error The password and confirmation do not match. should be displayed")
    public void theErrorThePasswordAndConfirmationDoNotMatchShouldBeDisplayed() {
    }

    @Given("I am on My Wishlist page")
    public void iAmOnMyWishlistPage() {
        myAccountPage.goToMyWishListPage();
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
    }

    @Then("the order details should load")
    public void theOrderDetailsShouldLoad() {
    }

    @And("the order details are loaded")
    public void theOrderDetailsAreLoaded() {
    }

    @When("I click on the Invoice link")
    public void iClickOnTheInvoiceLink() {
    }

    @Then("the invoice pdf should open")
    public void theInvoicePdfShouldOpen() {
    }
}
