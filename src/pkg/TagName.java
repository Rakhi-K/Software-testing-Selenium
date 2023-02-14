package pkg;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TagName {

	WebDriver driver;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void testing() {
		driver.get("https:\\www.facebook.com");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("links count = " + links);
		
//		for (WebElement element : links) {
//			String allLinks = element.getAttribute("href");
//			String texts = element.getText() ;
//			System.out.println(allLinks + " - " + texts);
//		}
		
//		for( int i=0;i<=links.size();i++) {
//			WebElement element = links.get(i);
//			String allLinks = element.getAttribute("href");
//			String texts = element.getText() ;
//			System.out.println(allLinks + " - " + texts);
//		}
	}
}
