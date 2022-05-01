package com.appium.test.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class CalculatorTest extends BaseCalculatorTest {
    @Test
    public void addSingleDigitShouldSucceed() {
        WebElement webElement7 = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
        wait.until(elementToBeClickable(webElement7)).click();

        WebElement webElementInput = driver.findElement(By.id("com.google.android.calculator:id/formula"));
        webElementInput.isDisplayed();
        String firstInput = webElementInput.getText().trim();
        System.out.println("Input : " + firstInput);

        wait.until(elementToBeClickable(driver.findElement(By.id("com.google.android.calculator:id/op_add")))).click();

        WebElement webElement9 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
        wait.until(elementToBeClickable(webElement9)).click();
        String secondInput = webElementInput.getText().trim().split("\\+")[1].trim();
        System.out.println("Input2 : " + secondInput);

        wait.until(elementToBeClickable(driver.findElement(By.id("com.google.android.calculator:id/eq")))).click();
        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText().trim();
        System.out.println("Sum : " + result);

        Assert.assertEquals((Integer.parseInt(firstInput) + Integer.parseInt(secondInput)), Integer.parseInt(result));
    }

    @Test
    public void addDoubleDigitShouldSucceed() {
        WebElement webElement7 = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
        wait.until(elementToBeClickable(webElement7)).click();
        wait.until(elementToBeClickable(webElement7)).click();

        WebElement webElementInput = driver.findElement(By.id("com.google.android.calculator:id/formula"));
        webElementInput.isDisplayed();
        String firstInput = webElementInput.getText().trim();
        System.out.println("Input : " + firstInput);

        wait.until(elementToBeClickable(driver.findElement(By.id("com.google.android.calculator:id/op_add")))).click();

        WebElement webElement9 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
        wait.until(elementToBeClickable(webElement9)).click();
        wait.until(elementToBeClickable(webElement9)).click();

        String secondInput = webElementInput.getText().trim().split("\\+")[1].trim();
        System.out.println("Input2 : " + secondInput);

        wait.until(elementToBeClickable(driver.findElement(By.id("com.google.android.calculator:id/eq")))).click();
        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText().trim();
        System.out.println("Sum : " + result);

        Assert.assertEquals((Integer.parseInt(firstInput) + Integer.parseInt(secondInput)), Integer.parseInt(result));
    }

    @Test
    public void subtractSingleDigitShouldSucceed() {
        WebElement webElement7 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
        wait.until(elementToBeClickable(webElement7)).click();

        WebElement webElementInput = driver.findElement(By.id("com.google.android.calculator:id/formula"));
        webElementInput.isDisplayed();
        String firstInput = webElementInput.getText().trim();
        System.out.println("Input : " + firstInput);

        wait.until(elementToBeClickable(driver.findElement(By.id("com.google.android.calculator:id/op_sub")))).click();

        WebElement webElement9 = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
        wait.until(elementToBeClickable(webElement9)).click();
//        String secondInput = webElementInput.getText().trim().split("\\?")[1].trim();
        System.out.println("Input2 : " + webElementInput.getText().trim());

        int sum = Integer.parseInt(firstInput) - 7;

        wait.until(elementToBeClickable(driver.findElement(By.id("com.google.android.calculator:id/eq")))).click();
        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText().trim();
        System.out.println("Sum : " + result);

        Assert.assertEquals(sum, Integer.parseInt(result));
    }


}
