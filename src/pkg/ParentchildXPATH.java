package pkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentchildXPATH {

	WebDriver driver;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void testing() {
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		WebElement searchMobile = driver.findElement(By.xpath("//*[@id='nav-xshop']/a[3]"));
		searchMobile.click();
		WebElement searchELECTRONCS = driver.findElement(By.xpath("//*[@id='nav-xshop']/a[7]"));
		searchELECTRONCS.click();
		WebElement cart = driver.findElement(By.xpath("//*[@id='nav-tools']/a[4]"));
		cart.click();
		WebElement hello = driver.findElement(By.xpath("//*[@id='nav-tools']/a[2]"));
		hello.click();  
		WebElement hellosign = driver.findElement(By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a[1]/span[1]"));
		hellosign.click();
		driver.navigate().back();
		WebElement hamburger = driver.findElement(By.xpath("//*[@id='nav-main']/[@id='nav-hamburger-menu']")); 
		hamburger.click();
		
		
		

	}

}
