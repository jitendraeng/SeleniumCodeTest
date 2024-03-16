package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestMouseOver {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		driver.get("https://www.way2automation.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		
		WebElement menu = driver.findElement(By.xpath("//*[@id=\"menu-item-27580\"]/a/span[2]"));
	
		
		Actions action = new Actions(driver);
		action.moveToElement(menu).perform();
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-27592\"]/a/span[2]")).click();
		
		
		
		
		
		
		
		

	}

}
