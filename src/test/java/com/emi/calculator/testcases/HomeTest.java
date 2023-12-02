package com.emi.calculator.testcases;

import com.emi.calculator.screen.HomeScreen;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test
    public void checkCalculatorBtn() {
        HomeScreen homeScreen = screen.getInstance(HomeScreen.class);
        Assert.assertTrue(homeScreen.hasEmiCalculatorBtn());
    }

    @Test
    public void checkCompareBtnLoansBtn() {
        HomeScreen homeScreen = screen.getInstance(HomeScreen.class);
        Assert.assertTrue(homeScreen.hasCompareBtnLoans());
    }
}
