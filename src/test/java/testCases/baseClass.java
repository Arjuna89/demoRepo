package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import utilities.readConfig;

public class baseClass {
	
	public static WebDriver driver;
	readConfig rc = new readConfig();
	
	public String url =  rc.getURL();
	public String userName = rc.getUserName();
	public String Password = rc.getPassword();
	public String fname = rc.getfName();
	public String lname = rc.getlname();
	public String postal = rc.getPostal();

	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
