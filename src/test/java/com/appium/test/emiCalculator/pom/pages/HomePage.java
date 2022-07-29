package com.appium.test.emiCalculator.pom.pages;

import com.appium.test.emiCalculator.BaseEmiCalculatorTest;
import com.appium.util.GeneralUtil;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage extends BaseEmiCalculatorTest {
    @AndroidFindBy(id = "btnStart")
    WebElement emiCalculatorBtn;

    @AndroidFindBy(id = "btnCompare")
    WebElement compareLoansBtn;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(GeneralUtil.WAIT_TIME)), this);
    }

    public EmiCalculatorPage clickEmiCalculatorBtn() {
        waitForLoading(By.id("btnStart"));
        emiCalculatorBtn.click();
        return new EmiCalculatorPage();
    }

    public CompareLoansPage clickCompareLoansBtn() {
        waitForLoading(By.id("btnCompare"));
        compareLoansBtn.click();
        return new CompareLoansPage();
    }
}
