package com.appium.test.emiCalculator.pom.test;

import com.appium.test.emiCalculator.pom.BaseTestAppium;
import com.appium.test.emiCalculator.pom.pages.CompareLoanPage;
import com.appium.test.emiCalculator.pom.pages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CompareLoanTest extends BaseTestAppium {
    CompareLoanPage compareLoanPage;

    @BeforeClass
    public void setup() {
        initialization();
        compareLoanPage = new HomePage().tapCompareBtn();
    }

    @Test
    public void compareLoanShouldSucceed() {
        compareLoanPage = compareLoanPage
                .fillLoanAmount1(10000)
                .fillInterest1(8)
                .fillPeriod1(12)
                .fillLoanAmount2(15000)
                .fillInterest2(7)
                .fillPeriod2(3)
                .clickCalculateBtn();
    }

    @Test
    public void resetLoanShouldSucceed() {
        compareLoanPage = compareLoanPage
                .fillLoanAmount1(1000)
                .fillInterest1(9)
                .fillPeriod1(15)
                .fillLoanAmount2(3000)
                .fillInterest2(7)
                .fillPeriod2(2)
                .clickRestBtn();
    }

    @AfterClass
    public void dearDown() {
        driver.quit();
    }
}
