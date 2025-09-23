package project;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProjectActivity7 {

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
		
		WebElement SalesMenu= driver.findElement(By.xpath("//a[text()='Sales']"));
		Assert.assertTrue(SalesMenu.isDisplayed(),"Sales menu item exists.");
		SalesMenu.click();
				
		WebElement leadsMenu = driver.findElement(By.id("moduleTab_9_Leads"));
        leadsMenu.click();
        
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement icon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td[last()]")));
        
		//WebElement icon= driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr[1]/td[last()]"));
		if(icon.isEnabled()) {
			System.out.println("ICON Exist");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			if(icon.isDisplayed()) {
				System.out.println("ICON is displaying");
			icon.click();
			}else {
				System.out.println("ICON is not displaying");
			}
		}
		
		WebElement Phn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='phone']")));
		System.out.println("Mobile no is:"+Phn.getText());
			
	}
		
	@AfterClass
	public void closeup() {
		driver.quit();
	}
}
