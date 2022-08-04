package com.appium.test.emiCalculator.pom.pages;

import com.appium.test.emiCalculator.pom.BaseTestAppium;
import com.appium.test.emiCalculator.pom.util.AppiumUtil;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class EmiCalculatorPage extends BaseTestAppium {
    @AndroidFindBy(id = "etLoanAmount")
    WebElement etLoanAmount;

    @AndroidFindBy(id = "etInterest")
    WebElement etInterest;

    @AndroidFindBy(id = "etYears")
    WebElement etYears;

    @AndroidFindBy(id = "etMonths")
    WebElement etMonths;

    @AndroidFindBy(id = "etFee")
    WebElement etFee;

    @AndroidFindBy(id = "btnCalculate")
    WebElement btnCalculate;

    @AndroidFindBy(id = "btnReset")
    WebElement btnReset;

    @AndroidFindBy(id = "btnDetail")
    WebElement btnDetail;

    public EmiCalculatorPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(AppiumUtil.LOAD_TIME)), this);
    }

    public EmiCalculatorPage fillAmount(int amount) {
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

    public EmiCalculatorPage fillYears(int years) {
        etYears.isDisplayed();
        etYears.clear();
        etYears.sendKeys(String.valueOf(years));
        return this;
    }

    public EmiCalculatorPage fillMonths(int months) {
        etMonths.isDisplayed();
        etMonths.clear();
        etMonths.sendKeys(String.valueOf(months));
        return this;
    }

    public EmiCalculatorPage fillFees(int fees) {
        etFee.isDisplayed();
        etFee.sendKeys(String.valueOf(fees));
        return this;
    }

    public EmiCalculatorPage tapBtnCalculate() {
        btnCalculate.isDisplayed();
        btnCalculate.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public EmiCalculatorPage tapResetCalculateBtn() {
        btnReset.isDisplayed();
        btnReset.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }


    public EmiCalculatorPage tapDetailCalculateBtn() {
        btnReset.isDisplayed();
        btnReset.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
