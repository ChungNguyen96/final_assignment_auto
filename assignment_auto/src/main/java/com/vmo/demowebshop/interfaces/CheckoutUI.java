package com.vmo.demowebshop.interfaces;

public class CheckoutUI {
    public static String TITLE_PAGE="//div[@class='page-title']/h1[text()='Checkout']";
    public static String INPUT_DYNAMIC ="//label[contains(text(),'%s')]//following-sibling::input";
    public static String SELECT_DYNAMIC="//label[contains(text(),'Country:')]//following-sibling::select";
    public static String BTN_CONTINUE="//div[@id='checkout-step-billing']//input[@value='Continue']";
   public static String SECTION_SHIPPING_ADDRESS="//div[@id='checkout-step-payment-method']";
   public static String CHECKBOX_CASH_DELIVERY="//label[text()='Cash On Delivery (COD) (7.00)']/preceding-sibling::input";
   // public static String SECTION_SHIPPING_ADDRESS="//div[@id='checkout-step-billing']";
}
