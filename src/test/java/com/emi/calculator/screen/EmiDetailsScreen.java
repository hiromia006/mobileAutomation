package com.emi.calculator.screen;

import com.emi.calculator.screen.baseScreen.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class EmiDetailsScreen extends BaseScreen {
    public EmiDetailsScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean hasLoanDetail() {
        return getWebElements(By.id("layoutDetailContainer")).size() > 0;
    }

    public EmiCalculatorScreen tapBackBtn() {
        getWebElement(By.id("actionMenuBack")).click();
        return getInstance(EmiCalculatorScreen.class);
    }
}
