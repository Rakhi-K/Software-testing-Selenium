package pkg;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {
	WebDriver driver;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void ScreenShotTaking() throws IOException {
		driver.get("https://www.facebook.com");
		//for handing a single element
		//first locate
	WebElement button =	driver.findElement(By.name("login"));
	File src  = button.getScreenshotAs(OutputType.FILE);
	//storing in same prjct 0 folder created and path given
	FileHandler.copy(src,new File("./ScreenShots/srcScreenshot.png"));

	
	
	//screenshot whole page
	File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//storein system
	FileHandler.copy(src1, new File("D://srcScr.png"));
		
	}

}
