package testsuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_Account;

public class Day12_Checkbox_Radio_Dropdownlist extends CommonBase {

	
	@BeforeMethod
	@Parameters("browserTest")
	public void openBrowser(String browserName) {
		setupDriver(browserName);
		driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}
	
	@Test
	public void ClickOnCheckBox() {
		WebElement defaulCheckbox = driver.findElement(By.xpath("//label[normalize-space()='Default Checked']/input"));
		if(defaulCheckbox.isSelected()== true) {
			System.out.println("Pass vì defaul check box đã được checked");
		}else {
			System.out.println("Failed vì defaul check box đã không được checked");
		}
		WebElement testCheckbox = driver.findElement(By.xpath("//label[normalize-space()='Click on this check box']/input"));
		if(testCheckbox.isSelected()== false) {
			testCheckbox.click();
			System.out.println("check box đã được checked");
		}
		
	}
	
//	@Test
//	public void MultiCheckBox() {
//		List <WebElement> listCheckbox =driver.findElements(By.xpath("(//div[@class= 'panel-body'])[3]//div[@class='checkbox']//input"));
//		System.out.println(listCheckbox.size());
//		for(int i =0; i<listCheckbox.size(); i++) {
//			boolean isCheckbox =listCheckbox.get(i).isSelected();
//			if(isCheckbox == true) {
//				System.out.println("check box vị trí" + i+1 +"đã được checked");
//			}else {
//				listCheckbox.get(i).click();
//			}
//
//			System.out.println(listCheckbox.get(i).isSelected());
//		}
//		pause(2000);
//		driver.close();
//	}
//	
//	@Test
//	public void MultiCheckBox3() {
//		List <WebElement> listCheckbox =driver.findElements(By.xpath("(//div[@class= 'panel-body'])[3]//div[@class='checkbox']//input"));
//		System.out.println(listCheckbox.size());
//		for(int i =0; i<listCheckbox.size(); i++) {
//			WebElement checkbox = driver.findElement(By.xpath("(//div[@class= 'panel-body'])[3]//div[@class='checkbox']["+ (i+1) + "]//input"));
//			boolean isCheckbox =checkbox.isSelected();
//			if(isCheckbox == true) {
//				System.out.println("check box vị trí" + i+1 +"đã được checked");
//			}else {
//				listCheckbox.get(i).click();
//			}
//			System.out.println(listCheckbox.get(i).isSelected());
//		}
//		pause(2000);
//		driver.close();
//	}
	
	@AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
	
}
