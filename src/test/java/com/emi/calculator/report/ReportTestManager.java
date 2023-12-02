package com.emi.calculator.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.util.HashMap;
import java.util.Map;

public class ReportTestManager {

    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    static ExtentReports extent = ReportManager.getInstance();

    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized ExtentTest startTest(String testName, String className) {
        ExtentTest test = extent.createTest(testName, className);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
        test.assignAuthor("Hiro Mia");
        test.assignCategory(className);
        return test;
    }

    public static synchronized void logText(String message) {
        getTest().log(Status.PASS, message);
    }
}