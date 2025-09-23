package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity2 {


WebDriver driver;
	
	@BeforeClass	
	public void beforeMethod() {
        driver = new FirefoxDriver();        
        driver.get("http://alchemy.hguy.co/crm");
    }
	
	@Test
	public void testCase1() {		
		WebElement headerImage =   driver.findElement(By.xpath("//*[@title='SuiteCRM']"));
		String headerImageUrl = headerImage.getAttribute("href");
		System.out.println("Url is :"+headerImageUrl);
	}
		
	@AfterClass
	public void closeup() {
		driver.quit();
	}

	
}


