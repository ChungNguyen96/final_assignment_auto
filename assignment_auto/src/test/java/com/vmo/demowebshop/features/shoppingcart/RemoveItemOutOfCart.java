package com.vmo.demowebshop.features.shoppingcart;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.pageobject.HomepageObject;
import com.vmo.demowebshop.pageobject.ListBookPageObject;
import com.vmo.demowebshop.pageobject.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class RemoveItemOutOfCart extends BaseTest {
    private WebDriver driver;
    private HomepageObject homepageObject;


    @BeforeClass
    @Parameters({"browser"})
    public void setup(String browser) {
        driver = getDriverBrower(browser);
    }
    @Test
    public void TC03_RemoveItemOutCart(){
        homepageObject = PageGenerator.getHomepageObject(driver);
        homepageObject.enterURL();
        verifyTrue(homepageObject.isCorrectHomepage());

    }
//    @AfterClass
//    public void teardown() {
//        cleanBrowserAndDriver();
//        Log.info("Close driver");
//    }
}
