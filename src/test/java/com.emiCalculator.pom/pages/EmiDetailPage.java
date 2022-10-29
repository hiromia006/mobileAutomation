package com.emiCalculator.pom.pages;

import com.emiCalculator.pom.BaseTest.EmiCalculatorBaseTest;
import com.emiCalculator.pom.util.GeneralUtil;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class EmiDetailPage extends EmiCalculatorBaseTest {
    @AndroidBy(id = "actionMenuBack")
    WebElement actionMenuBack;

    public EmiDetailPage() {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(GeneralUtil.LOAD_TIME)), this);
    }

    public EmiCalculatorPage tapMenuBack() {
        actionMenuBack.isDisplayed();
        actionMenuBack.click();
        return new EmiCalculatorPage();
    }
}
