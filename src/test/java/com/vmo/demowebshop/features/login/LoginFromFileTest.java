package com.vmo.demowebshop.features.login;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.pageobject.HomepageObject;
import com.vmo.demowebshop.pageobject.LoginPageObject;
import com.vmo.demowebshop.pageobject.PageGenerator;
import com.vmo.demowebshop.utils.ExcelUtils;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

@Epic("Demo webshop")
@Feature("Authen")
@Story("Login with data file")

public class LoginFromFileTest extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPageObject;
    private HomepageObject homepageObject;


    @BeforeClass
    @Parameters({"browser"})
    public void setup(String browser) throws IOException {
        driver = getDriverBrower(browser);
        Log.allure("Read data from file.");
        ExcelUtils.setExcelFileSheet("Test data");
    }

    @Test(dataProvider = "readFile")
    public void TC01_Login(String index,String username, String password, String expected) {
        homepageObject = PageGenerator.getHomepageObject(driver);
        homepageObject.enterURL();
        verifyTrue(homepageObject.isCorrectHomepage());
        Log.allure("Verified display homepage.");
        homepageObject.clickLogin();
        loginPageObject = PageGenerator.getLoginPageObject(driver);
        verifyTrue(loginPageObject.isDisplayLogin());
        Log.allure("Verified display login page.");
        loginPageObject.enterEmail(username);
        loginPageObject.enterPassword(password);
        loginPageObject.login();
        verifyTrue(loginPageObject.verifyLogin(username,expected));
        Log.allure("Verified login.");
    }
    @DataProvider(name = "readFile")
    public Object[][] getDataFromFile() {
        return ExcelUtils.getDataFromFile();

    }
    @AfterClass
    public void teardown() {
        cleanBrowserAndDriver();
        Log.allure("Close driver");
    }

}
