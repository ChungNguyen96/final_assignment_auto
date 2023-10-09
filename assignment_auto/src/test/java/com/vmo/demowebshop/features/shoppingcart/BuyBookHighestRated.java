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
        homepageObject.clickBookTag();
        listBookPageObject = PageGenerator.getListBookPageObject(driver);
        verifyTrue(listBookPageObject.isDisplayBooksScreen());
        listBookPageObject.setQuantity();
        List<String> listBookHighestRate = listBookPageObject.getBookByRate(2);

        for (int i = 0; i < listBookHighestRate.size(); i++) {
            listBookPageObject.clickBookHighestRate(i, listBookHighestRate);
            Log.allure("Verify increase quantity after click the book %s",String.valueOf(i));
            verifyTrue(listBookPageObject.isDisplayMsgAddToCart());
            System.out.println(listBookPageObject.getQuantity());
            verifyTrue(listBookPageObject.verifyQuantity(listBookPageObject.getQuantityIncart()));
        }
        listBookPageObject.hoverOnCart();
        List<String> listBookIncartExpect = listBookPageObject.getListBookInCart();
        System.out.println(listBookIncartExpect);
        List<String> listBookDisplayIncart = listBookPageObject.getListBookDisplayInCart();
        System.out.println(listBookDisplayIncart);
        verifyTrue(listBookPageObject.compareListBookDisplayInCart(listBookDisplayIncart, listBookIncartExpect));
    }


    @AfterClass
    public void teardown() {
        cleanBrowserAndDriver();
        Log.info("Close driver");
    }
}
