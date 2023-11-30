package testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_Account;

public class Day16_AlertPractice extends CommonBase {
	
	@BeforeMethod
	@Parameters("browserTest")
	public void openBrowser(String browserName) {
		setupDriver(browserName);
		driver.get("https://demo.automationtesting.in/Alerts.html");
	}
	
//	@Test
//	public void deleteCustomer() {
//		type(By.xpath("//input[@name='cusid']"),"12345");
//		click(By.xpath("//input[@name='submit']"));
//		driver.switchTo().alert().accept();
//		driver.switchTo().alert().accept();
//		System.out.print("Page title is: "+ driver.getTitle());
//		assertEquals(driver.getTitle(),"Delete Customer");
//		assertTrue(isElementPresent(By.xpath("//h2[text()='Guru99 Bank']")));
//	}
	
	@Test
	public void alertWithOkAndCancel_OkClick() {
		click(By.xpath("//a[text()='Alert with OK & Cancel ']"));
		click(By.xpath("//button[text()='click the button to display a confirm box ']"));
		driver.switchTo().alert().accept();
		assertTrue(isElementPresent(By.xpath("//p[text()='You pressed Ok']")));
	}
	
	@Test
	public void alertWithOkAndCancel_CancelClick() {
		click(By.xpath("//a[text()='Alert with OK & Cancel ']"));
		click(By.xpath("//button[text()='click the button to display a confirm box ']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
		assertTrue(isElementPresent(By.xpath("//p[text()='You Pressed Cancel']")));
	}
	
	@Test
	public void alertWithTextbox_FillTextAndCancelClick() {
		click(By.xpath("//a[text()='Alert with Textbox ']"));
		click(By.xpath("//button[text()='click the button to demonstrate the prompt box ']"));
		driver.switchTo().alert().sendKeys("Mai test");
		driver.switchTo().alert().accept();
		assertTrue(isElementPresent(By.xpath("//p[text()='Hello Mai test How are you today']")));
	}
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
}
