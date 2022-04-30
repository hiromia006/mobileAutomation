package com.appium.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest extends BaseExtentReportsTest {
    public AppiumDriver appiumDriver;

    protected abstract String getAppPackage();

    protected abstract String getAppActivity();

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "samsung SM T225");
        desiredCapabilities.setCapability("udid", "R8KR5001TLA");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability("platformVersion", "11");
        desiredCapabilities.setCapability("appPackage", getAppPackage());
        desiredCapabilities.setCapability("appActivity", getAppActivity());

        appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

    }


    @AfterClass
    public void tearDown() {
        appiumDriver.quit();
    }
}
