package com.vmo.demowebshop.interfaces;

public class CheckoutUI {
    public static  String TITLE_PAGE = "//div[@class='page-title']/h1[text()='Checkout']";
    public static String INPUT_DYNAMIC = "//label[contains(text(),'%s')]//following-sibling::input";
    public static String SELECT_DYNAMIC = "//label[contains(text(),'Country:')]//following-sibling::select";
    public static String BTN_CONTINUE = "//div[@id='%s']//input[@value='Continue']";
    public static String ID_CHECKOUT_BILLING = "checkout-step-billing";
    public static String ID_CHECKOUT_PAYMENT_METHOD = "checkout-step-payment-method";
    public static String ID_CHECKOUT_PAYMENT_INFO = "checkout-step-payment-info";
    public static String ID_CHECKOUT_CONFIRM_ORDER = "checkout-step-confirm-order";

    public static String SECTION_DYNAMIC = "//div[@id='%s']";
    public static String TITLE_PAY_BY_COD = "//p[text()='You will pay by COD']";
    public static String PAYMENT_METHOD_CASH = "//p[text()='You will pay by COD']";

    public static String LABEL_CASH_DELIVERY = "//label[text()='Cash On Delivery (COD) (7.00)']/preceding-sibling::input";
    // public static String SECTION_SHIPPING_ADDRESS="//div[@id='checkout-step-billing']";
    public static String CONFIRM_INFOR_DYNAMIC = "//li[@class= '%s']";
    public static String NAME_CONFIRM = "name";
    public static String EMAIL_CONFIRM = "email";
    public static String PHONE_CONFIRM = "phone";
    public static String COMPANY_CONFIRM = "company";
    public static String ADDRESS1_CONFIRM = "address1";
    public static String ADDRESS2_CONFIRM = "address2";
    public static String COUNTRY_CONFIRM = "country";
    public static String FAX_CONFIRM = "fax";
    public static String CITY_ZIP = "city-state-zip";
    public static String PAYMENT_METHOD_CONFIRM = "payment-method";
    public static String TD_PAYMENT_METHOD_FEE = "Payment method additional fee:";
    public static String TD_SUB_TOTAL = "Sub-Total:";
    public static String ORDER_TOTAL = "//span[contains(@class,'order-total')]";
    public static String DYNAMIC_PRICE = "//span[text()='%s']/parent::td/following-sibling::td//span[@class='product-price']";
    public static String BTN_CONFIRM = "//input[@value='Confirm']";
}
