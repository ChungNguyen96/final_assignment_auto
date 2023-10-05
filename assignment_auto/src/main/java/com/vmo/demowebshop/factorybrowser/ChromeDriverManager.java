package com.vmo.demowebshop.factorybrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }
}
