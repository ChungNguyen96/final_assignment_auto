package com.vmo.demowebshop.features.shoppingcart;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.pageobject.*;
import com.vmo.demowebshop.utils.DataUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BuyItemSuccessfully extends BaseTest {
    private WebDriver driver;
    private HomepageObject homepageObject;
    private DigitalDownloadObject digitalDownloadObject;
    private ShoppingCartObject shoppingCartObject;
    private CheckoutObject checkoutObject;
    private DataUtils dataUtils;
    @BeforeClass
    @Parameters({"browser"})
    public void setup(String browser) {
        driver = getDriverBrower(browser);
    }
    @Test
    public void TC04_BuyItemSuccessfully(){
        homepageObject = PageGenerator.getHomepageObject(driver);
        homepageObject.enterURL();
        verifyTrue(homepageObject.isCorrectHomepage());
        homepageObject.clickMenuDigitalDownload();
        digitalDownloadObject =PageGenerator.getDigitalDownloadObject(driver);
        verifyTrue(digitalDownloadObject.verifyDigitalDownloadScreen());
        Log.allure("Verify display digital download screen.");
        digitalDownloadObject.clickItemToCart();
        verifyTrue(digitalDownloadObject.isDisplayMsgAddToCart());
        //Step 4: Click shopping cart
        digitalDownloadObject.clickShoppingCart();
        shoppingCartObject = PageGenerator.getShoppingCartObject(driver);
        verifyTrue(shoppingCartObject.isShoppingCartScreen());
        Log.allure("Verify display shopping cart screen.");
       // shoppingCartObject.selectCountry("Viet Nam");
        shoppingCartObject.clickTermService();
        verifyTrue(shoppingCartObject.isClickedTermService());
        shoppingCartObject.clickCheckOut();
        verifyTrue(shoppingCartObject.isDisplayWelcomeSign());
        //step 8: checkout as guest
        shoppingCartObject.clickCheckoutAsGuest();
        checkoutObject = PageGenerator.getCheckoutObject(driver);
        verifyTrue(checkoutObject.isDisplayScreen());
        Log.allure("Verify display checkout screen.");
        Log.allure("Fill billing address.");
        dataUtils = new DataUtils();

        checkoutObject.enterInput("First name",dataUtils.getFirstName());
        checkoutObject.enterInput("Last name",dataUtils.getLastName());
        checkoutObject.enterInput("Email",dataUtils.generateNEmail());
        checkoutObject.enterInput("Company",dataUtils.getCompanyName());
        checkoutObject.enterInput("City",dataUtils.getCityName());
        checkoutObject.enterInput("Address 1",dataUtils.getFirstNameAddress());
        checkoutObject.enterInput("Address 2",dataUtils.getLastNameAddress());
        checkoutObject.enterInput("Zip / postal code",dataUtils.getZipCode());
        checkoutObject.enterInput("Phone number:",dataUtils.getPhoneNumber());
        checkoutObject.enterInput("Fax number:","1000");
        checkoutObject.enterInput("Zip / postal code",dataUtils.getZipCode());
        checkoutObject.selectData("Country","Viet Nam");
        checkoutObject.clickContinue();
        checkoutObject.isExpandingPaymentMethod();
        Log.allure("Verify expanding payment method.");

    }
}
