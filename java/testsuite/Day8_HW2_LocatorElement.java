package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day8_HW2_LocatorElement extends CommonBase{

	 @BeforeMethod
		@Parameters("browserTest")
		public void openBrowser(String browserName) {
			setupDriver(browserName);
			driver.get("https://automationfc.github.io/basic-form/index.html");
		}
	 @Test
	    public void findLocatorById(){
	        WebElement name= driver.findElement(By.id("name"));
	        System.out.println("Name locator is: " + name);
	        
	        WebElement address= driver.findElement(By.id("address"));
	        System.out.println("Address locator is: " + address);
	        
	        WebElement email= driver.findElement(By.id("email"));
	        System.out.println("Email locator is: " + email);
	        
	        WebElement password= driver.findElement(By.id("password"));
	        System.out.println("Password locator is: " + password);
	        
	    }
	 @Test
	    public void findLocatorByName(){
	        WebElement name= driver.findElement(By.name("name"));
	        System.out.println("Name locator is: " + name);
	        
	        WebElement address= driver.findElement(By.name("address"));
	        System.out.println("Address locator is: " + address);
	        
	        WebElement email= driver.findElement(By.name("email"));
	        System.out.println("Email locator is: " + email);
	        
	        WebElement password= driver.findElement(By.name("password"));
	        System.out.println("Password locator is: " + password);
	        
	    }
	 
	 @AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
	  
}
