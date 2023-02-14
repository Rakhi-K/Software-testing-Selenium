package TestNgPkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CopyPaste {
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void copyandpaste() {
//		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
//		
//	WebElement fullName =	driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input"));
//	WebElement email = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]"));
//	fullName.sendKeys("Rakhi Karayi");
//	
//	Actions act = new Actions(driver);
//	act.keyDown(fullName,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
//	act.keyDown(fullName,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
//	act.keyDown(email,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
//	act.perform();
	
		
		
	
	//,mouse hover inebay site
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	driver.get("https://www.ebay.com/");
	driver.manage().window().maximize();
	
	WebElement elecronics =	driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/a"));
	
	Actions act = new Actions(driver);
	act.moveToElement(elecronics);
	act.perform();
	
	WebElement c = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/nav[1]/ul/li[1]/a"));
	wait.until(ExpectedConditions.elementToBeSelected(c));
	c.click();
	 
		
	
	
	}

}
