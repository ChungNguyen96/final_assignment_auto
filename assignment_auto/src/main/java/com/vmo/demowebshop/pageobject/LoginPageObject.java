package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.HomepageUI;
import com.vmo.demowebshop.interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void enterEmail(String email) {
        waitForElementVisible(driver, LoginPageUI.TXT_EMAIL);
        sendKeyToElement(driver, LoginPageUI.TXT_EMAIL, email);
        Log.allure("Enter email: %s", email);
    }

    public void enterPassword(String pass) {
        waitForElementVisible(driver, LoginPageUI.TXT_PASSWORD);
        sendKeyToElement(driver, LoginPageUI.TXT_PASSWORD, pass);
        Log.allure("Enter password");
    }

    public void login() {
        waitForElementVisible(driver, LoginPageUI.BTN_LOGIN);

        clickToElement(driver, LoginPageUI.BTN_LOGIN);
    }

    public boolean verifyLogin(String email, String expected) {
        if (expected.isEmpty()) {
            return isElementDisplay(driver, HomepageUI.ACCOUNT_INFO);
        } else if (!email.isEmpty() && !email.contains("@") ) {
            return isElementDisplay(driver, LoginPageUI.MSG_VALIDATE_EMAIL);
        } else {
            String msgActual = getWebElement(driver, LoginPageUI.MSG_LOGIN_UNSUCCESSFULL).getText();
            if (expected.equals(msgActual)) return true;
            else return false;
        }

    }
}

