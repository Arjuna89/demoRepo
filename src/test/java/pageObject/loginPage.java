package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	
	WebDriver ldriver;
	
	public loginPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(id="user-name") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(id="login-button") WebElement login;
	
	
	public void enterusername(String userName) {
		username.sendKeys(userName);
	}
	
	public void enterpassword(String Password) {
		password.sendKeys(Password);
	}
	
	public void clickLogin() {
		login.click();
	}

}
