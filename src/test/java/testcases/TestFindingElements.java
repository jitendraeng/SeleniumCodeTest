package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestFindingElements {

	public static void main(String[] args) throws InterruptedException {


		
		WebDriver driver = new ChromeDriver();
		driver.get("http://gmail.com");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		//driver.manage().window().maximize();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		String title = driver.getTitle();
		title.length();
		
		
		driver.getTitle().length();
		
		
		///WebElement username = driver.findElement(By.id("identifierId"));
		//username.sendKeys("trainer@way2automation.com");
		
		
		driver.findElement(By.id("identifierId")).sendKeys("trainer@way2automation.com");
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		//Thread.sleep(10000);
		//driver.findElement(By.name("Passwd")).sendKeys("sdfdsfs");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("Passwd"))).sendKeys("sdffsfd");
		
		
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
		
		//System.out.println(driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div[1]/div/form/span/section[2]/div/div/div[1]/div[2]/div[2]/span")).getText());
		System.out.println(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div[1]/div/form/span/section[2]/div/div/div[1]/div[2]/div[2]/span"))).getText());
		
	}

}
