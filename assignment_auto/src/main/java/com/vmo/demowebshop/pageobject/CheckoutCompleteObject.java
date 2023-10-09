package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.interfaces.CheckoutCompleteUI;
import org.openqa.selenium.WebDriver;

public class CheckoutCompleteObject extends BasePage {
    private WebDriver driver;

    public CheckoutCompleteObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayCompletePage() {
        waitForElementVisible(driver, CheckoutCompleteUI.PAGE_ORDER_COMPLETE);
        return isElementDisplay(driver,CheckoutCompleteUI.PAGE_ORDER_COMPLETE);
    }

    public void clickContinue() {
        waitForElementClickable(driver,CheckoutCompleteUI.BTN_CONTINUE);
        clickToElement(driver,CheckoutCompleteUI.BTN_CONTINUE);
    }
}
