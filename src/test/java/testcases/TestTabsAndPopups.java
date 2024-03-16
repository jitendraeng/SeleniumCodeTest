package testcases;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestTabsAndPopups {

	public static void main(String[] args) {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		WebDriver driver=new ChromeDriver(options);


		driver.get("https://sso.teachable.com/secure/673/identity/sign_up/email?wizard_id=QRhihZdOl2YxKTCw9K7tIxDbi4Htm6MeEb79I3JAjlIaPurQygCSzEui6TKElIx51d28Dc_o7PeuS_SU52e4rA");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		System.out.println("--------Printing window ids from the first window------");
		
		Set<String> winids = driver.getWindowHandles();
		Iterator<String> iterator = winids.iterator();
		
		String first_window = iterator.next();
		System.out.println(first_window);
	
		driver.findElement(By.linkText("Privacy Policy")).click();
		
		System.out.println("--------Printing window ids from the Second window------");
		
		
		winids = driver.getWindowHandles();
		iterator = winids.iterator();
		
		System.out.println(iterator.next()); //first window
		String second_window = iterator.next(); //second
		System.out.println(second_window);
		
		driver.switchTo().window(second_window);
		
		driver.findElement(By.partialLinkText("Login")).click();
		
		/*
		driver.close();
		driver.switchTo().window(first_window);
		driver.close();
		*/
		
		
		driver.quit();
		
		

	}

}
