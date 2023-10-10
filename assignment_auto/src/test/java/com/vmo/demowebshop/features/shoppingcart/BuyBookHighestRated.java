package com.vmo.demowebshop.features.shoppingcart;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.pageobject.HomepageObject;
import com.vmo.demowebshop.pageobject.ListBookPageObject;
import com.vmo.demowebshop.pageobject.PageGenerator;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BuyBookHighestRated extends BaseTest {
    private WebDriver driver;
    private HomepageObject homepageObject;
    private ListBookPageObject listBookPageObject;

    @BeforeClass
    @Parameters({"browser"})
    public void setup(String browser) {
        driver = getDriverBrower(browser);
    }

    @Test
    public void TC02_BuyBookHighestRated() {

        homepageObject = PageGenerator.getHomepageObject(driver);
        homepageObject.enterURL();
        verifyTrue(homepageObject.isCorrectHomepage());
        Log.allure("Verify display homepage.");
        homepageObject.clickBookTag();
        listBookPageObject = PageGenerator.getListBookPageObject(driver);
        verifyTrue(listBookPageObject.isDisplayBooksScreen());
        Log.allure("Verify display list book.");
        listBookPageObject.setQuantity();
        Log.allure("Quantity in cart: %s ",String.valueOf(listBookPageObject.getQuantity()));
        List<String> listBookHighestRate = listBookPageObject.getBookByRate(2);
        for (int i = 0; i < listBookHighestRate.size(); i++) {
            listBookPageObject.clickBookHighestRate(i, listBookHighestRate);
            verifyTrue(listBookPageObject.isDisplayMsgAddToCart());
            Log.allure("Verify display message add to cart successfully.");
            listBookPageObject.clickCloseBarNotification();
            verifyTrue(listBookPageObject.verifyQuantity(listBookPageObject.getQuantityIncart()));
            Log.allure("Verify increase quantity after click the book %s",String.valueOf(i));
        }
        listBookPageObject.hoverOnCart();
        List<String> listBookIncartExpect = listBookPageObject.getListBookInCart();
        List<String> listBookDisplayIncart = listBookPageObject.getListBookDisplayInCart();
        verifyTrue(listBookPageObject.compareListBookDisplayInCart(listBookDisplayIncart, listBookIncartExpect));
        Log.allure("Verify added item is display in cart.");
    }


    @AfterClass
    public void teardown() {
        cleanBrowserAndDriver();
        Log.info("Close driver");
    }
}
