package com.appium.test.emiCalculator;


import com.appium.config.ReadCsv;
import com.appium.util.EmiPayment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmiCalculatorTest extends BaseEmiCalculatorTest {
    @Test
    public void emiCalculatorTest() {
        By btnStart = By.id("btnStart");
        waitForLoading(btnStart);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(btnStart))).click();

        By etLoanAmount = By.id("etLoanAmount");
        waitForLoading(etLoanAmount);
        WebElement webElement = driver.findElement(etLoanAmount);
        webElement.isDisplayed();
        webElement.sendKeys("100000");

        By etInterest = By.id("etInterest");
        waitForLoading(etInterest);
        WebElement etInterestEl = driver.findElement(etInterest);
        etInterestEl.isDisplayed();
        etInterestEl.sendKeys("8");

        //etYears
        By etYears = By.id("etYears");
        waitForLoading(etYears);
        WebElement etYearsEl = driver.findElement(etYears);
        etYearsEl.isDisplayed();
        etYearsEl.sendKeys("1");

        //etYears
        By etMonths = By.id("etMonths");
        waitForLoading(etMonths);
        WebElement etMonthsEl = driver.findElement(etMonths);
        etMonthsEl.isDisplayed();
        etMonthsEl.sendKeys("8");

        //etFee
        By etFee = By.id("etFee");
        waitForLoading(etFee);
        WebElement etFeeEl = driver.findElement(etFee);
        etFeeEl.isDisplayed();
        etFeeEl.sendKeys("2");

        //btnCalculate
        By btnCalculate = By.id("btnCalculate");
        waitForLoading(btnCalculate);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(btnCalculate))).click();

        WebElement monthlyEmiResultEl = driver.findElement(By.id("monthly_emi_result"));
        monthlyEmiResultEl.isDisplayed();
        String monthlyEmiResult = monthlyEmiResultEl.getText().trim().replaceAll(",", "");
        System.out.println("monthlyEmiResult : " + monthlyEmiResult);
        Assert.assertEquals("5357.36", monthlyEmiResult);


        WebElement totalInterestResultEl = driver.findElement(By.id("total_interest_result"));
        totalInterestResultEl.isDisplayed();
        String totalInterestResult = totalInterestResultEl.getText().trim().replaceAll(",", "");
        System.out.println("totalInterestResult : " + totalInterestResult);
        Assert.assertEquals("7147.24", totalInterestResult);

        WebElement processing_fee_result_el = driver.findElement(By.id("processing_fee_result"));
        processing_fee_result_el.isDisplayed();
        String processing_fee_result = processing_fee_result_el.getText().trim().replaceAll(",", "");
        System.out.println("processing_fee_result : " + processing_fee_result);
        Assert.assertEquals("2000", processing_fee_result);


        WebElement total_payment_result_el = driver.findElement(By.id("total_payment_result"));
        total_payment_result_el.isDisplayed();
        String total_payment_result = total_payment_result_el.getText().trim().replaceAll(",", "");
        System.out.println("total_payment_result : " + total_payment_result);
        Assert.assertEquals("107147.24", total_payment_result);

        //btnReset
        By btnReset = By.id("btnReset");
        waitForLoading(btnReset);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(btnReset))).click();

    }


    // BDT - Behavior Driven Testing
    @Test
    public void emiCalculatorBdtTest() {
        By btnStart = By.id("btnStart");
        waitForLoading(btnStart);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(btnStart))).click();

        for (EmiPayment emiPayment : ReadCsv.getEmiPayments()) {
            By etLoanAmount = By.id("etLoanAmount");
            waitForLoading(etLoanAmount);
            WebElement webElement = driver.findElement(etLoanAmount);
            webElement.isDisplayed();
            webElement.sendKeys(emiPayment.getLoan());

            By etInterest = By.id("etInterest");
            waitForLoading(etInterest);
            WebElement etInterestEl = driver.findElement(etInterest);
            etInterestEl.isDisplayed();
            etInterestEl.sendKeys(emiPayment.getInterest());

            //etYears
            By etYears = By.id("etYears");
            waitForLoading(etYears);
            WebElement etYearsEl = driver.findElement(etYears);
            etYearsEl.isDisplayed();
            etYearsEl.sendKeys(emiPayment.getPeriod());

            //etFee
            By etFee = By.id("etFee");
            waitForLoading(etFee);
            WebElement etFeeEl = driver.findElement(etFee);
            etFeeEl.isDisplayed();
            etFeeEl.sendKeys(emiPayment.getpFee());

            //btnCalculate
            By btnCalculate = By.id("btnCalculate");
            waitForLoading(btnCalculate);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(btnCalculate))).click();

            WebElement monthlyEmiResultEl = driver.findElement(By.id("monthly_emi_result"));
            monthlyEmiResultEl.isDisplayed();
            String monthlyEmiResult = monthlyEmiResultEl.getText().trim().replaceAll(",", "");
            System.out.println(emiPayment.getmEMI() + " monthlyEmiResult : " + getValueWithoutFraction(monthlyEmiResult));
            Assert.assertEquals(emiPayment.getmEMI(), getValueWithoutFraction(monthlyEmiResult));


            WebElement totalInterestResultEl = driver.findElement(By.id("total_interest_result"));
            totalInterestResultEl.isDisplayed();
            String totalInterestResult = totalInterestResultEl.getText().trim().replaceAll(",", "");
            System.out.println(emiPayment.gettInterest() + " totalInterestResult : " + getValueWithoutFraction(totalInterestResult));
            Assert.assertEquals(emiPayment.gettInterest(), getValueWithoutFraction(totalInterestResult));

            WebElement processing_fee_result_el = driver.findElement(By.id("processing_fee_result"));
            processing_fee_result_el.isDisplayed();
            String processing_fee_result = processing_fee_result_el.getText().trim().replaceAll(",", "");
            System.out.println(emiPayment.getTpFee() + " processing_fee_result : " + getValueWithoutFraction(processing_fee_result));
            Assert.assertEquals(emiPayment.getTpFee(), getValueWithoutFraction(processing_fee_result));


            WebElement total_payment_result_el = driver.findElement(By.id("total_payment_result"));
            total_payment_result_el.isDisplayed();
            String total_payment_result = total_payment_result_el.getText().trim().replaceAll(",", "");
            System.out.println(emiPayment.gettPayment() + "total_payment_result : " + getValueWithoutFraction(total_payment_result));
            Assert.assertEquals(emiPayment.gettPayment(), getValueWithoutFraction(total_payment_result));

            //btnReset
            By btnReset = By.id("btnReset");
            waitForLoading(btnReset);
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(btnReset))).click();
        }
    }
}
