package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day12_HW extends CommonBase {
	
	@BeforeMethod
	@Parameters("browserTest")
	public void openBrowser(String browserName) {
		setupDriver(browserName);
		driver.get("https://demo.seleniumeasy.com/input-form-demo.html");
	}
	@Test
	public void selectDropdown() {
		Select select = new Select(driver.findElement(By.xpath("//select[@name='state']")));
		select.selectByVisibleText("Alaska");
		Assert.assertEquals("Alaska", select.getFirstSelectedOption().getText());
	}
	
	@Test
	public void selectRadioButton() {
		WebElement yesRadio = driver.findElement(By.xpath("//div[@class='radio']//input[@value='yes']"));
		if(yesRadio.isEnabled()==false)//Kieẻm tra xem radio đã anable thì đợi 3 s
		{
			pause(3000);
			yesRadio.click();	
		}
		if(yesRadio.isSelected()==false) {
			yesRadio.click();			
		}
	}
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
}
