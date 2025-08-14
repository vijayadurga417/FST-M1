package activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Create the Actions object
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page
        driver.get("https://training-support.net/webelements/dynamic-controls");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());
        
     // Find the checkbox and make sure it is visible
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        System.out.println("Checkbox is visible ?" +checkbox.isDisplayed());
        
     // Find the button to toggle it and click it
        driver.findElement(By.xpath("//button[text() = 'Toggle Checkbox']")).click();
     // Wait for it to disappear
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
     // Check if it is visible
        System.out.println("Checkbox is visible? " + checkbox.isDisplayed());
        // Toggle the checkbox and click it
        driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
        // Check if it is selected
        System.out.println("Checkbox is selected? " + checkbox.isSelected());

        // Close the browser
        driver.quit();
        
    }

}
