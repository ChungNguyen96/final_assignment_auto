package com.vmo.demowebshop.pageobject;


import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.HomepageUI;
import com.vmo.demowebshop.interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HomepageObject extends BasePage {
    private WebDriver driver;

    public HomepageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterURL() {
        openUrl(driver, HomepageUI.URL);
        Log.allure("Enter URL");
    }
    public void clickLogin() {
        waitForElementVisible(driver,LoginPageUI.LINK_LOGIN);
        if (getWebElement(driver,LoginPageUI.LINK_LOGIN).getText().equals("Log out")){
            clickToElement(driver,LoginPageUI.LINK_LOGIN);
        }
        clickToElement(driver,LoginPageUI.LINK_LOGIN);
        Log.allure("Click Login");
    }

    public boolean isCorrectHomepage() {
        return getCurrentUrl(driver).equals(HomepageUI.URL);
    }


    public void clickBookTag() {
        clickToElement(driver,HomepageUI.BOOK_MENU);
    }

}
