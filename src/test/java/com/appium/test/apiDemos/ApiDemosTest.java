package com.appium.test.apiDemos;


import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

public class ApiDemosTest extends BaseApiDemosTest {
    @Test
    public void apiDemos() {
        List<WebElement> webElements = driver.findElements(By.id("android:id/text1"));
        wait.until(ExpectedConditions.elementToBeClickable(webElements.get(10)));

        System.out.println(webElements.get(10).getText().trim());
        webElements.get(10).click();
        scrollToMiddle();

        webElements = driver.findElements(By.id("android:id/text1"));
        wait.until(ExpectedConditions.elementToBeClickable(webElements.get(2))).click();

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("android:id/text1")))).click();
    }
}
