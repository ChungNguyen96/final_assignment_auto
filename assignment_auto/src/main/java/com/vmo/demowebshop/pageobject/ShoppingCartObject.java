package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.ListBookPageUI;
import com.vmo.demowebshop.interfaces.ShoppingCartUI;
import org.openqa.selenium.WebDriver;

public class ShoppingCartObject extends BasePage {
    private WebDriver driver;
    private int quantity;

    public ShoppingCartObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isShoppingCartScreen() {
        waitForElementVisible(driver,ShoppingCartUI.TITLE_PAGE);
        return isElementDisplay(driver, ShoppingCartUI.TITLE_PAGE);
    }

    public void selectCountry(String country) {
        selectItemInDefaultDropdownByText(driver,ShoppingCartUI.SELECT_COUNTRY,country);
    }

    public void clickTermService() {
        clickToElement(driver,ShoppingCartUI.CHECKBOX_TERM_SERVICE);
    }

    public boolean isClickedTermService() {

        return isElementSelected(driver,ShoppingCartUI.CHECKBOX_TERM_SERVICE);
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity() {
        String quantityElement = getWebElement(driver, ListBookPageUI.CART_QUANTITY).getText();
        quantity = Integer.parseInt(quantityElement.substring(quantityElement.indexOf("(") + 1, quantityElement.indexOf(")")));
    }
    public void clickCheckOut() {
        clickToElement(driver,ShoppingCartUI.BTN_CHECKOUT);
    }

    public boolean isDisplayWelcomeSign() {
        waitForElementVisible(driver,ShoppingCartUI.TITLE_CHECKOUT_AS_GUEST);
        return isElementDisplay(driver,ShoppingCartUI.TITLE_CHECKOUT_AS_GUEST);
    }
    public boolean verifyQuantity(int quantityIncart) {
        if (quantity == quantityIncart)return  true;
        else  return false;
    }
    public int getQuantityDisplayIncart() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, ListBookPageUI.CART_QUANTITY));
        waitForElementVisible(driver, ListBookPageUI.CART_QUANTITY);
        String quantity = getWebElement(driver, ListBookPageUI.CART_QUANTITY).getText();
        return Integer.parseInt(quantity.substring(quantity.indexOf("(") + 1, quantity.indexOf(")")));
    }

    public void clickCheckoutAsGuest() {
        clickToElement(driver,ShoppingCartUI.BTN_CHECKOUT_AS_GUEST);
    }

    public void decreaseQuantity() {
        int originalQuantity = Integer.valueOf(getWebElement(driver,ShoppingCartUI.INPUT_QUANTITY).getAttribute("value"));
        sendKeyToElement(driver,ShoppingCartUI.INPUT_QUANTITY,String.valueOf(originalQuantity-1));
    }

    public void clickUpdateCart() {
        waitForElementVisible(driver,ShoppingCartUI.BTN_UPDATE_SHOPPING_CART);
        clickToElement(driver,ShoppingCartUI.BTN_UPDATE_SHOPPING_CART);
        quantity--;
        Log.allure("Update shopping cart.");
        sleepInSecond(5);
    }
}
