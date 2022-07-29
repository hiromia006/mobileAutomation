package com.appium.test.emiCalculator.pom.test;

import com.appium.test.emiCalculator.BaseEmiCalculatorTest;
import com.appium.test.emiCalculator.pom.pages.EmiCalculatorPage;
import com.appium.test.emiCalculator.pom.pages.HomePage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EmiCalculatorTest extends BaseEmiCalculatorTest {
    EmiCalculatorPage emiCalculatorPage;

    @BeforeClass
    public void setup() {
        initialization();

        emiCalculatorPage = new HomePage()
                .clickEmiCalculatorBtn();
    }

    @Test
    public void calculateEmiShouldSucceed() {
        emiCalculatorPage = emiCalculatorPage
                .fillAmount(10000)
                .fillInterest(8)
                .fillYear(1)
                .fillMonth(8)
                .fillFee(2)
                .clickCalculateBtn();
    }


    @AfterClass
    public void dearDown() {
        stopRecording();
        driver.quit();

    }
}
