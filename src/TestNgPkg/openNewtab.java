package TestNgPkg;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openNewtab {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void load() {
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		String parentWindow = driver.getWindowHandle();

		WebDriver driver2 = driver.switchTo().newWindow(WindowType.TAB);
		
		driver2.get("https://www.facebook.com");
		driver2.close();
		driver.switchTo().window(parentWindow);
	}
}
