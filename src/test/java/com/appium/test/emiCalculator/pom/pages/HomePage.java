package com.appium.test.emiCalculator.pom.pages;

import com.appium.test.emiCalculator.pom.BaseTestAppium;
import com.appium.util.GeneralUtil;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage extends BaseTestAppium {
    @AndroidFindBy(id = "btnCompare")
    WebElement btnCompare;

    @AndroidFindBy(id = "btnStart")
    WebElement btnStart;

    public HomePage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(GeneralUtil.WAIT_TIME)),
                this);
    }

    public EmiCalculatorPage tapStartBtn() {
        btnStart.isDisplayed();
        btnStart.click();
        return new EmiCalculatorPage();
    }

    public CompareLoanPage tapCompareBtn() {
        GeneralUtil.longWaitForDomStable();
        btnCompare.isDisplayed();
        btnCompare.click();
        return new CompareLoanPage();
    }

}
