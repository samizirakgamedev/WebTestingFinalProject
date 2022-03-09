package org.carefulchameleons.pageelements.leftcoloumelements;

import org.carefulchameleons.pom.information.TermsAndConditionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InformationBlock {
    private WebDriver webDriver;
    private WebElement root;
    private By termsAndConditionsButton = By.linkText("Terms and conditions of use");

    public InformationBlock(WebDriver webDriver, WebElement root){
        this.webDriver = webDriver;
        this.root = root;
    }

    TermsAndConditionsPage clickTermsAndCondition(){
        root.findElement(termsAndConditionsButton).click();
        return new TermsAndConditionsPage(webDriver);
    }
}