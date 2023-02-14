package TestNgPkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNgDemo {
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@BeforeMethod
	public void urlLoading() {
		driver.get("https://www.google.com");
	}
	
	@Test(priority=3,groups= {"sanity"})
	public void titleVerification() {
		System.out.println("Title verified");
	}
	
	@Test(priority=2,groups= {"sanity","smoke"})
	public void pageSource() {
		System.out.println("pageSource verified");
	}
	
	@Test(priority=5, enabled=false)
	public void buttonVerification() {
		System.out.println("BUTTON");
	}
	
	@Test(priority=1,invocationCount =3)
	public void logoDisplay() {
		System.out.println("logo Display");
	}
	
	@Test(priority=4,groups= {"regression"})
	public void ending() {
		System.out.println("ending");
	}
}
