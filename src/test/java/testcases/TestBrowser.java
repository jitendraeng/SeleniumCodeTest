package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBrowser {
	
	public static String browser = "chrome"; //notepad
	public static WebDriver driver;
	
	
	
	
	public static void main(String[] args) {

		
		//Child1 c1 = new Child1()
		//Child2 c2 = new Child2()
		//Parent p1 = new Child2();
		//Parent p2 = new Child1();
		//
		
		
		if(browser.equals("chrome")) {
			
			driver = new ChromeDriver();
			
		}else if(browser.equals("firefox")) {
			
		   driver = new FirefoxDriver();
			
		}

		
		driver.get("http://gmail.com");
		String title = driver.getTitle();
		System.out.println(title);
		//driver.close(); //current browser
		driver.quit(); //kills the entire session closing all opened browsers in the current session

	}

}
