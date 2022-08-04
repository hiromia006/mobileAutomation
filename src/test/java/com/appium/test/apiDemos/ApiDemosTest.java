package com.appium.test.apiDemos;


import com.appium.util.GeneralUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class ApiDemosTest extends BaseApiDemosTest {
    @BeforeClass
    public void setup() {
        initialization();
    }

    @Test
    public void apiDemos() {
        List<WebElement> webElements = driver.findElements(By.id("android:id/text1"));
        wait.until(ExpectedConditions.elementToBeClickable(webElements.get(10)));

        System.out.println(webElements.get(10).getText().trim());
        webElements.get(10).click();
        GeneralUtil.longWaitForDomStable();

        GeneralUtil.longWaitForDomStable();
        scrollToMiddle();

        webElements = driver.findElements(By.id("android:id/text1"));
        wait.until(ExpectedConditions.elementToBeClickable(webElements.get(2))).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("android:id/text1")))).click();
    }

    @Test
    public void appiumFeatures() throws InterruptedException {
        List<WebElement> webElements = driver.findElements(By.id("android:id/text1"));
        wait.until(ExpectedConditions.elementToBeClickable(webElements.get(10)));

        System.out.println(webElements.get(10).getText().trim());
        webElements.get(10).click();
        GeneralUtil.longWaitForDomStable();
        Thread.sleep(3000);

        webElements = driver.findElements(By.id("android:id/text1"));

        Thread.sleep(3000);

        new TouchActions(driver)
                .scroll(webElements.get(2), webElements.get(2).getSize().height, 1200)
                .perform();

        Thread.sleep(3000);


    }

    @AfterClass
    public void tearDown() {
        stopRecording();
        driver.quit();
    }
}
