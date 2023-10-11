package com.vmo.demowebshop.helper;

import com.vmo.demowebshop.common.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("-----------Test start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("--------Test success");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        saveScreenShot(webDriver);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info("---------- " + result.getName() + " FAILED test ----------");
        Object testClass = result.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
        saveScreenShot(webDriver);
    }
    @Attachment()
    public  static byte[] saveScreenShot(WebDriver driver){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onStart(ITestContext context) { // khi chajy thi vao day dau tien
        System.out.println("-----Start");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("-------Finish");
    }
}
