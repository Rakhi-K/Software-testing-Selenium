package TestNgPkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {
WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void load() {
		driver.get("https://www.expedia.com/?siteid=1&langid=1033&clickref=1011lweWFgpv&affcid=US.DIRECT.PHG.1100l243250.1100l68075&ref_id=1011lweWFgpv&my_ad=AFF.US.DIRECT.PHG.1100l243250.1100l68075");
	}
	
	public void date() {
		driver.findElement(By.xpath("//*[@id=\"d1-btn\"]")).click();
		while(true) {
			WebElement month = driver.findElement(By.xpath("//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/h2"));
			String monthtext = month.getText();
			if(monthtext.equals("November 2022")) {
				System.out.println(monthtext);
				break;
			}
			else {
				driver.findElement(By.xpath("//*[@class='uitk-calender']/div/button[2]")).click();
			}
		}
		
		List<WebElement> alldates = driver.findElements(By.xpath("//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr/td/button"));
		for(WebElement element:alldates) {
			String date = element.getAttribute("data-day");
			if(date.equals("18")) {
				System.out.println(date);
				element.click();
			}
		}
		 
	}
}
