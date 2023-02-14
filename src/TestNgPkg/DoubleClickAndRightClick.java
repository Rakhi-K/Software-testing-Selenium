package TestNgPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClickAndRightClick {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void RightClickDoubleClick() {
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();
		WebElement rightClick = driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
		Actions act = new Actions(driver);
		act.contextClick(rightClick);
		act.perform();
		driver.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[1]")).click();
		driver.switchTo().alert().accept();
		
		WebElement doubleClick = driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
		act.doubleClick(doubleClick);
		act.perform();
		driver.switchTo().alert().accept();
		
		
		}

}
