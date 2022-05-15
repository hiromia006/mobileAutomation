package com.appium.test;


import com.appium.util.GeneralUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import static com.appium.util.GeneralUtil.WAIT_LOADING_TIME;

public abstract class BaseTest extends BaseExtentReportsTest {
    protected AndroidDriver driver;
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

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        wait = new WebDriverWait(driver, Duration.ofSeconds(GeneralUtil.WAIT_TIME));

        //Start recording screen
        driver.startRecordingScreen();

    }


    @AfterClass
    public void tearDown() {
        stopRecording();
        driver.quit();
    }

    private void stopRecording() {
        String projectHomeDirectory = System.getProperty("user.dir");
        String base64String = driver.stopRecordingScreen();
        byte[] data = Base64.decodeBase64(base64String);
        String destinationPath = projectHomeDirectory + "/build/videos";
        File theDir = new File(destinationPath);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }

        String filePath = destinationPath + "/" + driver.getDeviceTime().replace(":", "_").replace("+", " ") + ".mp4";
        System.out.println("filePath : " + filePath);
        Path path = Paths.get(filePath);
        try {
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitForLoading(By locator) {
        boolean hasWebElement = driver.findElements(locator).size() == 0;
        int iteration = 0;
        while (hasWebElement && (iteration < 500)) {
            try {
                Thread.sleep(WAIT_LOADING_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            iteration = iteration + 1;
            hasWebElement = driver.findElements(locator).size() == 0;
        }
    }
}
