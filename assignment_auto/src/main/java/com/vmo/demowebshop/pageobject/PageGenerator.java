package com.vmo.demowebshop.pageobject;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static LoginPageObject getLoginPageObject(WebDriver driver){
        return new LoginPageObject(driver);
    }
}
