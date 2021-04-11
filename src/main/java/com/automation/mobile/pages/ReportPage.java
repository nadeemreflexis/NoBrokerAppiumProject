package com.automation.mobile.pages;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ReportPage extends BasePage 
{
	public ReportPage(AndroidDriver<MobileElement> driver)
	{
		super(driver);
	}

	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.nobroker.app:id/btn_report']")
	private AndroidElement ReportButton;
	
	public SuggestAnEditPage getReport()
	{
		
		  List<MobileElement> checkboxes=driver.findElements(By.xpath("//android.widget.CheckBox[contains(@resource-id,'com.nobroker.app:id/cb')]"));
	       for(MobileElement reportCheckbox:checkboxes)
	       {
	    	   reportCheckbox.click();
	    	   if(checkboxes==null)
	    	   {
	    		   break;
	    	   }
	       }
	       ReportButton.click();
	       
	       return new SuggestAnEditPage(driver);
	}
	
	
	
}
