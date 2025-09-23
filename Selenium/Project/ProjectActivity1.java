package project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity1 {

WebDriver driver;
	
	@BeforeClass	
	public void beforeMethod() {
        driver = new FirefoxDriver();        
        driver.get("http://alchemy.hguy.co/crm");
    }
	
	@Test
	public void testCase1() {		
		System.out.println("Page title is: "+ driver.getTitle());		
		Assert.assertEquals(driver.getTitle(), "SuiteCRM");		
	}
		
	@AfterClass
	public void closeup() {
		driver.quit();
	}

	
}
