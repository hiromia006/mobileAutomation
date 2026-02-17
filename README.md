# Prepare Appium Instance for Windows 
To Start Automation with Appium, we have to follow a couple of steps.
First, we have to prepare your system, then we can start our journey with Appium.

1. [Download & Install JDK](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
2. [Download & Install IntelliJ IDEA Community Version](https://www.jetbrains.com/idea/download/)
3. [Download & Install android studio Android SDK thourgh Android Studio](https://developer.android.com/studio)
4. [Download & Install LTS Node Js](https://nodejs.org/en/download/)
5. [Download & Install Vysor](https://www.vysor.io/download/)
6. Set environment variable(path):  Set JAVA_HOME & ANDROID_HOME
7. Check if Node.js, npm & Android SDK are installed: node --version, npm --version, adb --version
8. Install Appium: Appium Version 2 commands installation process
9. Check if Appium is installed: appium -v
10. Plugin Device (turn on developer mode & USB debugging)    
    -  Find the build number under settings and tap 7 times on the build number.    
    - Enter your pattern, PIN, or password to enable the Developer options menu.    
    - The "Developer options" menu will now appear in your Settings menu.    
    - Turn on the "USB Debugging" option from "Developer Options"
11. Identify appPackage & appActivityName
    Open the app on your device. and use the command:
    
    For Windows
     adb shell dumpsys window | grep -E 'mCurrentFocus' or  adb shell dumpsys window | Select-String "mCurrentFocus"
    
     Linus
     adb shell dumpsys window | grep -E 'mCurrentFocus'
13. **Create TestNG XML** plugin install from Marketplace - File >> Settings >> plugin >> Marketplace >> search 'Create
      TestNG XML' & install

## Appium Version 2 commands
1. Install Appium: npm i --location=global appium
2. Uninstall Appium: npm uninstall -g appium
3. Check driver's list: Appium driver list
4. Install uiautomator2 & execute-driver driver: appium driver install uiautomator2, appium plugin install execute-driver
5. Check plugin list: appium plugin list
6. Install Plugin: appium plugin install plugin_name
7. Run with path: appium --base-path /wd/hub
8. Run Appium: appium
9. Run Appium with plugin & path: appium --use-plugins=execute-driver --base-path /wd/hub

### Related Resources
* [Appium NPM](https://www.npmjs.com/package/appium)
* [Appium GitHub](https://github.com/appium/appium)

##  Create Java(Gradle) Project in IntelliJ IDEA for Appium
1. Create Java(Gradle) Project in IntelliJ IDEA
2. Add Gradle Dependencies   
    - [Selenium](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
    - [Appium Client](https://mvnrepository.com/artifact/io.appium/java-client)    
     - [TestNG](https://mvnrepository.com/artifact/org.testng/testng)
3. [Desired Capabilities](https://appium.io/docs/en/writing-running-appium/caps/)

## Open existing Java(Gradle) Project using IntelliJ IDEA
1. Open existing Java(Gradle) Project using IntelliJ IDEA   
2. Identify Elements
3. Start Writing Automation Code
4. Run Test Cases

## Appium Inspector to Identify Elements
1. [Appium Inspector download & install](https://github.com/appium/appium-inspector/releases)
2. **Configure  Appium Inspector**
 - Appium Inspector
    -  Go to or Open Appium Inspector
        -  Remote host: localhost
        -  Port: 4723
        - Path: /wd/hub
        - Allow Unauthorized Certificates
3. **Set DesiredCapabilities**
- capabilities.setCapability("appium:udid", "192.168.56.101:5555");
- capabilities.setCapability("appium:platformVersion", "12");
- capabilities.setCapability("appium:appPackage", "com.bng.calculator");
- capabilities.setCapability("appium:appActivity", "com.bng.calc.MainActivity");
- capabilities.setCapability("platformName", "Android");
- capabilities.setCapability("appium:automationName", "UiAutomator2");
4. **Disable Permission Monitoring**
- Go to developer option.
- Go to last option called --> Disable Permission Monitoring --> enable it.

### Run Test Case
* **Run Test Case** - Go to desired Java Class where has Test Case, Right click of mouse on Test Case >> click on Run
* **Run XML File** - After create TestNG file, Right click of mouse on TestNG xml >> click on Run

### Download Genymotion Emulator & Download Apk from Google Play
* [Download Genymotion Emulator](https://www.genymotion.com/download/)
* [Downloads – Oracle VM VirtualBox](https://www.virtualbox.org/wiki/Downloads)https://www.virtualbox.org/wiki/Downloads)
* [Download Apk from Google Play](https://apkcombo.app/downloader/)

### Related Resources
* [Appium Command](https://dpgraham.github.io/docs/en/commands/status/)
* [Troubleshoot Activities Startup](https://appium.io/docs/en/writing-running-appium/android/activity-startup/)
* [Appium API Documentation](https://appium.io/docs/en/about-appium/api/)
* [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/)

# Create automated scripts to test EMI Calculator mobile app
[Download & install EMI Calculator mobile app your device](https://github.com/hiromia006/mobileAutomation/blob/main/src/test/resources/emi-calculator.apk)

### Key functionalities, that have to be covered:
1. Open EMI calculator
2. Navigate to the EMI Calculator screen
3. Enter <*loan*> in the amount field
4. Enter <*interest*> percent rate in the interest field
5. Enter <*period*> in the period field in years
6. Enter <*pFee*> percent for the processing fee
7. And tap on the calculate button
8. Then Verify that the detail results are correct <*mEMI*>, <*tInterest*>, <*tpFee*> and <*tPayment*>

#### Examples:

| loan    | interest | period | pFee | mEMI  | tInterest | tpFee | tPayment |
|---------|----------|--------|------|-------|-----------|-------|----------|
|  100000 |  9.0     |  2     |  2.0 |  4568 |  9643     |  2000 |  109643  |
|  325000 |  9.5     |  5     |  1.5 |  6826 |  84536    |  4875 |  409536  |
|  450000 |  11.0    |  7     |  1.8 |  7705 |  197228   |  8100 |  647228  |

### Additional functionalities, that may be covered:
1. Please use Example table data to create excel/csv file as external test data provider and your automation script have the abitlity to read and write data from excel/csv

### Record a video of tests execution:
