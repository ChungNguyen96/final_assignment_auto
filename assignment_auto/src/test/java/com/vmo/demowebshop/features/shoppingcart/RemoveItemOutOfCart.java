package com.vmo.demowebshop.features.shoppingcart;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.pageobject.HomepageObject;
import com.vmo.demowebshop.pageobject.PageGenerator;
import com.vmo.demowebshop.pageobject.ProductDetailObject;
import com.vmo.demowebshop.pageobject.ShoppingCartObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class RemoveItemOutOfCart extends BaseTest {
    private WebDriver driver;
    private HomepageObject homepageObject;
    private ProductDetailObject productDetailObject;
    private ShoppingCartObject shoppingCartObject;


    @BeforeClass
    @Parameters({"browser"})
    public void setup(String browser) {
        driver = getDriverBrower(browser);
    }

    @Test
    public void TC03_RemoveItemOutCart() {
        homepageObject = PageGenerator.getHomepageObject(driver);
        homepageObject.enterURL();
        verifyTrue(homepageObject.isCorrectHomepage());
        homepageObject.setQuantity();
        for (int i = 0; i < 3; i++) {
            homepageObject.clickItemToCart();
            verifyTrue(homepageObject.isDisplayMsgAddToCart());
            homepageObject.clickCloseBarNotification();
            verifyTrue(homepageObject.verifyQuantity(homepageObject.getQuantityDisplayIncart()));
        }

        homepageObject.clickToShoppingCart();
        shoppingCartObject = PageGenerator.getShoppingCartObject(driver);
        verifyTrue(shoppingCartObject.isShoppingCartScreen());
        shoppingCartObject.decreaseQuantity();

    }
//    @AfterClass
//    public void teardown() {
//        cleanBrowserAndDriver();
//
//    }
}
