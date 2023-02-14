package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FbLoginPage;

public class fbLoginTest {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void load() {
		driver.get("https://www.facebook.com");
	}
	
	@Test
	public void testing() {
		FbLoginPage ob = new FbLoginPage(driver); 
		ob.setValues("rakhikarayi96@gmail.com", "123456789");
		ob.login();                                                                                                                                                                                                                                                         
		
	}
	

}
