package TestNgPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void dragAndDrop() {
		driver.get("https://demoqa.com/droppable");
		driver.manage().window().maximize();
		WebElement drag = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		WebElement drop = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop);
		act.perform();
		
		//WebElement drop = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		String d =drop.getText();
		System.out.println(d);
		
	}

}
