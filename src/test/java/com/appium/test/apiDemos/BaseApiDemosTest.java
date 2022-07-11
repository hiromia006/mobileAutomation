package com.appium.test.apiDemos;


import com.appium.test.BaseTest;

public class BaseApiDemosTest extends BaseTest {
    @Override
    protected String getAppPackage() {
        return "com.hmh.api";
    }

    @Override
    protected String getAppActivity() {
        return ".ApiDemos";
    }
}
