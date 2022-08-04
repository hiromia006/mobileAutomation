package com.appium.test.emiCalculator.pom.pages;

import com.appium.test.emiCalculator.pom.BaseTestAppium;
import com.appium.test.emiCalculator.pom.util.AppiumUtil;
import com.appium.util.GeneralUtil;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class CompareLoanPage extends BaseTestAppium {
    @AndroidFindBy(id = "etLoanAmount1")
    WebElement loan1AmountEl;

    @AndroidFindBy(id = "etInterest1")
    WebElement etIntereSt1El;

    @AndroidFindBy(id = "etPeriod1")
    WebElement etPeriod1El;

    @AndroidFindBy(id = "etLoanAmount2")
    WebElement etLoanAmount2El;

    @AndroidFindBy(id = "etInterest2")
    WebElement etInterest2El;

    @AndroidFindBy(id = "etPeriod2")
    WebElement etPeriod2El;

    @AndroidFindBy(id = "btnCalculate")
    WebElement btnCalculate;

    @AndroidFindBy(id = "btnReset")
    WebElement btnReset;

    public CompareLoanPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(AppiumUtil.LOAD_TIME)),
                this);
    }

    public CompareLoanPage fillLoanAmount1(int amount) {
        loan1AmountEl.isDisplayed();
        loan1AmountEl.clear();
        loan1AmountEl.sendKeys(String.valueOf(amount));
        return this;
    }

    public CompareLoanPage fillInterest1(int interest1) {
        etIntereSt1El.isDisplayed();
        etIntereSt1El.clear();
        etIntereSt1El.sendKeys(String.valueOf(interest1));
        return this;
    }

    public CompareLoanPage fillPeriod1(int period) {
        etPeriod1El.isDisplayed();
        etPeriod1El.clear();
        etPeriod1El.sendKeys(String.valueOf(period));
        return this;
    }

    public CompareLoanPage fillLoanAmount2(int amount2) {
        etLoanAmount2El.isDisplayed();
        etLoanAmount2El.clear();
        etLoanAmount2El.sendKeys(String.valueOf(amount2));
        return this;
    }

    public CompareLoanPage fillInterest2(int interest2) {
        etInterest2El.isDisplayed();
        etInterest2El.clear();
        etInterest2El.sendKeys(String.valueOf(interest2));
        return this;
    }

    public CompareLoanPage fillPeriod2(int period2) {
        etPeriod2El.isDisplayed();
        etPeriod2El.clear();
        etPeriod2El.sendKeys(String.valueOf(period2));
        return this;
    }

    public CompareLoanPage clickCalculateBtn() {
        btnCalculate.isDisplayed();
        btnCalculate.click();
        return this;
    }

    public CompareLoanPage clickRestBtn() {
        btnReset.isDisplayed();
        btnReset.click();
        GeneralUtil.longWaitForDomStable();
        return this;
    }

}
