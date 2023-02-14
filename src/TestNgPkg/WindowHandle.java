package TestNgPkg;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void load() {
		driver.get("https://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		String parentWindow = driver.getWindowHandle();
		
		System.out.println("parent window = " + driver.getTitle());
		
		driver.findElement(By.xpath("/html/body/p/a")).click();
		
		Set<String> allwindowhandles = driver.getWindowHandles();
		for(String handle: allwindowhandles) {
			System.out.println(handle);
			
			if(!handle.equalsIgnoreCase(parentWindow)) {
				driver.switchTo().window(handle);
				
				String s = driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/h2")).getText();
				System.out.println(s);
				driver.close();
			}
			
			driver.switchTo().window(parentWindow);
		}
		
		
	}


}
