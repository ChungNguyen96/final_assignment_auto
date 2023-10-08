package com.vmo.demowebshop.features.shoppingcart;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.pageobject.HomepageObject;
import com.vmo.demowebshop.pageobject.ListBookPageObject;
import com.vmo.demowebshop.pageobject.PageGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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
        int beforeQuantity = listBookPageObject.getQuantityIncart(); // quantity khi chua add to cart
        List<String> listBookHighestRate = listBookPageObject.getBookByRate(2);
        listBookPageObject.clickBookHighestRate(1,listBookHighestRate);
        verifyTrue(listBookPageObject.isDisplayMsgAddToCart());
        int afterQuantity = listBookPageObject.getQuantityIncart();
        verifyTrue(listBookPageObject.increaseNumberIncart(beforeQuantity,afterQuantity));
        Log.allure("Verify increase quantity after click the 1st book");
        beforeQuantity = listBookPageObject.getQuantityIncart();
        listBookPageObject.clickBookHighestRate(2,listBookHighestRate);
        verifyTrue(listBookPageObject.isDisplayMsgAddToCart());
        afterQuantity = listBookPageObject.getQuantityIncart();
        //verifyTrue( listBookPageObject.increaseNumberIncart(beforeQuantity,afterQuantity));
        Log.allure("Verify increase quantity after click the 2nd book");
        listBookPageObject.hoverOnCart();
  //      System.out.println("Book in cart: " + driver.findElement(By.xpath("(//div[@class='mini-shopping-cart']//div[@class='name']/a)[1]")).getTagName());
        List<String> listBookIncartExpect = listBookPageObject.getListBookInCart();
        List<String> listBookDisplayIncart = listBookPageObject.getListBookDisplayInCart();
        verifyTrue(listBookPageObject.compareListBookDisplayInCart(listBookDisplayIncart,listBookIncartExpect));
    }


//    @AfterClass
//    public void teardown() {
//        cleanBrowserAndDriver();
//        Log.info("Close driver");
//    }
}
