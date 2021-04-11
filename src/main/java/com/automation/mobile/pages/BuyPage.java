package com.automation.mobile.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import com.automation.utility.JsonReader;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BuyPage extends BasePage
{
	
	public BuyPage(AndroidDriver<MobileElement> driver)
	{
		super(driver);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.nobroker.app:id/buyLayoutText']")
	private AndroidElement BuyTab;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.nobroker.app:id/searchEditHome']")
	private AndroidElement SearchBox;
	
	@AndroidFindBy(xpath = "//android.widget.Spinner[@resource-id='com.nobroker.app:id/spinnergo']")
	private AndroidElement CityDropdown;
	
	@AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Bangalore']")
	private AndroidElement CityName;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.nobroker.app:id/localityAutoCompleteTxt']")
	private AndroidElement AutoCompleteDropdown;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Include nearby properties']")
	private AndroidElement NearbyPropertyCheckbox;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox[@text='2 BHK']")
	private AndroidElement flat1;
	
	@AndroidFindBy(xpath = "//android.widget.CheckBox[@text='3 BHK']")
	private AndroidElement flat2;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='SEARCH']")
	private AndroidElement SearchButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Wrong Info']")
	private AndroidElement WrongInfo;
	
	public ReportPage buy() throws InterruptedException, IOException, ParseException
	{
		String[] TestData = JsonReader.getJson().split(",");
		BuyTab.click();
		SearchBox.click();
		CityDropdown.click();
		CityName.click();
		AutoCompleteDropdown.clear();
		AutoCompleteDropdown.sendKeys(TestData[2]);
		((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
		AutoCompleteDropdown.sendKeys(TestData[2]);
		Thread.sleep(5000);
		((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent().withKey(AndroidKey.PAGE_DOWN));
	    ((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER)); 
	    AutoCompleteDropdown.sendKeys(TestData[3]);
	    Thread.sleep(5000);
	    ((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent().withKey(AndroidKey.PAGE_DOWN));
	    ((AndroidDriver<MobileElement>)driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER)); 
	    NearbyPropertyCheckbox.click();
	    flat1.click();
	    flat2.click();
	    SearchButton.click();
	    
	    Thread.sleep(5000);
	       driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
	       		+ ".scrollIntoView(new UiSelector().textContains(\"2 BHK in Anisha Residency\").instance(0))").click();	   
	    Robot robot;
	    try {
	        robot = new Robot();
	         robot.keyPress(java.awt.event.KeyEvent.VK_DOWN);
	         if(WrongInfo.isDisplayed()) {
	        	 robot.keyRelease(java.awt.event.KeyEvent.VK_DOWN);
	        	 WrongInfo.click();
	         }
	    } catch (AWTException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	   
	    return new ReportPage(driver);
	}
	
	

}
