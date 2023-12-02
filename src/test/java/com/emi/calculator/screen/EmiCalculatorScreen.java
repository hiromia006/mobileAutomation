package com.emi.calculator.screen;

import com.emi.calculator.screen.baseScreen.BaseScreen;
import com.emi.calculator.util.General;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class EmiCalculatorScreen extends BaseScreen {
    private By btnDetail = By.id("btnDetail");
    private By etLoanAmount = By.id("etLoanAmount");

    public EmiCalculatorScreen(AndroidDriver driver) {
        super(driver);
    }

    public EmiCalculatorScreen fillAmount(int amount) {
        getWebElement(etLoanAmount).clear();
        getWebElement(etLoanAmount).sendKeys(String.valueOf(amount));
        return this;
    }

    public boolean hasAmountEmpty() {
        System.out.println("Amount : "+getWebElement(etLoanAmount).getText().length());
        return getWebElement(etLoanAmount).getText().trim().length() == 1;
    }

    public EmiCalculatorScreen fillInterestRate(double interestRate) {
        getWebElement(By.id("etInterest")).clear();
        getWebElement(By.id("etInterest")).sendKeys(String.valueOf(interestRate));
        return this;
    }


    public EmiCalculatorScreen fillYear(int year) {
        getWebElement(By.id("etYears")).clear();
        getWebElement(By.id("etYears")).sendKeys(String.valueOf(year));
        return this;
    }

    public EmiCalculatorScreen fillMonth(int month) {
        getWebElement(By.id("etMonths")).clear();
        getWebElement(By.id("etMonths")).sendKeys(String.valueOf(month));
        return this;
    }

    public EmiCalculatorScreen fillProcessFee(int fee) {
        getWebElement(By.id("etFee")).clear();
        getWebElement(By.id("etFee")).sendKeys(String.valueOf(fee));
        return this;
    }

    public EmiCalculatorScreen tapCalculateBtn() {
        getWebElement(By.id("btnCalculate")).click();
        return this;
    }

    public EmiCalculatorScreen tapResetBtn() {
        getWebElement(By.id("btnReset")).click();
        return this;
    }

    public EmiDetailsScreen tapDetailBtn() {
        getWebElement(btnDetail).click();
        return getInstance(EmiDetailsScreen.class);
    }

    public boolean hasCalculatedData() {
        return getWebElements(By.id("layoutTable")).size() > 0;
    }

    public boolean hasDetailBtn() {
        General.waitForDomStable();
        return getWebElements(btnDetail).size() > 0;
    }

}

