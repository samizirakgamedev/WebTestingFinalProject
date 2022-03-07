package org.carefulchameleons.pom.cart;

import org.carefulchameleons.pom.myaccounts.SignInPage;
import org.openqa.selenium.WebDriver;

public class CartSingInPage extends SignInPage {
    public CartSingInPage(WebDriver webDriver){
        super(webDriver, "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0");
    }
}
