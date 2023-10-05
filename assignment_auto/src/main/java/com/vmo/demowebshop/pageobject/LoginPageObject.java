package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterURL() {
        openUrl(driver, LoginPageUI.URL);
    }

    public void clickLogin() {
        waitForElementVisible(driver,LoginPageUI.LINK_LOGIN);
        clickToElement(driver,LoginPageUI.LINK_LOGIN);
    }

    public void enterEmail(String email) {
        waitForElementVisible(driver,LoginPageUI.TXT_EMAIL);
        sendKeyToElement(driver,LoginPageUI.TXT_EMAIL,email);
    }
    public void enterPassword(String pass) {
        waitForElementVisible(driver,LoginPageUI.TXT_EMAIL);
        sendKeyToElement(driver,LoginPageUI.TXT_EMAIL,pass);
    }

    public void login() {
        waitForElementVisible(driver,LoginPageUI.BTN_LOGIN);
        clickToElement(driver,LoginPageUI.BTN_LOGIN);
    }
}
