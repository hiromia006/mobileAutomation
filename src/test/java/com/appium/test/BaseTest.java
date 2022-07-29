package com.appium.test;


import com.appium.util.GeneralUtil;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    static protected AndroidDriver driver;
    protected WebDriverWait wait;

    protected abstract String getAppPackage();

    protected abstract String getAppActivity();

    public void initialization() {
        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "samsung SM T225");
            desiredCapabilities.setCapability("udid", "R8KR5000D4B");
            desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desiredCapabilities.setCapability("platformVersion", "11");
            desiredCapabilities.setCapability("appPackage", getAppPackage());
            desiredCapabilities.setCapability("appActivity", getAppActivity());
            desiredCapabilities.setCapability("noReset", "true");
            desiredCapabilities.setCapability("fullReset", "false");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        wait = new WebDriverWait(driver, Duration.ofSeconds(GeneralUtil.WAIT_TIME));

        //Start recording screen
        driver.startRecordingScreen();

    }


    public void tearDown() {
        stopRecording();
        driver.quit();
    }

    protected void stopRecording() {
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


    protected void scrollToMiddle() {
        Dimension dimension = driver.manage().window().getSize();
        System.out.println("X =: " + dimension.width + "  Y =: " + dimension.height);
        System.out.println("X =: " + dimension.getWidth() + "  Y =: " + dimension.getHeight());
        int startX = dimension.getWidth() / 2;
        int endX = dimension.getWidth() / 2;

        int startY = (int) (dimension.getHeight() * .50);
        int endY = (int) (dimension.getHeight() * .10);
        new TouchAction(driver).press(PointOption.point(startX, startY)).waitAction().moveTo(PointOption.point(endX, endY)).release().perform();
        GeneralUtil.waitForDomStable();

    }

    protected void scrollToBottom() {
        Dimension dim = driver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width / 2;
        int top_y = (int) (height * 0.80);
        int bottom_y = (int) (height * 0.20);
        System.out.println("coordinates :" + x + "  " + top_y + " " + bottom_y);
        TouchAction ts = new TouchAction(driver);
        ts.press(PointOption.point(x, top_y)).moveTo(PointOption.point(x, bottom_y)).release().perform();
        GeneralUtil.waitForDomStable();
    }
}
