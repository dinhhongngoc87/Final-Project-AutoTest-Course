package testsuite;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;
import automation.pageLocator.ClientPageFactory;
import automation.pageLocator.LoginPageFactory;

public class AddClient extends CommonBase{
	@BeforeMethod
	@Parameters("browserTest")
	public void openBrowser(String browserName) {
		setupDriver(browserName);
		driver.get(CT_Account.webURL);
	}
	
	@Test
	public void addClientSuccessfully() throws InterruptedException {
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunction("admin@demo.com", "riseDemo");
		assertEquals(true, driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed());
		
		ClientPageFactory client = new ClientPageFactory(driver);
		client.AddNewClientFunction("AutomationTest3");
		pause(6000);
		assertEquals(true, driver.findElement(By.xpath("//a[text()='AutomationTest2']")).isDisplayed());
	}
	
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
}
