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
    public static DigitalDownloadObject getDigitalDownloadObject(WebDriver driver){
        return new DigitalDownloadObject(driver);
    }
    public static ShoppingCartObject getShoppingCartObject(WebDriver driver){
        return new ShoppingCartObject(driver);
    }
    public static CheckoutObject getCheckoutObject(WebDriver driver){
        return new CheckoutObject(driver);
    }
    public static CheckoutCompleteObject getCheckoutObjectComplete(WebDriver driver){
        return new CheckoutCompleteObject(driver);
    }
    public static ProductDetailObject getProductDetailObject(WebDriver driver){
        return new ProductDetailObject(driver);
    }
}
