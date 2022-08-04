package com.appium.test.emiCalculator.pom;

import com.appium.util.GeneralUtil;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTestAppium {
    static public AndroidDriver driver;

    public void initialization() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("udid", "R8KR5000D4B");
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("platformVersion", "11");
            desiredCapabilities.setCapability("appPackage", "com.continuum.emi.calculator");
            desiredCapabilities.setCapability("appActivity", "com.finance.emicalci.activity.Splash_screnn");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GeneralUtil.WAIT_TIME));
    }
}
