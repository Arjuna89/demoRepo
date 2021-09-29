package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObject.loginPage;
import pageObject.productPage;

public class TC1 extends baseClass {
	
	@Test
	public void login() throws InterruptedException {
		
		loginPage lp = new loginPage(driver);
		lp.enterusername(userName);
		lp.enterpassword(Password);
		lp.clickLogin();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(3000);
		productPage pp = new productPage(driver);
		pp.clickMenu();
		pp.clickAbout();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if(driver.getTitle().equals("Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Labs")) {
			System.out.println("user is taken to https: saucelabs.com/ site");
		}else {
			System.out.println("user is not taken to https: saucelabs.com/ site");
		}
		
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(driver.getTitle().equals("Swag Labs")) {
			System.out.println("user is taken back to saucedemo PRODUCTS page");
		}else {
			System.out.println("user is not taken back to saucedemo PRODUCTS page");
		}
		
		pp.selectHighestPrice();
		driver.findElement(By.xpath("//div[normalize-space()='$"+pp.highestPriceITem+"']/following-sibling::button")).click();	
		System.out.println("User is selected Heighest price Item");
		pp.ClickCart(driver);
		pp.clickCheckOut(driver);
		pp.EnteInformationandContinue(driver, fname, lname, postal);
		pp.ValidateTotalPrice();
		
		
	}
	
	@Test
	public void test2() {
		System.out.println("test");
	}
}
