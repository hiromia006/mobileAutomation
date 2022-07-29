package com.appium.test.calculator;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Calculator3Test {
    protected static AndroidDriver driver;
    private static WebDriverWait wait;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("udid", "R8KR5000D4B");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability("platformVersion", "11");
        desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        desiredCapabilities.setCapability("appActivity", ".Calculator");


        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        Thread.sleep(3000);
        driver.findElement(By.id("calc_keypad_btn_07")).click();

        Thread.sleep(2000);
        driver.findElement(By.id("calc_keypad_btn_add")).click();

        Thread.sleep(2000);
        driver.findElement(By.id("calc_keypad_btn_09")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("calc_keypad_btn_equal")).click();
        Thread.sleep(2000);

        driver.rotate(ScreenOrientation.LANDSCAPE);
        Thread.sleep(2000);
        driver.rotate(ScreenOrientation.PORTRAIT);
        Thread.sleep(2000);


        driver.quit();
    }
}
