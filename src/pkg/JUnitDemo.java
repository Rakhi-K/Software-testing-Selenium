package pkg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JUnitDemo {
	WebDriver driver;
	
	@Before
	public void setUp() {
		//load
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void titleVerification() {
		//get site
		driver.get("https:\\www.facebook.com");
		
		String actual = driver.getTitle();
		System.out.println(actual);
		String Exp = "Google";
		
		if(actual.equals(Exp)) {
			System.out.println("present");
		}
		else {
			System.out.println(" not present");
		}
		
		
		//locators
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("aaa");
		driver.findElement(By.name("login")).click();
		
	}
	
	@After
	public void close() {
		driver.close();
	}
	

}
