package pkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollDownJSExecuter {
	WebDriver driver;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void verifying() {
		driver.get("https://www.google.com");
	WebElement search =	driver.findElement(By.name("q"));	
	search.sendKeys("books",Keys.ENTER);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	js.executeScript("window.scrollBy(0,250)","");
	}

}
