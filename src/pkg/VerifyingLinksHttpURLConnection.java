package pkg;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyingLinksHttpURLConnection {
	WebDriver driver;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void verifying() {
		driver.get("https://www.facebook.com");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		//System.out.println("links count = " + links);
		
		for(WebElement element :links) {
			String link = element.getAttribute("href");
			//System.out.println("each link" + link);
			
			verify(link);
		}
	}

	private void verify(String link) {
		try {
			URL ob = new URL(link);
			HttpURLConnection http = (HttpURLConnection)ob.openConnection();
			http.connect();
			if(http.getResponseCode()==200) {
				System.out.println("valid link" + link);
			}
			else if(http.getResponseCode()==404) {
				System.out.println("broken link" + link);
			}
			else {
				System.out.println("others");	
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}



}
