package TestNgPkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidationLogin {
	
WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void excelValuesAdd() throws IOException {
		
		File f = new File("D:\\LoginVlaidation.xlsx");
		InputStream fi = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet sh = wb.getSheet("Sheet1");
		System.out.println(sh.getLastRowNum());
		
		for(int i=1;i<=sh.getLastRowNum();i++) {
			String userName = sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("userName =" + userName);
			String password = sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("password = " + password);
			driver.get("https://prod-auth.cloud.utest.com/auth/realms/applause/protocol/openid-connect/auth/?client_id=utestv2&redirect_uri=https%3A%2F%2Fwww.utest.com%2Foauth-login%2F&response_type=code");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(userName);
			driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
			driver.findElement(By.name("login")).click();
			
		String actualUrlLogin = driver.getCurrentUrl();
		String expUrl = "https://www.utest.com/";
		if(expUrl.equals(actualUrlLogin)) {
			System.out.println("login passed");
			
		}
		else {
			System.out.println("login failed");
		}
		}
		
		
	}
	

}
