package com.emi.calculator.screen;

import com.emi.calculator.screen.baseScreen.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomeScreen extends BaseScreen {
    private By emiCalculatorBtn = By.id("btnStart");
    private By compareBtnLoans = By.id("btnCompare");

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public EmiCalculatorScreen tabEmiCalculatorBtn() {
        getWebElement(emiCalculatorBtn).click();
        return getInstance(EmiCalculatorScreen.class);
    }

    public CompareLoansScreen tabCompareBtnLoans() {
        getWebElement(compareBtnLoans).click();
        return getInstance(CompareLoansScreen.class);
    }

    public boolean hasEmiCalculatorBtn() {
        return getWebElements(emiCalculatorBtn).size() > 0;
    }

    public boolean hasCompareBtnLoans() {
        return getWebElements(compareBtnLoans).size() > 0;
    }
}
