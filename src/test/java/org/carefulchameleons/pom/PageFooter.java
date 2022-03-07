package org.carefulchameleons.pom;

import io.cucumber.java.ro.Si;
import org.carefulchameleons.pom.category.WomenPage;
import org.carefulchameleons.pom.information.*;
import org.carefulchameleons.pom.myaccounts.MyAccountPage;
import org.carefulchameleons.pom.myaccounts.MyAddressPage;
import org.carefulchameleons.pom.myaccounts.MyPersonalInfoPage;
import org.carefulchameleons.pom.myaccounts.OrderHistory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageFooter {

    protected WebDriver webDriver;

    private final By NEWSLETTER_TEXT_BOX = new By.ById("newsletter-input");
    private final By NEWSLETTER_SUBMIT_BUTTON = new By.ByName("submitNewsletter");
    private final By WOMEN_CATEGORY_LINK = new By.ByLinkText("Women");
    private final By SPECIALS_LINK = new By.ByLinkText("Specials");
    private final By NEW_PRODUCTS_LINK = new By.ByLinkText("New products");
    private final By BEST_SELLERS_LINK = new By.ByLinkText("Best sellers");
    private final By OUR_STORES_LINK = new By.ByLinkText("Our stores");
    private final By TERMS_AND_CONDITIONS_LINK = new By.ByLinkText("Terms and conditions of use");
    private final By ABOUT_US_LINK = new By.ByLinkText("About us");
    private final By SITEMAP = new By.ByLinkText("Sitemap");
    private final By MY_ACCOUNT_LINK = new By.ByLinkText("My account");
    private final By MY_ORDERS_LINK = new By.ByLinkText("MY orders");
    private final By MY_ADDRESSES_LINK = new By.ByLinkText("My addresses");
    private final By MY_PERSONAL_INFO = new By.ByLinkText("My Personal info");
    private final By FACEBOOK_ICON = new By.ByLinkText("Facebook");
    private final By TWITTER_ICON = new By.ByLinkText("Twitter");
    private final By YOUTUBE_ICON = new By.ByLinkText("Youtube");
    private final By GOOGLE_ICON = new By.ByLinkText("Google Plus");

    public PageFooter(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterNewsletterEmailAndClickSubmit(String email) {
        webDriver.findElement(NEWSLETTER_TEXT_BOX).sendKeys(email);
        webDriver.findElement(NEWSLETTER_SUBMIT_BUTTON).click();
    }

    public WomenPage goToWomenCategory() {
        webDriver.findElement(WOMEN_CATEGORY_LINK).click();
        return new WomenPage();
        // TODO - Need to update arguments when cart summary page is done
    }

    public SpecialsPage goToSpecials() {
        webDriver.findElement(SPECIALS_LINK).click();
        return new SpecialsPage();
        // TODO - Need to update arguments when specials page is done
    }

    public NewProductsPage goToNewProducts() {
        webDriver.findElement(NEW_PRODUCTS_LINK).click();
        return new NewProductsPage();
        // TODO - Need to update arguments when new products page is done
    }

    public BestSellers goToBestSellers() {
        webDriver.findElement(BEST_SELLERS_LINK).click();
        return new BestSellers();
        // TODO - Need to update arguments when best sellers page is done
    }

    public OurStores goToOurStores() {
        webDriver.findElement(OUR_STORES_LINK).click();
        return new OurStores();
        // TODO - Need to update arguments when our stores page is done
    }

    public TermsAndConditionsPage goToTermsAndConditions(){
        webDriver.findElement(TERMS_AND_CONDITIONS_LINK).click();
        return new TermsAndConditionsPage();
        // TODO - Need to update arguments when terms and conditions page is done
    }

    public AboutUsPage goToAboutUs() {
        webDriver.findElement(ABOUT_US_LINK).click();
        return new AboutUsPage();
        // TODO - Need to update arguments when about us page is done
    }

    public SitemapPage goToSitemap(){
        webDriver.findElement(SITEMAP).click();
        return new SitemapPage();
        // TODO - Need to update arguments when sitemap page is done
    }

    public MyAccountPage goToMyAccount(){
        webDriver.findElement(MY_ACCOUNT_LINK).click();
        return new MyAccountPage();
        // TODO - Need to update arguments when my account page is done
    }

    public OrderHistory goToMyOrders(){
        webDriver.findElement(MY_ORDERS_LINK).click();
        return new OrderHistory();
        // TODO - Need to update arguments when order history page is done
    }

    public MyAddressPage goToMyAddresses(){
        webDriver.findElement(MY_ADDRESSES_LINK).click();
        return new MyAddressPage();
        // TODO - Need to update arguments when my address page is done
    }

    public MyPersonalInfoPage goToMyPersonalInfo(){
        webDriver.findElement(MY_PERSONAL_INFO).click();
        return new MyPersonalInfoPage();
        // TODO - Need to update arguments when my personal info page is done
    }

    public void clickFacebookIcon(){
        webDriver.findElement(FACEBOOK_ICON).click();
    }

    public void clickTwitterIcon(){
        webDriver.findElement(TWITTER_ICON).click();
    }

    public void clickYoutubeIcon(){
        webDriver.findElement(YOUTUBE_ICON).click();
    }

    public void clickGoogleIcon(){
        webDriver.findElement(GOOGLE_ICON).click();
    }
}
