package com.emi.calculator.screen.baseScreen;

import com.aventstack.extentreports.Status;
import com.emi.calculator.report.ReportTestManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BaseScreen extends Screen {
    public BaseScreen(AndroidDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getWebElement(By selector) {
        WebElement webElement = null;
        try {
            addInfo(selector.toString() + " going to operate");
            waitForWebElement(selector);
            webElement = driver.findElement(selector);
            addInfo(selector.toString() + " already did successfully operation");
        } catch (Exception e) {
            System.out.println(selector.toString() + " Select or Locator Not Found");
        }
        return webElement;
    }

    @Override
    public List<WebElement> getWebElements(By selector) {
        List<WebElement> webElements = null;
        try {
            addInfo(selector.toString() + " going to operate");
            waitForWebElement(selector);
            webElements = driver.findElements(selector);
            addInfo(selector.toString() + " already did successfully operation");

        } catch (Exception e) {
            System.out.println(selector.toString() + " Select or Locator Not Found");
        }
        return webElements;
    }

    @Override
    public void waitForWebElement(By selector) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        } catch (Exception e) {
            System.out.println(selector.toString() + " Select or Locator Not Found");
        }

    }

    public void addInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.INFO, message);
        }
    }
}
