package com.vmo.demowebshop.factoryenvironment;

import com.vmo.demowebshop.factorybrowser.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalFactory {
    private WebDriver driver;
    public WebDriver createBrowser(String browser){
        browser = browser.toLowerCase();
        switch (browser){
            case "chrome":
                driver = new ChromeDriverManager().getBrowserDriver();
                break;
            case "edge":
                driver = new EdgeDriverManager().getBrowserDriver();
                break;
            case "firefox":
                driver = new FirefoxDriverManager().getBrowserDriver();
                break;
            case "chrome-headless":
                driver = new ChromeHeadlessDriverManager().getBrowserDriver();
                break;

            default:
                throw new BrowserNotSupportException(browser);
        }
        return driver;

    }
}
