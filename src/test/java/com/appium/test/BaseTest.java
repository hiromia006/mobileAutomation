package com.appium.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public abstract class BaseTest extends BaseExtentReportsTest {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

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

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
