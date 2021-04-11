package com.automation.mobile.pages;

import java.io.IOException;
import org.json.simple.parser.ParseException;

import com.automation.utility.JsonReader;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SuggestAnEditPage extends BasePage
{
	public SuggestAnEditPage(AndroidDriver<MobileElement> driver)
	{
		super(driver);
	}

	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='2 BHK']")
	private AndroidElement correctConfiguration;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='6']")
	private AndroidElement flatSelection;
	
	@AndroidFindBy(xpath = "//*[@resource-id='com.nobroker.app:id/actv_location']")
	private AndroidElement location;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Save Changes']")
	private AndroidElement SaveButton;
	
	
	public FeedBackPage getsuggestEdit() throws InterruptedException, IOException, ParseException
	{
		String[] TestData = JsonReader.getJson().split(",");
		Thread.sleep(3000);
		location.clear();
		location.sendKeys(TestData[2]);
		((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent().withKey(AndroidKey.PAGE_DOWN));
	    ((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
	    driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
        		+ ".scrollIntoView(new UiSelector().textContains(\"2 BHK\").instance(0))").click();
		flatSelection.click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
	        		+ ".scrollIntoView(new UiSelector().textContains(\"Add a note\").instance(0))").sendKeys(TestData[4]);
		SaveButton.click();
		
		return new FeedBackPage(driver);
	}
	
	
	
}
