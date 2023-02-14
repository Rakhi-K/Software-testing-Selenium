package pkg;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				
				
				
				"D:\\SELENIUM\\Browser extension file - 105.0.5195.52\\chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		//title verification
		String actualtitle = driver.getTitle();
		String exptitle = "Google";
		if (actualtitle.equals(exptitle)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		
		//page source
		String text ="Gmail";
		String src = driver.getPageSource();
		if(src.contains(text)) {
			System.out.println("present");
		} else {
			System.out.println("not present");
		}

	}
}
