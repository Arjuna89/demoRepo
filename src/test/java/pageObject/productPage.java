package pageObject;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productPage {
	
	WebDriver ldriver;
	public double highestPriceITem;

	public productPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		
	}	
	
	@FindBy(id="react-burger-menu-btn") WebElement MenuItem;
	@FindBy(id="about_sidebar_link") WebElement AboutOption;
	@FindBy(xpath = "//div[@class='inventory_item_price']") public List<WebElement> priceITems;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") WebElement CartIcon;
	@FindBy(xpath =  "//span[contains(text(),'Your Cart')]") WebElement YourCart;
	@FindBy(xpath = "//button[@name='checkout']") WebElement checkOut;
	@FindBy(xpath = "//span[contains(text(),'Checkout: Your Information')]") WebElement YourInformation;
	@FindBy(xpath = "//input[@id='first-name']") WebElement fName;
	@FindBy(xpath = "//input[@id='last-name']") WebElement lName;
	@FindBy(xpath = "//input[@id='postal-code']") WebElement postalCode;
	@FindBy(xpath = "//input[@id='continue']") WebElement Contine;
	@FindBy(xpath = "//span[contains(text(),'Checkout: Overview')]") WebElement Overview;
	@FindBy(xpath = "//div[@class='summary_total_label']") WebElement TotalPrice;
	
	public void clickMenu() {
		
		MenuItem.click();
	}
	
	public void clickAbout() {
		AboutOption.click();
	}
	
	public void selectHighestPrice() {
		
		
		ArrayList<Double> PriceList = new ArrayList<Double>();
		for(WebElement sprice: priceITems) {
			double priceVal = Double.parseDouble(sprice.getText().substring(1));
			PriceList.add(priceVal);
		}		
		
		Double Lprice = 0.0;
		for(int i=0; i<PriceList.size(); i++) {
			if(PriceList.get(i)>Lprice) {
				Lprice = PriceList.get(i);
			}
		}
	
		highestPriceITem =  Lprice;
	}
	
	public void ClickCart(WebDriver driver) throws InterruptedException {
		CartIcon.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(YourCart.getText().equals("YOUR CART")) {
			System.out.println("user is taken to CART page");
		}else {
			System.out.println("user is not taken to CART page");
		}
	}
	
	public void clickCheckOut(WebDriver driver) throws InterruptedException {
		checkOut.click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(YourInformation.getText().equals("CHECKOUT: YOUR INFORMATION")) {
			System.out.println("user is navigated to CHECKOUT: YOUR INFORMATION page");
		}else {
			System.out.println("user is not navigated to CHECKOUT: YOUR INFORMATION page");
		}
	}
	
	public void EnteInformationandContinue(WebDriver driver, String fname, String lname, String postal) throws InterruptedException {
		fName.sendKeys(fname);
		Thread.sleep(1000);
		lName.sendKeys(lname);
		Thread.sleep(1000);
		postalCode.sendKeys(postal);
		Thread.sleep(1000);
		Contine.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(Overview.getText().equals("CHECKOUT: OVERVIEW")) {
			System.out.println("user is navigated to CHECKOUT: OVERVIEW page");
		}else {
			System.out.println("user is not navigated to CHECKOUT: OVERVIEW page");
		}
	}
	
	public void ValidateTotalPrice() {
		String TPrice = TotalPrice.getText().split(" ")[1].substring(1);
		if(TPrice.matches("\\d{2}.\\d{2}")){
			System.out.println("Total Price is shown in $xx.yy format: "+TotalPrice.getText().split(" ")[1]);
		}else {
			System.out.println("Total Price is not shown in $xx.yy format: "+TotalPrice.getText().split(" ")[1]);
		}
	}
}