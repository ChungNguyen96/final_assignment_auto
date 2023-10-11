package com.vmo.demowebshop.interfaces;

public class LoginPageUI {

    public static final String LINK_LOGIN = "(//div[@class='header-links']//a)[2]";

    public static final String TXT_EMAIL = "//input[@id='Email']";
    public static final String TXT_PASSWORD = "//input[@id='Password']";
    public static final String LOGIN_PAGE = "//div[contains(@class,'login-page')]";


    public static final String  BTN_LOGIN = "//input[@value='Log in']";
    public static final String MSG_LOGIN_UNSUCCESSFUL = "//div[@class='message-error']//li";
    public static final String  MSG_VALIDATE_EMAIL = "//span[@for='Email']";

}
