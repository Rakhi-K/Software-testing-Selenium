package pkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertBox {

	WebDriver driver;

	@Before
	public void setUpAlert() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void testing() {
		driver.get("file:///C:/Users/Rakhi/Desktop/seleniumAlertText.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[1]")).click();
		//to accept alert for single action
		//driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
		
		//[or
		 Alert box = driver.switchTo().alert();
		 System.out.println(box.getText());
		 box.accept(); 
		 
		 
		 //to dismiss
		 //box.dismiss();
		 
		 driver.findElement(By.xpath("//input[2]")).sendKeys("Rakhi");
		 driver.findElement(By.xpath("//input[3]")).sendKeys("Karayi");
		 driver.findElement(By.xpath("//input[4]"));
		 
		 
		 
		 
		
		
	}

}
