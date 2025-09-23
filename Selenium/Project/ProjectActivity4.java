package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity4 {

WebDriver driver;
	
	@BeforeClass	
	public void beforeMethod() {
        driver = new FirefoxDriver();        
        driver.get("http://alchemy.hguy.co/crm");
    }
	
	@Test
	public void testCase1() {		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		
		WebElement SalesButton= driver.findElement(By.xpath("//*[text()='Sales']"));
		if (SalesButton.isDisplayed()) {
			System.out.println("The Homepage opened");
		}
        Assert.assertTrue(driver.getCurrentUrl().contains("Home"), "Home page opened.");
		
		
	}
		
	@AfterClass
	public void closeup() {
		driver.quit();
	}
}
