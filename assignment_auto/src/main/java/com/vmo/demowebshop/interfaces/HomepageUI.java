package com.vmo.demowebshop.interfaces;

public class HomepageUI {
    public static final String URL = "https://demowebshop.tricentis.com/";
    public static final String ACCOUNT_INFO = "//div[@class='header-links']//a[@class='account']";
    public static final String BOOK_MENU = "(//div[@class='header-menu']//a)[1]";
    public static final String TITLE_SCREEN = "";
    public static final String BTN_ADD_TO_CART = "//div[@class='product-item']//a[text()='14.1-inch Laptop']/ancestor::div[@class='details']//input";
    //public static final String BTN_ADD_TO_CART = "//div[@class='product-item']//a[text()='14.1-inch Laptop']/ancestor::div[@class='details']//input";
    public static final String ICON_SHOPPING_CART = "//div[@class='header']//a[@class='ico-cart']";

    public static final String BAR_NOTIFICATION = "//div[@id='bar-notification' and @style='display: block;']/span";
   // public static final String BAR_NOTIFICATION = "//p[text()='The product has been added to your ']/ancestor::div";
    public static final String MENU_DIGITAL_DOWNLOAD = "//li[@class='inactive']//a[normalize-space()='Digital downloads']";

}
