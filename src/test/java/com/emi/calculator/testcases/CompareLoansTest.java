package com.emi.calculator.testcases;

import com.emi.calculator.screen.CompareLoansScreen;
import com.emi.calculator.screen.HomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareLoansTest extends BaseTest {
    CompareLoansScreen compareLoansScreen;

    @Test(priority = 0)
    public void compareLoansShouldSucceed() {
        HomeScreen homeScreen = screen.getInstance(HomeScreen.class);
        Assert.assertTrue(homeScreen.hasEmiCalculatorBtn());

        compareLoansScreen = homeScreen
                .tabCompareBtnLoans()
                .fillLoan1Amount(250000)
                .fillInterest1(8)
                .fillMonth1(12)
                .fillLoan2Amount(250000)
                .fillInterest2(9)
                .fillMonth2(12)
                .tapCalculateBtn();
        Assert.assertTrue(compareLoansScreen.hasResultLayout());
    }

    @Test(priority = 1)
    public void resetCompareLoansShouldSucceed() {
        compareLoansScreen = compareLoansScreen
                .fillLoan1Amount(250000)
                .fillInterest1(8)
                .fillMonth1(12)
                .fillLoan2Amount(250000)
                .fillInterest2(9)
                .fillMonth2(12)
                .tapCalculateBtn();
        Assert.assertTrue(compareLoansScreen.hasResultLayout());
    }
}
