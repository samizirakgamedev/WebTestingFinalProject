package org.carefulchameleons.pageelements;

import org.carefulchameleons.pom.IndexPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoButton {
    private WebDriver webDriver;
    private By logoButton;
    public LogoButton(WebDriver webDriver){
        this.webDriver = webDriver;
        logoButton = By.className("logo");
    }

    public IndexPage click(){
        webDriver.findElement(logoButton).click();
        return new IndexPage(webDriver);
    }



}
