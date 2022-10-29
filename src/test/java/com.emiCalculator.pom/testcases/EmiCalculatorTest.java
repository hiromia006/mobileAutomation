package com.emiCalculator.pom.testcases;

import com.emiCalculator.pom.BaseTest.EmiCalculatorBaseTest;
import com.emiCalculator.pom.pages.EmiCalculatorPage;
import com.emiCalculator.pom.pages.LandingPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmiCalculatorTest extends EmiCalculatorBaseTest {
    EmiCalculatorPage emiCalculatorPage;

    @BeforeClass
    public void initialization() {
        emiCalculatorPage = new LandingPage()
                .tapEmiCalculator();
    }

    @Test
    public void calculateEmiShouldSucceed() {
        emiCalculatorPage = emiCalculatorPage
                .fillLoanAmount(30000)
                .fillInterest(8)
                .fillYear(1)
                .fillMonths(7)
                .fillProcessFee(2)
                .tapBtnCalculate();
    }

    @Test
    public void calculateEmiDetailsShouldSucceed() {
        emiCalculatorPage = emiCalculatorPage
                .fillLoanAmount(30000)
                .fillInterest(8)
                .fillYear(1)
                .fillMonths(7)
                .fillProcessFee(2)
                .tapBtnCalculate()
                .tapBtnDetail()
                .tapMenuBack();
    }

    @Test
    public void resetEmiShouldSucceed() {
        emiCalculatorPage = emiCalculatorPage
                .fillLoanAmount(35000)
                .fillInterest(9)
                .fillYear(1)
                .fillMonths(7)
                .fillProcessFee(6)
                .tapBtnCalculate();
    }
}
