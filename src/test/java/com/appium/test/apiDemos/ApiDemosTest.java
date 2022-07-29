package com.appium.test.apiDemos;


import com.appium.util.GeneralUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
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
        GeneralUtil.longWaitForDomStable();

//        scrollToMiddle();
//        GeneralUtil.longWaitForDomStable();
        webElements = driver.findElements(By.id("android:id/text1"));
        System.out.println("Size =: " + webElements.size());

        System.out.println("Text := " + webElements.get(webElements.size() - 1).getText());
        System.out.println("Location := " + webElements.get(webElements.size() - 1).getLocation());

        Dimension dimension = driver.manage().window().getSize();

        int startX = dimension.getWidth() / 2;
        int endX = dimension.getWidth() / 2;
        System.out.println("startX =: " + startX + "  endX =: " + endX);

        int startY = (int) (dimension.getHeight() * .50);
        int endY = (int) (dimension.getHeight() * .10);

        System.out.println("startY =: " + startY + "  endY =: " + endY);
//        new TouchAction(driver).press(PointOption.point(startX, startY)).waitAction().moveTo(PointOption.point(endX, endY)).release().perform();
//        GeneralUtil.waitForDomStable();

        new TouchActions(driver).scroll(webElements.get(3), 0, 1200).perform();

        GeneralUtil.longWaitForDomStable();
//        scrollToMiddle();
//
//        webElements = driver.findElements(By.id("android:id/text1"));
//        wait.until(ExpectedConditions.elementToBeClickable(webElements.get(2))).click();
//
//        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("android:id/text1")))).click();
    }
}
