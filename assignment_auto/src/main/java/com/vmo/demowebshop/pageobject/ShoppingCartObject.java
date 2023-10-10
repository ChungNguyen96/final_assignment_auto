package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.interfaces.ShoppingCartUI;
import org.openqa.selenium.WebDriver;

public class ShoppingCartObject extends BasePage {
    private WebDriver driver;

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

    public void clickCheckOut() {
        clickToElement(driver,ShoppingCartUI.BTN_CHECKOUT);
    }

    public boolean isDisplayWelcomeSign() {
        waitForElementVisible(driver,ShoppingCartUI.TITLE_CHECKOUT_AS_GUEST);
        return isElementDisplay(driver,ShoppingCartUI.TITLE_CHECKOUT_AS_GUEST);
    }

    public void clickCheckoutAsGuest() {
        clickToElement(driver,ShoppingCartUI.BTN_CHECKOUT_AS_GUEST);
    }

    public void decreaseQuantity() {

        int originalQuantity = Integer.valueOf(getWebElement(driver,ShoppingCartUI.INPUT_QUANTITY).getAttribute("value"));
        System.out.println(originalQuantity);
        sendKeyToElement(driver,ShoppingCartUI.INPUT_QUANTITY,String.valueOf(originalQuantity-1));
    }
}
