package com.automation.mobile.pages;

import java.io.IOException;
import org.json.simple.parser.ParseException;

import com.automation.utility.JsonReader;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage
{

	public LoginPage(AndroidDriver<MobileElement> driver)
	{
		super(driver);
	}
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	private AndroidElement NavigateButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Login / Signup']")
    private AndroidElement Login_SignUpButton;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter Phone Number']")
	private AndroidElement EnterPhoneNumber;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text=\"I've Password\"]")
	private AndroidElement PasswordRadioButton;
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter Password']")
	private AndroidElement EnterPassword;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.nobroker.app:id/btn_signup']")
	private AndroidElement Continue;
	
	
	public BuyPage login() throws IOException, ParseException
	{
		String[] TestData = JsonReader.getJson().split(",");
		NavigateButton.click();
		NavigateButton.click();
		Login_SignUpButton.click();
		EnterPhoneNumber.sendKeys(TestData[0]);
		PasswordRadioButton.click();
		EnterPassword.sendKeys(TestData[1]);
		Continue.click();
		
		return new BuyPage(driver);
	}
	
	

}
