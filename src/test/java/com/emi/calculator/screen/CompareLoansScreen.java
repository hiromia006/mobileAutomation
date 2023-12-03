package com.emi.calculator.screen;

import com.emi.calculator.screen.baseScreen.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CompareLoansScreen extends BaseScreen {
    public CompareLoansScreen(AndroidDriver driver) {
        super(driver);
    }

    public CompareLoansScreen fillLoan1Amount(int amount) {
        WebElement etLoanAmount1 = getWebElement(By.id("etLoanAmount1"));
        etLoanAmount1.clear();
        etLoanAmount1.sendKeys(String.valueOf(amount));
        return this;
    }

    public CompareLoansScreen fillInterest1(int interest) {
        WebElement etInterest1 = getWebElement(By.id("etInterest1"));
        etInterest1.clear();
        etInterest1.sendKeys(String.valueOf(interest));
        return this;
    }

    public CompareLoansScreen fillMonth1(int month) {
        WebElement etPeriod1 = getWebElement(By.id("etPeriod1"));
        etPeriod1.clear();
        etPeriod1.sendKeys(String.valueOf(month));
        return this;
    }

    public CompareLoansScreen fillLoan2Amount(int amount) {
        WebElement etLoanAmount2 = getWebElement(By.id("etLoanAmount2"));
        etLoanAmount2.clear();
        etLoanAmount2.sendKeys(String.valueOf(amount));
        return this;
    }

    public CompareLoansScreen fillInterest2(int interest) {
        WebElement etInterest2 = getWebElement(By.id("etInterest2"));
        etInterest2.clear();
        etInterest2.sendKeys(String.valueOf(interest));
        return this;
    }

    public CompareLoansScreen fillMonth2(int month) {
        WebElement etPeriod2 = getWebElement(By.id("etPeriod2"));
        etPeriod2.clear();
        etPeriod2.sendKeys(String.valueOf(month));
        return this;
    }

    public boolean hasResultLayout() {
        return getWebElements(By.id("layoutTable")).size() > 0;
    }

    public CompareLoansScreen tapCalculateBtn() {
        getWebElement(By.id("btnCalculate")).click();
        return this;
    }

    public CompareLoansScreen tapResetBtn() {
        getWebElement(By.id("btnReset")).click();
        return this;
    }
}
