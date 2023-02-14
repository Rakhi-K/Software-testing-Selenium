package pkg;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rediff {
	WebDriver driver;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Test
	public void verifying() {
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		 Select sele = new Select(driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[22]/td[3]/select[1]")));
		 sele.selectByVisibleText("02");
		 
		Boolean logo = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/table[1]/tbody/tr[1]/td[1]/img")).isDisplayed();
		if(logo) {
			System.out.println("logo displayed");
		}
		else {
			System.out.println("logo not displayed");
		}
		
//check radio enbale or not
		Boolean radio = driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[24]/td[3]/input[1]")).isEnabled();
		if(radio) {
			System.out.println("radio enabled");
		}
		else {
			System.out.println("radio not enabled");
		}
		
		WebElement name = driver.findElement(By.xpath("//*[@id=\"Register\"]"));
		String nn = name.getAttribute("value");
		System.out.println(nn);
		String check ="Register";
		if(check.equals(nn)) {
			System.out.println("same");
		}
		else {
			System.out.println("not same");
		}
	}
	
	

}
