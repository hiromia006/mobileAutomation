package com.emi.calculator.testcases;

import com.emi.calculator.screen.baseScreen.BaseScreen;
import com.emi.calculator.screen.baseScreen.Screen;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {
    AndroidDriver driver;
    Screen screen;

    @BeforeClass
    public void setup() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("udid", "192.168.56.101:5555");
            capabilities.setCapability("platformVersion", "12");
            capabilities.setCapability("appPackage", "com.continuum.emi.calculator");
            capabilities.setCapability("appActivity", "com.finance.emicalci.activity.Splash_screnn");
            capabilities.setCapability("platformName", "Android");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            screen = new BaseScreen(driver);

            driver.startRecordingScreen();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterClass
    public void tearDown() {
        recordVideo();
        driver.quit();
    }

    private void recordVideo() {
        String videoData = driver.stopRecordingScreen();
        byte[] data = Base64.decodeBase64(videoData);
        String videoFilePath = System.getProperty("user.dir") + "/build/videos/";

        File file = new File(videoFilePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        System.out.println("Time: " + driver.getDeviceTime());
        String fileName = "Video " + driver.getDeviceTime().replaceAll(":", "-").replace("+", " ") + ".mp4";

        Path path = Paths.get(videoFilePath + fileName);

        try {
            Files.write(path, data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void takeScreenShot() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filePath = System.getProperty("user.dir") + "/build/screenShot/";
        String fileName = "screenShot" + driver.getDeviceTime().replaceAll(":", "-").replace("+", " ") + ".jpg";
        try {
            FileUtils.copyFile(scrFile, new File(filePath + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AndroidDriver getAndroidDriver() {
        return driver;
    }
}
