package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestRelativeLocators {
	
	public static WebDriver driver;
	
	public static boolean isElementPresent(By by) {
		
		try {
		driver.findElement(by);
		return true;
		}catch(Throwable t) {
			return false;
		}
	}
	
	
	
	

	public static void main(String[] args) {


		/*
		 * id
		 * name
		 * css
		 * xpath
		 * linkText
		 * partialLinkText
		 * tagName
		 * className
		 * above, below, rightOf, leftOf, near
		 * 
		 */
		
		
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		 driver=new ChromeDriver(options);


		driver.get("https://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		System.out.println(isElementPresent(By.xpath("//*[@id=\"load_form\"]/fieldset[1]/input")));
		

		
		
		/*
		WebElement above = driver.findElement(RelativeLocator.with(By.tagName("input")).above(By.tagName("select")));
		above.sendKeys("trainer@way2automation.com");
		
		WebElement below = driver.findElement(RelativeLocator.with(By.tagName("input")).below(By.tagName("select")));
		below.sendKeys("New Delhi");
		
		
		WebElement rightOf = driver.findElement(RelativeLocator.with(By.xpath("//*[@id=\"load_form\"]/fieldset[7]/input")).toRightOf(By.tagName("label")));
		rightOf.sendKeys("sdfsfdsf");
		
		
		WebElement near = driver.findElement(RelativeLocator.with(By.partialLinkText("THE")).near(By.linkText("Signin")));
		near.click();
		*/

		
		
		
		
		
		
		

	}

}
