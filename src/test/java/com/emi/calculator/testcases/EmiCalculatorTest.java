package com.emi.calculator.testcases;

import com.emi.calculator.screen.EmiCalculatorScreen;
import com.emi.calculator.screen.EmiDetailsScreen;
import com.emi.calculator.screen.HomeScreen;
import com.emi.calculator.util.General;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EmiCalculatorTest extends BaseTest {
    EmiCalculatorScreen emiCalculatorScreen;
    EmiDetailsScreen emiDetailsScreen;

    @Test(priority = 0)
    public void calculateEmiShouldSucceed() {
        HomeScreen homeScreen = screen.getInstance(HomeScreen.class);
        Assert.assertTrue(homeScreen.hasEmiCalculatorBtn());

        emiCalculatorScreen = homeScreen
                .tabEmiCalculatorBtn()
                .fillAmount(1000000)
                .fillInterestRate(7.5)
                .fillYear(3)
                .fillMonth(2)
                .fillProcessFee(2)
                .tapCalculateBtn();
        Assert.assertTrue(emiCalculatorScreen.hasDetailBtn());
        Assert.assertTrue(emiCalculatorScreen.hasCalculatedData());
    }

    @Test(priority = 1, enabled = false)
    public void resetEmiShouldSucceed() {
        emiCalculatorScreen = emiCalculatorScreen
                .tapResetBtn();
        Assert.assertFalse(emiCalculatorScreen.hasAmountEmpty());
    }

    @Test(priority = 2, enabled = false)
    public void checkLoanDetail() {
        emiDetailsScreen = emiCalculatorScreen
                .fillAmount(1000000)
                .fillInterestRate(7.5)
                .fillYear(3)
                .fillMonth(2)
                .fillProcessFee(2)
                .tapCalculateBtn()
                .tapDetailBtn();
        Assert.assertTrue(emiDetailsScreen.hasLoanDetail());

    }

    @Test(priority = 3, enabled = false)
    public void checkBackBtnOperation() {
        EmiCalculatorScreen emiCalculatorScreen = emiDetailsScreen
                .tapBackBtn();
        Assert.assertTrue(emiCalculatorScreen.hasDetailBtn());
    }

    @Test(priority = 4, dataProvider = "getEmiData")
    public void calculateEmiShouldSucceed2(String amount, String rate, String year, String month, String fee) {
        System.out.println("Amount "+amount+" rate "+ rate);
        emiCalculatorScreen = emiCalculatorScreen
                .fillAmount(Integer.valueOf(amount.replace(".0", "").trim()))
                .fillInterestRate(Double.valueOf(rate.replace(".0", "").trim()))
                .fillYear(Integer.valueOf(year.replace(".0", "").trim()))
                .fillMonth(Integer.valueOf(month.replace(".0", "").trim()))
                .fillProcessFee(Integer.valueOf(fee.replace(".0", "").trim()))
                .tapCalculateBtn();
        Assert.assertTrue(emiCalculatorScreen.hasDetailBtn());

    }


    @DataProvider
    public static Object[][] getEmiData() {
        return General.getTestData("Sheet1");
    }

}
