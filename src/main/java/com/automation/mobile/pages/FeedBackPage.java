package com.automation.mobile.pages;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.automation.utility.JsonReader;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FeedBackPage extends BasePage
{
	public FeedBackPage(AndroidDriver<MobileElement> driver)
	{
		super(driver);
	}
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[1]")
	private AndroidElement feedback;
	
	public String getFeedback() throws IOException, ParseException
	{
		String[] TestData = JsonReader.getJson().split(",");
		String actual = feedback.getText();
		String expected=TestData[5];
		String status = actual+","+expected;
		return status ;
		
	}

}
