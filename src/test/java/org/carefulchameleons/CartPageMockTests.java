package org.carefulchameleons;

import org.carefulchameleons.pom.cart.CartPage;
import org.carefulchameleons.pom.cart.CartSummaryPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.mockito.Mockito.*;

public class CartPageMockTests {
    private static CartPage cartPage;
    private static WebDriver mockWebDriver;
    private static WebElement mockWebElement;

    @BeforeAll
    public static void setupAll(){
        mockWebDriver = Mockito.mock(WebDriver.class);
        mockWebElement = Mockito.mock(WebElement.class);
    }

    @Test
    public void assertElementName() {
        when(mockWebDriver.findElement(By.id("cart_title"))).thenReturn(mockWebElement);
        when(mockWebElement.getText()).thenReturn("SHOPPING-CART SUMMARY");
        cartPage = new CartSummaryPage(mockWebDriver);
        Assertions.assertEquals(cartPage.getCartTitle(), "SHOPPING-CART SUMMARY");
    }

    @Test
    public void checkHomeButton(){
        when(mockWebDriver.findElement(By.className("home"))).thenReturn(mockWebElement);
        doNothing().when(mockWebElement).click();
        cartPage = new CartSummaryPage(mockWebDriver);
        Assertions.assertNotNull(cartPage.clickHomeButton());
    }

    @Test
    public void checkSummaryButton(){
        when(mockWebDriver.findElement(By.className("first"))).thenReturn(mockWebElement);
        doNothing().when(mockWebElement).click();
        cartPage = new CartSummaryPage(mockWebDriver);
        Assertions.assertNotNull(cartPage.clickSummaryButton());
    }

    @Test
    public void checkSignInButton(){
        when(mockWebDriver.findElement(By.className("second"))).thenReturn(mockWebElement);
        doNothing().when(mockWebElement).click();
        cartPage = new CartSummaryPage(mockWebDriver);
        Assertions.assertNotNull(cartPage.clickSignInButton());
    }

    @Test
    public void checkAddressButton(){
        when(mockWebDriver.findElement(By.className("third"))).thenReturn(mockWebElement);
        doNothing().when(mockWebElement).click();
        cartPage = new CartSummaryPage(mockWebDriver);
        Assertions.assertNotNull(cartPage.clickAddressButton());
    }

    @Test
    public void checkShippingButton(){
        when(mockWebDriver.findElement(By.className("four"))).thenReturn(mockWebElement);
        doNothing().when(mockWebElement).click();
        cartPage = new CartSummaryPage(mockWebDriver);
        Assertions.assertNotNull(cartPage.clickShippingButton());
    }

    @Test
    public void checkPaymentButton(){
        when(mockWebDriver.findElement(By.className("last"))).thenReturn(mockWebElement);
        doNothing().when(mockWebElement).click();
        cartPage = new CartSummaryPage(mockWebDriver);
        Assertions.assertNotNull(cartPage.clickPaymentButton());
    }
}
