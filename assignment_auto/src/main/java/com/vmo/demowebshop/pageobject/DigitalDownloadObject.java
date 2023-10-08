package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.DigitalDownloadUI;
import com.vmo.demowebshop.interfaces.HomepageUI;
import com.vmo.demowebshop.interfaces.ListBookPageUI;
import org.openqa.selenium.WebDriver;

public class DigitalDownloadObject extends BasePage {
    private WebDriver driver;

    public DigitalDownloadObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyDigitalDownloadScreen() {
        waitForElementVisible(driver, DigitalDownloadUI.TITLE_PAGE);
        return isElementDisplay(driver,DigitalDownloadUI.TITLE_PAGE);
    }

    public void clickItemToCart() {
        clickToElement(driver,DigitalDownloadUI.BTN_ADD_TO_CART);
    }
    public boolean isDisplayMsgAddToCart() {
        waitForElementVisible(driver, ListBookPageUI.BAR_NOTIFICATION);
        return isElementDisplay(driver, ListBookPageUI.BAR_NOTIFICATION);
    }

    public void clickShoppingCart() {
        clickToElement(driver, HomepageUI.ICON_SHOPPING_CART);
        Log.allure("Click shopping cart");
    }
}
