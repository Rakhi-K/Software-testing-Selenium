package TestNgPkg;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VrlTestExample {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@BeforeMethod
	public void urlLoading() {
		driver.get("https://www.vrlbus.in/vrl2013/register_customer.aspx");
	}

	@Test
	public void titleVerification() {
		String title = driver.getTitle();
		System.out.println("title is " + title);
	}

	@Test
	public void registerText() {
		WebElement text = driver.findElement(By.xpath("//*[@id=\"Button1\"]"));
		String textValue = text.getAttribute("value");
		System.out.println("textValue is " + textValue);
	}

	@Test
	public void linkCount() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("LINK COUNT is " + links.size());

	}

	@Test
	public void bUTTONtEXT() {
		WebElement BUttonText = driver.findElement(By.xpath("//*[@id=\"Button1\"]"));
		String butText = BUttonText.getAttribute("value");
		String exp = "Register";
		if (butText.equals(exp)) {
			System.out.println("Present pass");
		} else {
			System.out.println("not present failed");
		}
	}

//	@Test
//	public void cityField () {
//		WebElement city= driver.findElement(By.xpath("//*[@id=\"CITYID\"]"));
//		city.s
//		System.out.println("LINK COUNT is " +  links);
//	
//	}

	@Test
	public void checkbox() {
		Boolean check = driver.findElement(By.xpath("//*[@id=\"terms_conditions\"]")).isSelected();
		if (check) {
			System.out.println("Yes checked");
		} else {
			System.out.println("not  checked");
		}

	}

	@Test
	public void fillFiled() {
		driver.findElement(By.xpath("//*[@id=\"FIRSTNAME\"]")).sendKeys("Rakhi");
		driver.findElement(By.xpath("//*[@id=\"LASTNAME\"]")).sendKeys("Kiran");
		driver.findElement(By.xpath("//*[@id=\"MOBILENUMBER\"]")).sendKeys("6959874569");
		driver.findElement(By.xpath("//*[@id=\"COMPANY\"]")).sendKeys("ABC");
		driver.findElement(By.xpath("//*[@id=\"ADDRESS\"]")).sendKeys("ABC1, THV");
		driver.findElement(By.xpath("//*[@id=\"POSTALCODE\"]")).sendKeys("659635");
		Select city = new Select(driver.findElement(By.xpath("//*[@id=\"CITYID\"]")));
		city.selectByValue("73");
		Select state = new Select(driver.findElement(By.xpath("//*[@id=\"STATEID\"]")));
		state.selectByValue("4");
		driver.findElement(By.xpath("//*[@id=\"LOGINNAME\"]")).sendKeys("rakhi@gmail.com");
	}

	@Test
	public void LogoDisplayed() {
		Boolean logo = driver
				.findElement(By.xpath("//*[@id=\"main_div1\"]/div[2]/div/table/tbody/tr/td[1]/div[1]/a/img"))
				.isDisplayed();
		if (logo) {
			System.out.println("Yes displayed");
		} else {
			System.out.println("not  displayed");
		}
	}

	@Test
	public void takeScreenshot() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./ScreenShots//vrlPage.png"));
	}
	
	@Test
	public void alert()  {
		driver.findElement(By.xpath("//*[@id=\"Button1\"]")).click();
		 Alert box = driver.switchTo().alert();
		 box.accept(); 
	}


}
