package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestNewWindow {

	public static void main(String[] args) {


		
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		WebDriver driver=new ChromeDriver(options);


		driver.get("https://sso.teachable.com/secure/673/identity/sign_up/email?wizard_id=QRhihZdOl2YxKTCw9K7tIxDbi4Htm6MeEb79I3JAjlIaPurQygCSzEui6TKElIx51d28Dc_o7PeuS_SU52e4rA");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://gmail.com");
		System.out.println(driver.getTitle());

		
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		
		
		System.out.println(driver.getWindowHandles().size());
		
	}

}
