package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day8_HW1_LocatorElement extends CommonBase{
	 
	 @BeforeMethod
		@Parameters("browserTest")
		public void openBrowser(String browserName) {
			setupDriver(browserName);
			driver.get("https://selectorshub.com/xpath-practice-page/");
		}
	 
	 @Test
	    public void findLocatorById(){
	        WebElement userEmail= driver.findElement(By.id("userId"));
	        System.out.println("User Email locator is: " + userEmail);
	        
	        WebElement password= driver.findElement(By.id("pass"));
	        System.out.println("Password locator is: " + password);
	        
	    }
	 
	 @Test
	 	public void findLocatorByName() {
		 	WebElement userEmail= driver.findElement(By.name("email"));
	        System.out.println("User Email locator is: " + userEmail);
	        
	        WebElement password= driver.findElement(By.name("Password"));
	        System.out.println("Password locator is: " + password);
		 
	        WebElement company= driver.findElement(By.name("company"));
	        System.out.println("Company locator is: " + company);
	        
	        WebElement mobileNumber= driver.findElement(By.name("mobile number"));
	        System.out.println("Mobile Number locator is: " + mobileNumber);
	 }
	 
	 @AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
}
