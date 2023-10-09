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
        sendKeyToElement(driver, CheckoutUI.INPUT_DYNAMIC, firstName, fieldName);
        Log.allure("Input %s: %s", fieldName, firstName);

    }

    public void selectData(String fieldName, String country) {
        System.out.println(getWebElement(driver, CheckoutUI.SELECT_DYNAMIC, fieldName));

        selectItemInDefaultDropdownByText(driver, CheckoutUI.SELECT_DYNAMIC, country, fieldName);
        Log.allure("Select country");
    }

    public void clickContinue(String section) {
        waitForElementVisible(driver, CheckoutUI.BTN_CONTINUE, section);
        clickToElement(driver, CheckoutUI.BTN_CONTINUE, section);
    }

    public boolean isExpanding(String section) {
        waitForElementVisible(driver, CheckoutUI.SECTION_DYNAMIC, section);
        WebElement style = getWebElement(driver, CheckoutUI.SECTION_DYNAMIC, section);
        System.out.println(style.getAttribute("style"));
        if (style.getAttribute("style").contains("display: none;")) return false;
        else return true;
    }

    public boolean isExpandingPaymentMethod() {
        return isExpanding(CheckoutUI.ID_CHECKOUT_PAYMENT_METHOD);
    }

    public boolean isCheckOnCashDelivery() {
        return isElementSelected(driver, CheckoutUI.LABEL_CASH_DELIVERY);
    }

    public boolean isEpandingPaymentInfo() {
        return isExpanding(CheckoutUI.ID_CHECKOUT_PAYMENT_INFO);
    }

    public boolean isDisplayTitlePayCod() {
        waitForElementVisible(driver, CheckoutUI.TITLE_PAY_BY_COD);
        return isElementDisplay(driver, CheckoutUI.TITLE_PAY_BY_COD);
    }

    public boolean isExpandingConfirmOrder() {
        return isExpanding(CheckoutUI.ID_CHECKOUT_CONFIRM_ORDER);
    }

    public boolean isCorrectName(String firstName, String lastName) {
        String name = firstName + " " + lastName;
        return name.equals(getWebElement(driver, CheckoutUI.CONFIRM_INFOR_DYNAMIC, CheckoutUI.NAME_CONFIRM).getText());
    }

    public boolean isCorrectEmail(String email) {
        WebElement elmEmail = getWebElement(driver, CheckoutUI.CONFIRM_INFOR_DYNAMIC, CheckoutUI.EMAIL_CONFIRM);
        return getWebElement(driver, CheckoutUI.CONFIRM_INFOR_DYNAMIC, CheckoutUI.EMAIL_CONFIRM).getText().contains(email);
    }

    public boolean isCorrectPhoneNumber(String phoneNumber) {
        return getWebElement(driver, CheckoutUI.CONFIRM_INFOR_DYNAMIC, CheckoutUI.PHONE_CONFIRM).getText().contains(phoneNumber);
    }

    public boolean isCorrectFax(String faxNumber) {
        return getWebElement(driver, CheckoutUI.CONFIRM_INFOR_DYNAMIC, CheckoutUI.FAX_CONFIRM).getText().contains(faxNumber);
    }

    public boolean isCorrectCompany(String company) {
        return company.equals(getWebElement(driver, CheckoutUI.CONFIRM_INFOR_DYNAMIC, CheckoutUI.COMPANY_CONFIRM).getText());
    }

    public boolean isCorrectAddress1(String address1) {
        return address1.equals(getWebElement(driver, CheckoutUI.CONFIRM_INFOR_DYNAMIC, CheckoutUI.ADDRESS1_CONFIRM).getText());
    }

    public boolean isCorrectAddress2(String address2) {
        return address2.equals(getWebElement(driver, CheckoutUI.CONFIRM_INFOR_DYNAMIC, CheckoutUI.ADDRESS2_CONFIRM).getText());
    }

    public boolean isCorrectZipCode(String zipCodeExpect) {
        String zipcodeActual = getWebElement(driver, CheckoutUI.CONFIRM_INFOR_DYNAMIC, CheckoutUI.CITY_ZIP).getText();

        return zipcodeActual.contains(zipCodeExpect);
    }

    public boolean isCorrectCountry(String country) {
        return country.equals(getWebElement(driver, CheckoutUI.CONFIRM_INFOR_DYNAMIC, CheckoutUI.COUNTRY_CONFIRM).getText());
    }

    public boolean isCorrectPaymentMethod() {
        WebElement paymentMethod = getWebElement(driver, CheckoutUI.CONFIRM_INFOR_DYNAMIC, CheckoutUI.PAYMENT_METHOD_CONFIRM);
        return paymentMethod.getText().equals("Cash On Delivery (COD)");
    }

    public boolean isCorrectTotalAmount() {
        String subTotal = getWebElement(driver, CheckoutUI.DYNAMIC_PRICE, CheckoutUI.TD_SUB_TOTAL).getText();
        String paymentMethodFee = getWebElement(driver, CheckoutUI.DYNAMIC_PRICE, CheckoutUI.TD_PAYMENT_METHOD_FEE).getText();
        String total = getWebElement(driver, CheckoutUI.ORDER_TOTAL).getText();
        Float totalExpect = Float.valueOf(subTotal) + Float.valueOf(paymentMethodFee);
        if (totalExpect - Float.valueOf(total) == 0) return true;
        else return false;
    }

    public void clickConfirm() {
        waitForElementVisible(driver, CheckoutUI.BTN_CONFIRM);
        clickToElement(driver, CheckoutUI.BTN_CONFIRM);
    }
}
