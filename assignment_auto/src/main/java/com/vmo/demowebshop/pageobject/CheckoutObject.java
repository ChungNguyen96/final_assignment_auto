package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.helper.Log;
import com.vmo.demowebshop.interfaces.CheckoutUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutObject extends BasePage {
    private WebDriver driver;

    public CheckoutObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayScreen() {
        waitForElementVisible(driver, CheckoutUI.TITLE_PAGE);
        return isElementDisplay(driver, CheckoutUI.TITLE_PAGE);
    }

    public void enterInput(String fieldName, String firstName) {
        sendKeyToElement(driver,CheckoutUI.INPUT_DYNAMIC,firstName,fieldName);
        Log.allure("Input %s: %s",fieldName,firstName);

    }

    public void selectData(String fieldName, String country) {
        selectItemInDefaultDropdownByText(driver,CheckoutUI.SELECT_DYNAMIC,country,fieldName);
        Log.allure("Select country");
    }

    public void clickContinue() {
        clickToElement(driver,CheckoutUI.BTN_CONTINUE);
    }

    public boolean isExpandingPaymentMethod() {
        waitForElementVisible(driver,CheckoutUI.SECTION_SHIPPING_ADDRESS);
        WebElement shippingAddress = getWebElement(driver,CheckoutUI.SECTION_SHIPPING_ADDRESS);
        System.out.println(shippingAddress.getAttribute("style"));
        if (shippingAddress.getAttribute("style").contains("display: none;")) return false;
        else return true;
    }

    public boolean isCheckOnCashDelivery() {
        return isElementSelected(driver,CheckoutUI.CHECKBOX_CASH_DELIVERY);
    }
}
