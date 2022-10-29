package com.emiCalculator.pom.testcases;

import com.emiCalculator.pom.BaseTest.EmiCalculatorBaseTest;
import com.emiCalculator.pom.pages.CompareLoanPage;
import com.emiCalculator.pom.pages.LandingPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CompareLoanTest extends EmiCalculatorBaseTest {
    CompareLoanPage compareLoanPage;

    @BeforeClass
    public void initialization() {
        compareLoanPage = new LandingPage()
                .tapCompareLoan();
    }

    @Test
    public void compareLoanShouldSucceed() {
        compareLoanPage = compareLoanPage
                .fillLoanAmount1(25000)
                .fillInterest1(8)
                .fillPeriod1(12)
                .fillLoanAmount2(20000)
                .fillInterest2(9)
                .fillPeriod2(11)
                .tapBtnCalculate();
    }

    @Test
    public void resetLoanShouldSucceed() {
        compareLoanPage = compareLoanPage
                .fillLoanAmount1(23000)
                .fillInterest1(9)
                .fillPeriod1(12)
                .fillLoanAmount2(28000)
                .fillInterest2(14)
                .fillPeriod2(11)
                .tapBtnReset();
    }

}
