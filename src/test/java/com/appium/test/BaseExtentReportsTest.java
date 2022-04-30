package com.appium.test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.BeforeSuite;

public abstract class BaseExtentReportsTest {
    ExtentReports extent;
    ExtentSparkReporter htmlReporter;

    @BeforeSuite
    public void setupReports() {
        htmlReporter = new ExtentSparkReporter("Spark.html");
        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    }

    @BeforeSuite
    public void tearDownReport() {
        extent.flush();

    }
}
