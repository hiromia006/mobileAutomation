package com.appium.test.calculator;

import com.appium.test.BaseTest;

public class BaseCalculatorTest extends BaseTest {
    @Override
    protected String getAppPackage() {
        return "com.google.android.calculator";
    }

    @Override
    protected String getAppActivity() {
        return "com.android.calculator2.Calculator";
    }
}
