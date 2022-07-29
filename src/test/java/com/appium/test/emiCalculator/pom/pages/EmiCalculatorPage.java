package com.appium.test.emiCalculator.pom.pages;

import com.appium.test.emiCalculator.BaseEmiCalculatorTest;
import com.appium.util.GeneralUtil;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class EmiCalculatorPage extends BaseEmiCalculatorTest {
    @AndroidFindBy(id = "etLoanAmount")
    WebElement amountEL;

    @AndroidFindBy(id = "etInterest")
    WebElement interestEl;

    @AndroidFindBy(id = "etYears")
    WebElement yearEl;

    @AndroidFindBy(id = "etMonths")
    WebElement monthEl;

    @AndroidFindBy(id = "etFee")
    WebElement feeEl;

    @AndroidFindBy(id = "btnCalculate")
    WebElement calculateBtn;

    @AndroidFindBy(id = "btnReset")
    WebElement btnReset;

    public EmiCalculatorPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(GeneralUtil.WAIT_TIME)), this);
    }

    public EmiCalculatorPage fillAmount(int amount) {
        amountEL.isDisplayed();
        amountEL.sendKeys(String.valueOf(amount));
        return this;
    }

    public EmiCalculatorPage fillInterest(int interest) {
        interestEl.isDisplayed();
        interestEl.sendKeys(String.valueOf(interest));
        return this;
    }

    public EmiCalculatorPage fillYear(int year) {
        yearEl.isDisplayed();
        yearEl.sendKeys(String.valueOf(year));
        return this;
    }

    public EmiCalculatorPage fillMonth(int month) {
        monthEl.isDisplayed();
        monthEl.sendKeys(String.valueOf(month));
        return this;
    }

    public EmiCalculatorPage fillFee(int fee) {
        feeEl.isDisplayed();
        feeEl.sendKeys(String.valueOf(fee));
        return this;
    }

    public EmiCalculatorPage clickCalculateBtn() {
        calculateBtn.isDisplayed();
        calculateBtn.click();
        return this;
    }

    public EmiCalculatorPage resetCalculateBtn() {
        btnReset.isDisplayed();
        btnReset.click();
        return this;
    }
}
