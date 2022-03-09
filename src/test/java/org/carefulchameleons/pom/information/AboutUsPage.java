package org.carefulchameleons.pom.information;

import org.carefulchameleons.pageelements.CategoryMenu;
import org.carefulchameleons.pom.Page;
import org.carefulchameleons.pom.PageFooter;
import org.carefulchameleons.pom.PageHeader;
import org.openqa.selenium.WebDriver;

public class AboutUsPage extends Page {
    private WebDriver webDriver;
    public AboutUsPage(WebDriver webDriver){
        super(webDriver, "");
    }

    @Override
    public PageFooter getPageFooter() {
        return super.getPageFooter();
    }

    CategoryMenu categoryMenu(){
        return new CategoryMenu(webDriver);
    }
}
