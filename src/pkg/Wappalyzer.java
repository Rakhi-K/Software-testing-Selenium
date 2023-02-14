package pkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wappalyzer {
	
	WebDriver driver;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void linkCount() {
		driver.get("https://www.wappalyzer.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[1]/header/div/div/div/div[2]/button[2]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"list-item-49\"]/div/div[1]")).click();
		
		WebElement searchfield =  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]"));
	
		searchfield.sendKeys("Shopify");
		Select s = new Select(searchfield);
		s.selectByValue("Shopify apps");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/div/div/a/span")).click();
	
		
		

	}


}
