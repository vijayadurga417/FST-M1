package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
	//Declaring the required objects
	AppiumDriver driver;
	WebDriverWait wait;

	//setup fuction
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		// Set the capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setApp("C:/Users/08400E744/Desktop/FST/FST_Documents/Calculator.apk");
		
		//Only for Android when we dont have apk file from dev so we use below
		//options.setAppPackage("com.google.android.calulator");
		//options.setAppActivity("com.android.calculator2.Calculator");
		options.noReset();
		
		// Set the Appium server URL
		URL serverUrl = new URI("http://localhost:4723").toURL();

		// Initialize the driver
		driver = new AndroidDriver(serverUrl, options);
	}
	
	//Test Method
	@Test
	public void multiplyTest() {
		//Find and tap the number 5
		driver.findElement(AppiumBy.id("digit_5")).click();
		//Find and tap the multiply button
		driver.findElement(AppiumBy.accessibilityId("multiply")).click();
		//Find and tap the number 
		driver.findElement(AppiumBy.id("digit_6")).click();
		//Find and tap the equals button
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
		
		//Get the result and assert the value
		String result = driver.findElement(AppiumBy.id("result_final")).getText();
		assertEquals(result, "30");
		}
	
	//tear down method
	@AfterClass
	public void tearDown() {
		//close the app
		driver.quit();
		
	}
}

