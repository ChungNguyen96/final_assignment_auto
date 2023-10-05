package com.vmo.demowebshop.factorybrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

public class ChromeHeadlessDriverManager implements BrowserFactory{
    @Override
    public WebDriver getBrowserDriver() {
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        options.addArguments("--headless");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-geolocation");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("--incognito");
        return new ChromeDriver(options);
    }
}
