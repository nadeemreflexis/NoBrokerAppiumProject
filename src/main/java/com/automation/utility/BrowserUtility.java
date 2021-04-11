package com.automation.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserUtility 
{
	public static Properties propertyfile()
	{
		Properties prop = new Properties();
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\automation\\utility\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	public static AndroidDriver<MobileElement> getAndroidDriver()
	{
		AndroidDriver<MobileElement> driver=null;
		Properties prop = propertyfile();
		try {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.get("deviceName"));
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.get("devicePlatform"));
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.get("deviceVersion"));
		caps.setCapability(MobileCapabilityType.UDID, prop.get("udid"));
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.get("automationName"));
		caps.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"\\apps\\NoBroker Flat Apartment House Rent Buy Sell_v6.8.277_apkpure.com.apk");
		caps.setCapability("appPackage", "com.nobroker.app");
		caps.setCapability("appActivity", "com.nobroker.app.activities.NBSplashScreen");
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("unicodeKeyboard", true);
		caps.setCapability("resetKeyboard", true);
		//caps.setCapability("fullReset", true);
		
		driver = new AndroidDriver<MobileElement>(new URL(prop.getProperty("url")),caps);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		} catch (MalformedURLException e) 
		{
			System.out.println("Cause:"+e.getCause());
			System.out.println("Message:"+e.getMessage());
			e.printStackTrace();
		}
		return driver;
		}
		
	}
