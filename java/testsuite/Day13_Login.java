package testsuite;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;

public class Day13_Login extends CommonBase {

	@BeforeMethod
	@Parameters("browserTest")
	public void openBrowser(String browserName) {
		setupDriver(browserName);
		driver.get(CT_Account.webURL);
	}
	
	@Test( priority = 4 )
	public void loginSuccessfully() {
		WebElement txtEmail = driver.findElement(CT_Account.textEmail);
		if(txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys("admin@demo.com");
		}
		pause(3000);
		WebElement txtPass = driver.findElement(CT_Account.textPassword);
		if(txtPass.isDisplayed()) {
			txtPass.clear();
			txtPass.sendKeys("riseDemo");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement btnLogin = driver.findElement(CT_Account.btnLogin);
		if(btnLogin.isDisplayed()) {
			btnLogin.click();
		}
		assertEquals(true, driver.findElement(By.xpath("//span[text()='Dashboard']")).isDisplayed());
		
	}
	
	@Test( priority = 3 )
	public void loginFail_IncorrectEmail() {
		WebElement txtEmail = driver.findElement(CT_Account.textEmail);
		if(txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys("admin@dem.com");
		}
		pause(3000);
		WebElement txtPass = driver.findElement(CT_Account.textPassword);
		if(txtPass.isDisplayed()) {
			txtPass.clear();
			txtPass.sendKeys("riseDemo");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement btnLogin = driver.findElement(CT_Account.btnLogin);
		if(btnLogin.isDisplayed()) {
			btnLogin.click();
		}
		assertEquals(true, driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
		
	}
	@Test ( priority = 2 )
	public void loginFail_IncorrectPass() {
		WebElement txtEmail = driver.findElement(CT_Account.textEmail);
		if(txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys("admin@demo.com");
		}
		pause(3000);
		WebElement txtPass = driver.findElement(CT_Account.textPassword);
		if(txtPass.isDisplayed()) {
			txtPass.clear();
			txtPass.sendKeys("riseDem");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement btnLogin = driver.findElement(CT_Account.btnLogin);
		if(btnLogin.isDisplayed()) {
			btnLogin.click();
		}
		assertEquals(true, driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
	}
	
	@Test ( priority = 1 )
	public void loginFail_IncorrectPass_IncorrectEmail() {
		WebElement txtEmail = driver.findElement(CT_Account.textEmail);
		if(txtEmail.isDisplayed()) {
			txtEmail.clear();
			txtEmail.sendKeys("admin@dem.com");
		}
		pause(3000);
		WebElement txtPass = driver.findElement(CT_Account.textPassword);
		if(txtPass.isDisplayed()) {
			txtPass.clear();
			txtPass.sendKeys("riseDem");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement btnLogin = driver.findElement(CT_Account.btnLogin);
		if(btnLogin.isDisplayed()) {
			btnLogin.click();
		}
		assertEquals(true, driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed());
	}
	@Test ( priority = 1 )
	public void logOut() {
		WebElement btnLogin = driver.findElement(CT_Account.btnLogin);
		if(btnLogin.isDisplayed()) {
			btnLogin.click();
		}
		pause(3000);
		WebElement avata = driver.findElement(By.xpath("//span[text() ='John Doe']/ancestor::li"));
		if(avata.isDisplayed()) {
			avata.click();
		} 
		
		WebElement signOut = driver.findElement(By.xpath("//a[@class='dropdown-item' and text()=' Sign Out' ]"));
		if(signOut.isDisplayed()) {
			signOut.click();
		}
		assertEquals(true, driver.findElement(By.xpath("//h2[text()='Sign in']")).isDisplayed());
	}
	@AfterMethod
	public void closeChorme() {
		quitDriver(driver);
	}
}
