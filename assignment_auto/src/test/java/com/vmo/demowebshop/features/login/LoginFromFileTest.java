package com.vmo.demowebshop.features.login;

import com.vmo.demowebshop.common.BaseTest;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.pageobject.HomepageObject;
import com.vmo.demowebshop.pageobject.LoginPageObject;
import com.vmo.demowebshop.pageobject.PageGenerator;
import com.vmo.demowebshop.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginFromFileTest extends BaseTest {
    private WebDriver driver;
    private LoginPageObject loginPageObject;
    private HomepageObject homepageObject;

    @BeforeClass
    @Parameters({"browser"})
    public void setup(String browser) throws IOException {
        driver = getDriverBrower(browser);
        Log.info("Read file");
        ExcelUtils.setExcelFileSheet("Test data (2)");
    }



    @Test(dataProvider = "readFile")
    public void TC01_Login(String index,String username, String password, String expected) {
        homepageObject = PageGenerator.getHomepageObject(driver);
        homepageObject.enterURL();
        verifyTrue(homepageObject.isCorrectHomepage());
        homepageObject.clickLogin();
        loginPageObject = PageGenerator.getLoginPageObject(driver);
        loginPageObject.enterEmail(username);
        loginPageObject.enterPassword(password);
        loginPageObject.login();
        verifyTrue(loginPageObject.verifyLogin(username,expected));
    }
    @DataProvider(name = "readFile")
    public Object[][] getDataFromFile() {
        Log.info("Read data");
        return ExcelUtils.getDataFromFile();

    }
    @AfterClass
    public void teardown() {
        cleanBrowserAndDriver();
        Log.info("Close driver");
    }

}
