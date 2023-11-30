package testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day12_RadioButton extends CommonBase{

	@BeforeMethod
	@Parameters("browserTest")
	public void openBrowser(String browserName) {
		setupDriver(browserName);
		driver.get("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
	}
	@Test
	public void radioButton() {
		WebElement FemaleRadio = driver.findElement(By.xpath("//input[@value='Female' and @name='optradio']"));
		if(FemaleRadio.isEnabled()==false)//Kieẻm tra xem radio đã anable thì đợi 3 s
		{
			pause(3000);
		}
		if(FemaleRadio.isSelected()==false) {
			FemaleRadio.click();			
		}
	}
	
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
}
