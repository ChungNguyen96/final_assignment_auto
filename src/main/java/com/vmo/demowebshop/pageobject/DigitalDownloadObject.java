package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.DigitalDownloadUI;
import com.vmo.demowebshop.interfaces.HomepageUI;
import com.vmo.demowebshop.interfaces.ListBookPageUI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class DigitalDownloadObject extends BasePage {
    private WebDriver driver;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity() {
        String quantityElement = getWebElement(driver, ListBookPageUI.CART_QUANTITY).getText();
        quantity = Integer.parseInt(quantityElement.substring(quantityElement.indexOf("(") + 1, quantityElement.indexOf(")")));
    }

    public DigitalDownloadObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean verifyDigitalDownloadScreen() {
        waitForElementVisible(driver, DigitalDownloadUI.TITLE_PAGE);
        return isElementDisplay(driver,DigitalDownloadUI.TITLE_PAGE);
    }

    public void clickItemToCart() {
        clickToElement(driver,DigitalDownloadUI.BTN_ADD_TO_CART);
        quantity++;
    }
    public boolean isDisplayMsgAddToCart() {
        waitForElementVisible(driver, ListBookPageUI.BAR_NOTIFICATION);
        return isElementDisplay(driver, ListBookPageUI.BAR_NOTIFICATION);
    }

    public void clickShoppingCart() {
        clickToElement(driver, HomepageUI.ICON_SHOPPING_CART);
        Log.allure("Click shopping cart");
    }
    public boolean verifyQuantity(int quantityIncart) {
        if (quantity == quantityIncart) return true;
        else return false;
    }
    public int getQuantityIncart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, ListBookPageUI.CART_QUANTITY));
        waitForElementVisible(driver, ListBookPageUI.CART_QUANTITY);
        String quantity = getWebElement(driver, ListBookPageUI.CART_QUANTITY).getText();
        return Integer.parseInt(quantity.substring(quantity.indexOf("(") + 1, quantity.indexOf(")")));
    }
}
