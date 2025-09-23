package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity3 {

WebDriver driver;
	
	@BeforeClass	
	public void beforeMethod() {
        driver = new FirefoxDriver();        
        driver.get("http://alchemy.hguy.co/crm");
    }
	
	@Test
	public void testCase1() {		
		WebElement firstCopyright =   driver.findElement(By.id("admin_options"));
		System.out.println("First Copyright text is :"+firstCopyright.getText());
	}
		
	@AfterClass
	public void closeup() {
		driver.quit();
	}

}
