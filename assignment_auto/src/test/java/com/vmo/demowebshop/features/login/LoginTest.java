package com.vmo.demowebshop.features.login;

import com.beust.jcommander.Parameter;
import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.pageobject.LoginPageObject;
import com.vmo.demowebshop.pageobject.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPageObject;

    @BeforeClass
    @Parameters({"browser"})
    public void setup(String browser) {
        driver = getDriverBrower(browser);
    }

    @Test
    public void TC01_Login() {
        loginPageObject = PageGenerator.getLoginPageObject(driver);
        loginPageObject.enterURL();
        loginPageObject.clickLogin();
        loginPageObject.enterEmail("chungnt149@gmail.com");
        loginPageObject.enterPassword("chung149");
        loginPageObject.login();
    }

    @AfterClass
    public void teardown() {
        cleanBrowserAndDriver();
    }


}
