package com.appium.test.emiCalculator;

import com.appium.test.BaseTest;


public class BaseEmiCalculatorTest extends BaseTest {
    @Override
    protected String getAppPackage() {
        return "com.continuum.emi.calculator";
    }

    @Override
    protected String getAppActivity() {
        return "com.finance.emicalci.activity.Splash_screnn";
    }

    public String getValueWithoutFraction(String value) {
        String substring = "";
        if (value.contains(".")) {
            String afterDot = value.split("\\.")[1].trim();
            substring = value.substring(0, (value.length() - (afterDot.length() + 1)));
        } else {
            substring = value;
        }
        return substring;
    }
}
