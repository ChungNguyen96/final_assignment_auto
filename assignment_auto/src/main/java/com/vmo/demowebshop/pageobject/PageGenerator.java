package com.vmo.demowebshop.pageobject;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static LoginPageObject getLoginPageObject(WebDriver driver){
        return new LoginPageObject(driver);
    }
    public static ListBookPageObject getListBookPageObject(WebDriver driver){
        return  new ListBookPageObject(driver);
    }
    public static HomepageObject getHomepageObject(WebDriver driver){
        return new HomepageObject(driver);
    }
}
