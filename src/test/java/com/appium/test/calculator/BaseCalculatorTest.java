package com.appium.test.calculator;

import com.appium.test.BaseTest;

public class BaseCalculatorTest extends BaseTest {
    @Override
    protected String getAppPackage() {
        return "com.sec.android.app.popupcalculato";
    }

    @Override
    protected String getAppActivity() {
        return "com.sec.android.app.popupcalculator.Calculator";
    }
}
