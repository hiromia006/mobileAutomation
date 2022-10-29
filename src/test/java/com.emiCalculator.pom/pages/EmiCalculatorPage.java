package com.emiCalculator.pom.pages;

import com.emiCalculator.pom.BaseTest.EmiCalculatorBaseTest;
import com.emiCalculator.pom.util.GeneralUtil;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class EmiCalculatorPage extends EmiCalculatorBaseTest {
    @AndroidBy(id = "etLoanAmount")
    WebElement etLoanAmount;

    @AndroidBy(id = "etInterest")
    WebElement etInterest;

    @AndroidBy(id = "etYears")
    WebElement etYears;

    @AndroidBy(id = "etMonths")
    WebElement etMonths;

    @AndroidBy(id = "etFee")
    WebElement etFee;

    @AndroidBy(id = "btnCalculate")
    WebElement btnCalculate;

    @AndroidBy(id = "btnReset")
    WebElement btnReset;

    @AndroidBy(id = "btnDetail")
    WebElement btnDetail;

    public EmiCalculatorPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(GeneralUtil.LOAD_TIME)), this);
    }

    public EmiCalculatorPage fillLoanAmount(int amount) {
        etLoanAmount.isDisplayed();
        etLoanAmount.clear();
        etLoanAmount.sendKeys(String.valueOf(amount));
        return this;
    }

    public EmiCalculatorPage fillInterest(int interest) {
        etInterest.isDisplayed();
        etInterest.clear();
        etInterest.sendKeys(String.valueOf(interest));
        return this;
    }

    public EmiCalculatorPage fillYear(int year) {
        etYears.isDisplayed();
        etYears.clear();
        etYears.sendKeys(String.valueOf(year));
        return this;
    }

    public EmiCalculatorPage fillMonths(int months) {
        etMonths.isDisplayed();
        etMonths.clear();
        etMonths.sendKeys(String.valueOf(months));
        return this;
    }

    public EmiCalculatorPage fillProcessFee(int fee) {
        etFee.isDisplayed();
        etFee.clear();
        etFee.sendKeys(String.valueOf(fee));
        return this;
    }

    public EmiCalculatorPage tapBtnCalculate() {
        btnCalculate.isDisplayed();
        btnCalculate.click();
        return this;
    }

    public EmiCalculatorPage tapBtnReset() {
        btnReset.isDisplayed();
        btnReset.click();
        return this;
    }

    public EmiDetailPage tapBtnDetail() {
        btnDetail.isDisplayed();
        btnDetail.click();
        return new EmiDetailPage();
    }
}
