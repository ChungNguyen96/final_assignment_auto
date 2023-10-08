package com.vmo.demowebshop.interfaces;

public class ShoppingCartUI {

    public static String TITLE_PAGE = "//div[@class='page-title']/h1[text()='Shopping cart']";
    public static String SELECT_COUNTRY = "//select[@id='CountryId']";
    public static String CHECKBOX_TERM_SERVICE = "//input[@id='termsofservice']";
    public static String BTN_CHECKOUT = "//button[@id='checkout']";
    public static String TITLE_CHECKOUT_AS_GUEST = "//strong[text()='Checkout as a guest or register']";
    public static String BTN_CHECKOUT_AS_GUEST = "//input[contains(@class,'checkout-as-guest-button')]";
}
