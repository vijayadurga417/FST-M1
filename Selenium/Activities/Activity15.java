package activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {
	public static void main(String[] args) {
		 // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://training-support.net/webelements/dynamic-attributes");
        // Print the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
        // Find the input fields
        WebElement fullName = driver.findElement(By.xpath("//input[starts-with(@id, 'full-name')]"));
        WebElement email = driver.findElement(By.xpath("//input[contains(@id,'email')]"));
        WebElement eventDate = driver.findElement(By.xpath("//input[contains(@name, '-event-date')]"));
        WebElement details = driver.findElement(By.xpath("//textarea[contains(@id, '-additional-details-')]"));
        //Enter the details
        fullName.sendKeys("Ravi Dubey");
        email.sendKeys("ravi.3245@sample.com");
        eventDate.sendKeys("2025-08-08");
        details.sendKeys("Live Event");
     // Find and click the submit button
        driver.findElement(By.xpath("//button[text() = 'Submit']")).click();
        
     // Wait for the success message and print it
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))).getText();
        System.out.println("Success Message: " +message);
        
     // Close the browser
        driver.quit();		
 			
	}
}
