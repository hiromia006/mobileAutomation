# Prepare Appium Instance for Window 10
To Start Automation with Appium, we have to follow couple of steps.
First we have to make our system ready and then we can start our journey with appium.

1. [Download & Install JDK](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
2. [Download & Install IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
3. [Download & Install android studio Android SDK thourgh Android Studio](https://developer.android.com/studio)
4. [Download & Install LTS Node Js](https://nodejs.org/en/download/)
5. [Download & Install Vysor](https://www.vysor.io/download/)
6. [Download & Install Appium Desktop Apps](https://github.com/appium/appium-desktop/releases/)
7. Set environment variable(path) -  Set JAVA_HOME & ANDROID_HOME
8. Check if node.js & npm are installed - node --version, npm --version
9. Install appium with node.js - npm install -g appium
10. Check if appium is installed - appium -v
11. Plugin Device (turn on developer mode & USB debugging)    
    -  Find build number under settings and tap 7 times on build number.    
    - Enter your pattern, PIN or password to enable the Developer options menu.    
    - The "Developer options" menu will now appear in your Settings menu.    
    - Turn On the "USB Debugging" option from "Developer Options"
12. Indentify appPackage & appActivityName
    Open the app in your device. and use the command - adb shell "dumpsys activity activities | grep mResumedActivity"

##  Create Java(Gradle) Project in IntelliJ IDEA for Appium
1. Create Java(Gradle) Project in IntelliJ IDEA
2. Add Gradle Dependencies   
    - [Selenium](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java)
    - [Appium CLient](https://mvnrepository.com/artifact/io.appium/java-client)    
     - [TestNG](https://mvnrepository.com/artifact/org.testng/testng)
3. [Desired Capabilities](https://appium.io/docs/en/writing-running-appium/caps/)

## Open existing Java(Gradle) Project using IntelliJ IDEA
1. Open existing Java(Gradle) Project using IntelliJ IDEA   
2. Identify Elements
3. Start Writing Automation Code
4. Run Test Cases

## Appium Inspector to Identify Elements
1. [Appium Inspector download & install](https://github.com/appium/appium-inspector/releases)
2. **Configure Appium Desktop client &  Appium Inspector**
  - Configure Appium Desktop
     -  Go to Appium Server GUI -> Advanced
        -  Server address: localhost
        -  Port: 4723
        - Allow CORP: yes
        
 - Appium Inspector
    -  Go to or Open Appium Inspector
        -  Remote host: localhost
        -  Port: 4723
        - Path: /wd/hub
        - Allow Unauthorized Certificates
  - Select your capabilities  ![img.png](images/img.png)
  -  Start Appium Server GUI First ![img.png](images/img_1.png)
  -  Appium Inspector server ![img.png](images/img_2.png)
  -- Appium Inspector will open ![img.png](images/img_3.png)