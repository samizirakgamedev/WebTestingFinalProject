package org.carefulchameleons.pom.cart;

import org.carefulchameleons.pom.Page;
import org.openqa.selenium.WebDriver;

public class CartPage extends Page {
    public CartPage(WebDriver webDriver, String expected_url) {
        super(webDriver, expected_url);
    }
}
