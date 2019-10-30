package com.acutest.cdaf.stepdefs;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppCapabilities {
    private static MobileDriver driver;
    protected DesiredCapabilities capabilities;
    private static Logger logger = LogManager.getLogger(AppCapabilities.class);

    public AppCapabilities(){
    }

    protected MobileDriver createCapabilities(){
        try {
            capabilities = new DesiredCapabilities();
            capabilities.setCapability("VERSION", "9.0");
            capabilities.setCapability("deviceName","emulator-5554");
            capabilities.setCapability("platformName","Android");
            //capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

            // This package name of your app (you can get it from apk info app)
            capabilities.setCapability("appPackage", "com.atlassian.android.jira.core");

            // This is Launcher activity of your app (you can get it from apk info app)
            capabilities.setCapability("appActivity","com.atlassian.android.jira.core.app.LauncherActivity");
            //Create RemoteWebDriver instance and connect to the Appium server
            driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            logger.info("Could not open app on emulator due to: " + e.getMessage());
        }
        return driver;
    }

    public static MobileDriver getDriver(){
        return driver;
    }
}
