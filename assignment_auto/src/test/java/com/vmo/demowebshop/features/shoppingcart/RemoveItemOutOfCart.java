package com.vmo.demowebshop.features.shoppingcart;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.pageobject.HomepageObject;
import com.vmo.demowebshop.pageobject.PageGenerator;
import com.vmo.demowebshop.pageobject.ProductDetailObject;
import com.vmo.demowebshop.pageobject.ShoppingCartObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Locale;


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
        Log.allure("Verify display homepage.");
        homepageObject.setQuantity();
        for (int i = 0; i < 3; i++) {
            homepageObject.clickItemToCart();
            verifyTrue(homepageObject.isDisplayMsgAddToCart());
            Log.allure("Verify display message add to cart successfully");
            homepageObject.clickCloseBarNotification();
            verifyTrue(homepageObject.verifyQuantity(homepageObject.getQuantityDisplayIncart()));
            Log.allure("Verify quantity in cart.");
        }

        homepageObject.clickToShoppingCart();
        shoppingCartObject = PageGenerator.getShoppingCartObject(driver);
        verifyTrue(shoppingCartObject.isShoppingCartScreen());
        shoppingCartObject.decreaseQuantity();
        shoppingCartObject.setQuantity();
        shoppingCartObject.clickUpdateCart();
        verifyTrue(shoppingCartObject.verifyQuantity(shoppingCartObject.getQuantityDisplayIncart()));
        Log.allure("Verify quantity is descrease.");
    }
    @AfterClass
    public void teardown() {
        cleanBrowserAndDriver();

    }
}
