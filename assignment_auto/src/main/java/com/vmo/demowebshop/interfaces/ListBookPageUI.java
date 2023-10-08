package com.vmo.demowebshop.interfaces;

public class ListBookPageUI {
    public static final String TITLE_BOOK_PAGE = "//h1[text()='Books']";
    public static final String LISTBOOK_RATE = "//div[@class='product-item']//DIV[@class='rating']/div";
    public static final String BAR_NOTIFICATION = "//p[text()='The product has been added to your ']/ancestor::div";
    public static final String BTN_ADD_TO_CART = "//a[text()='%s']/parent::h2/following-sibling::div//input";
    public static final String BOOK_BY_RATE = "//div[@class='rating']/div[contains(@style,'%s')]/ancestor::div[@class='details']//a";
    //div[@class='rating']/div[contains(@style,'59')]/ancestor::div[@class='details']//a
    public static final String BTN_ADD_TO_CART_BY_RATE = "//div[@class='rating']/div[contains(@style,'%s')]/ancestor::div[@class='details']//input";
    public static final String CART = "//span[@class='cart-label' and text()='Shopping cart']";
    public static final String CART_QUANTITY = "//span[@class='cart-qty']";
    public static final String BOOK_NAME_IN_CART = "//div[@class='flyout-cart']//div[@class='name']/a";

}