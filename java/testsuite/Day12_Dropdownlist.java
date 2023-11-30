package testsuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import automation.common.CommonBase;

public class Day12_Dropdownlist extends CommonBase{
	@BeforeMethod
	public void openChorme() {
		driver = initChromeDriver("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
	}
	
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
}
