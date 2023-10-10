package com.vmo.demowebshop.pageobject;

import com.vmo.demowebshop.common.BasePage;
import com.vmo.demowebshop.interfaces.ProductDetailUI;
import org.openqa.selenium.WebDriver;

public class ProductDetailObject extends BasePage {
    private WebDriver driver;

    public ProductDetailObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickItemToCart() {
        waitForElementVisible(driver, ProductDetailUI.BTN_ADD_TO_CART);
        clickToElement(driver,ProductDetailUI.BTN_ADD_TO_CART);
    }
}
