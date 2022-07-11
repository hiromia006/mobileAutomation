package com.appium.util;

public class GeneralUtil {
    public static final long WAIT_TIME = 30;
    public  static final int WAIT_LOADING_TIME = 250;
    public  static final String CSV_FILE = "testData.csv";

    public static void waitForDomStable() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void longWaitForDomStable() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void mediumWaitForDomStable() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
