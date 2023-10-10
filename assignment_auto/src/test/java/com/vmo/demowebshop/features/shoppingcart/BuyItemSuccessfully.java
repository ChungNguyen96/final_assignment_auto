package com.vmo.demowebshop.features.shoppingcart;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.CheckoutUI;
import com.vmo.demowebshop.pageobject.*;
import com.vmo.demowebshop.utils.DataUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BuyItemSuccessfully extends BaseTest {
    private WebDriver driver;
    private HomepageObject homepageObject;
    private DigitalDownloadObject digitalDownloadObject;
    private ShoppingCartObject shoppingCartObject;
    private CheckoutObject checkoutObject;
    private CheckoutCompleteObject checkoutCompleteObject;

    private Customer customer;
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
        digitalDownloadObject.setQuantity();
        digitalDownloadObject.clickItemToCart();
        verifyTrue(digitalDownloadObject.isDisplayMsgAddToCart());
        verifyTrue(digitalDownloadObject.verifyQuantity(digitalDownloadObject.getQuantityIncart()));
        //Step 4: Click shopping cart
        digitalDownloadObject.clickShoppingCart();
        shoppingCartObject = PageGenerator.getShoppingCartObject(driver);
        verifyTrue(shoppingCartObject.isShoppingCartScreen());
        Log.allure("Verify display shopping cart screen.");

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
        customer = new Customer("Viet Nam");
        checkoutObject.enterInput("First name", customer.getFirstName());
        checkoutObject.enterInput("Last name",customer.getLastName());
        checkoutObject.enterInput("Email",customer.getEmail());
        checkoutObject.enterInput("Company",customer.getCompany());
        checkoutObject.enterInput("City",customer.getCity());
        checkoutObject.enterInput("Address 1",customer.getAddress1());
        checkoutObject.enterInput("Address 2",customer.getAddress2());
        checkoutObject.enterInput("Zip / postal code",customer.getZipCode());
        checkoutObject.enterInput("Phone number:",customer.getPhoneNumber());
        checkoutObject.enterInput("Fax number:",customer.getFaxNumber());
        checkoutObject.selectData("Country",customer.getCountry());

        checkoutObject.clickContinue(CheckoutUI.ID_CHECKOUT_BILLING);
        Log.allure("Click continue at billing address.");
        verifyTrue(checkoutObject.isExpandingPaymentMethod());
        Log.allure("Verify expanding payment method.");
        verifyTrue(checkoutObject.isCheckOnCashDelivery());
        Log.allure("Verify default is Cash on delivery.");
        checkoutObject.clickContinue(CheckoutUI.ID_CHECKOUT_PAYMENT_METHOD);
        verifyTrue(checkoutObject.isEpandingPaymentInfo());
        Log.allure("Verify expanding payment info");
        verifyTrue(checkoutObject.isDisplayTitlePayCod());
        //Step 13: Click continue on payment info
        checkoutObject.clickContinue(CheckoutUI.ID_CHECKOUT_PAYMENT_INFO);
        verifyTrue(checkoutObject.isExpandingConfirmOrder());
        //Step : Verify confirm order
        verifyTrue(checkoutObject.isCorrectName(customer.getFirstName(),customer.getLastName()));
        verifyTrue(checkoutObject.isCorrectEmail(customer.getEmail()));
        verifyTrue(checkoutObject.isCorrectPhoneNumber(customer.getPhoneNumber()));
        verifyTrue(checkoutObject.isCorrectFax(customer.getFaxNumber()));
        verifyTrue(checkoutObject.isCorrectCompany(customer.getCompany()));
        verifyTrue(checkoutObject.isCorrectAddress1(customer.getAddress1()));
        verifyTrue(checkoutObject.isCorrectAddress2(customer.getAddress2()));
        verifyTrue(checkoutObject.isCorrectZipCode(customer.getZipCode()));
        verifyTrue(checkoutObject.isCorrectCountry(customer.getCountry()));

        verifyTrue(checkoutObject.isCorrectPaymentMethod());
        verifyTrue(checkoutObject.isCorrectTotalAmount());
        Log.allure("Verified total amount.");
        checkoutObject.clickConfirm();
        checkoutCompleteObject = PageGenerator.getCheckoutObjectComplete(driver);
        verifyTrue(checkoutCompleteObject.isDisplayCompletePage());
        Log.allure("Verified display complete checkout page.");
        checkoutCompleteObject.clickContinue();
        Log.allure("Click continue to back Homepage.");
        verifyTrue(homepageObject.isCorrectHomepage());
        Log.allure("Verifed in homepage screen.");

    }

    @AfterClass
    public void teardown() {
        cleanBrowserAndDriver();
        Log.info("Close driver");
    }
}
