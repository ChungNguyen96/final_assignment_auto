package com.vmo.demowebshop.pageobject;


import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.common.GlobalConstants;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.HomepageUI;
import com.vmo.demowebshop.interfaces.ListBookPageUI;
import com.vmo.demowebshop.interfaces.LoginPageUI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class HomepageObject extends BasePage {
    private WebDriver driver;
    private int quantity = 0;

    public HomepageObject(WebDriver driver) {
        this.driver = driver;

    }

    public void setQuantity() {
        String quantityElement = getWebElement(driver, ListBookPageUI.CART_QUANTITY).getText();
        quantity = Integer.parseInt(quantityElement.substring(quantityElement.indexOf("(") + 1, quantityElement.indexOf(")")));
    }

    public void enterURL() {
        openUrl(driver, HomepageUI.URL);
        Log.allure("Enter URL");
    }

    public void clickLogin() {
        waitForElementVisible(driver, LoginPageUI.LINK_LOGIN);
        if (getWebElement(driver, LoginPageUI.LINK_LOGIN).getText().equals("Log out")) {
            clickToElement(driver, LoginPageUI.LINK_LOGIN);
        }
        clickToElement(driver, LoginPageUI.LINK_LOGIN);
        Log.allure("Click Login");
    }

    public boolean isCorrectHomepage() {

        return getCurrentUrl(driver).equals(HomepageUI.URL);
    }


    public void clickBookTag() {
        waitForElementVisible(driver,HomepageUI.BOOK_MENU);
        clickToElement(driver, HomepageUI.BOOK_MENU);
        Log.allure("Click menu: Book.");
    }

    public int getQuantityDisplayIncart() {
        waitForElementVisible(driver,ListBookPageUI.CART_QUANTITY);
        String quantity = getWebElement(driver, ListBookPageUI.CART_QUANTITY).getText();
        return Integer.parseInt(quantity.substring(quantity.indexOf("(") + 1, quantity.indexOf(")")));
    }


    public void clickItemToCart() {
        clickToElement(driver, HomepageUI.BTN_ADD_TO_CART);
        Log.allure("Click add item to cart.");
        quantity++;
    }
    public boolean isDisplayMsgAddToCart() {
        waitForElementVisible(driver, ListBookPageUI.BAR_NOTIFICATION);
        return isElementDisplay(driver, ListBookPageUI.BAR_NOTIFICATION);
    }


    public int getQuantity() {
        return quantity;
    }

    public boolean verifyQuantity(int quantityIncart) {
        if (quantity == quantityIncart)return  true;
        else  return false;
    }
    public  void clickCloseBarNotification(){
        waitForElementVisible(driver,HomepageUI.BAR_NOTIFICATION);
        clickToElement(driver,HomepageUI.BAR_NOTIFICATION);

    }

    public void clickMenuDigitalDownload() {
        clickToElement(driver,HomepageUI.MENU_DIGITAL_DOWNLOAD);
    }


    public void clickToShoppingCart() {
        waitForElementClickable(driver,ListBookPageUI.CART);
        clickToElement(driver,ListBookPageUI.CART);
    }
}
