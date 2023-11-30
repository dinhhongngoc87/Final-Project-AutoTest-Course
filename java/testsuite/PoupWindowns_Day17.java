package testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;

public class PoupWindowns_Day17 extends CommonBase{

	@BeforeMethod
	@Parameters("browserTest")
	public void openBrowser(String browserName) {
		setupDriver(browserName);
		driver.get(CT_Account.webPopup);
	}
	
	@Test
	public void verifyNewTab() {
		click(By.xpath("//a[text()='Click Here']"));
		String maineWindow = driver.getWindowHandle();
		System.out.println("Main Window is: "+ maineWindow);
		Set<String> listSubWindowns = driver.getWindowHandles();
		for(String subWindown: listSubWindowns) {
			System.out.println("All windown is: "+ subWindown);
			if(!subWindown.equals(maineWindow)) {
				driver.switchTo().window(subWindown);
				pause(2000);
				assertEquals( driver.getCurrentUrl(),"https://demo.guru99.com/articles_popup.php");
				System.out.println("Subwindown title is: "+ driver.getCurrentUrl());
				type(By.xpath("//input[@name='emailid']"),"testmail@gmail.com");
				click(By.xpath("//input[@name='btnLogin']"));
				
				driver.close();
			}
		}
		driver.switchTo().window(maineWindow);
		System.out.println("Mainwindown title is: "+ driver.getCurrentUrl());
		assertEquals( driver.getCurrentUrl(),"https://demo.guru99.com/popup.php");
	}
	
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
}
