package com.automation.mobile.script;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.mobile.pages.BuyPage;
import com.automation.mobile.pages.FeedBackPage;
import com.automation.mobile.pages.LoginPage;
import com.automation.mobile.pages.ReportPage;
import com.automation.mobile.pages.SuggestAnEditPage;
import com.automation.utility.BrowserUtility;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PageObjectTestCase 
{
	AndroidDriver<MobileElement> driver=null;
	
	@BeforeMethod
	public void setup()
	{
	driver = BrowserUtility.getAndroidDriver();
	}
	
	@Test
	public void pageObjectTestCase() throws InterruptedException
	{
		try {
		LoginPage login = new LoginPage(driver);
		BuyPage buy = login.login();
		ReportPage reportlog = buy.buy();
		SuggestAnEditPage suggestion =reportlog.getReport();
		FeedBackPage feedback = suggestion.getsuggestEdit();
		String verify = feedback.getFeedback();
		String result[] = verify.split(",");
		Assert.assertEquals(result[0], result[1]);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
	 driver.quit();
	}

}
