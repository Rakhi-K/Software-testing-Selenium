package TestNgPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assertions {
	
WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void load() {
		driver.get("https://www.google.com");
		String actualTtile = driver.getTitle();
		String exp="Google";
		Assert.assertEquals(actualTtile, exp, "title right");
		
	}

}
