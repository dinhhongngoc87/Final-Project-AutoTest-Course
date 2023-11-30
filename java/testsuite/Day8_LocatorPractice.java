package testsuite;

import automation.common.CommonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day8_LocatorPractice extends CommonBase {
//    để chạy automation test cho website, dùng TestNG Annotation
    //1. BeforeMethod
    //2. AfterMethod:
    //3.Test


//	@BeforeMethod
//	@Parameters("browserTest")
//	public void openBrowser(String browserName) {
//		setupDriver(browserName);
//		driver.get("https://rise.fairsketch.com/signin");
//	}

//    @Test
    public void findLocatorById(){
        WebElement email= driver.findElement(By.id("email"));
        System.out.println("Email locator is: " + email);
        WebElement password= driver.findElement(By.id("password"));
        System.out.println("Password locator is: " + password);

        WebElement signIn= driver.findElement(By.tagName("button"));
        System.out.println("Password locator is: " + signIn);


    }
	 @BeforeMethod
		@Parameters("browserTest")
		public void openBrowser(String browserName) {
			setupDriver(browserName);
			driver.get("https://bepantoan.vn/danh-muc/may-hut-mui-am-tu");
		}


    @Test
    public void findLocatorByLinkText(){
        WebElement linkTextMHMUT= driver.findElement(By.linkText("Máy Hút Mùi Âm Tủ"));
        System.out.println("LinkText locator May Hut Mui Am Tu is: " + linkTextMHMUT);
        
        WebElement linkTextMHMCD= driver.findElement(By.linkText("Máy Hút Mùi Cổ Điển"));
        System.out.println("LinkText locator May Hut Mui Co Dien is: " + linkTextMHMCD);

    }
    @AfterMethod
	  public void closeBrowser() {
		 quitDriver(driver) ;
	 }
}
