package testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDropdown {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	

		//driver.findElement(By.id("searchLanguage")).sendKeys("Eesti");
		
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		
		Select select = new Select(dropdown);
		//select.selectByVisibleText("Eesti");
		select.selectByValue("hi");
		
		
		
		List<WebElement> values = dropdown.findElements(By.tagName("option"));
		System.out.println("Total values in dropdown list are : "+values.size());
		
		System.out.println(values.get(0).getAttribute("lang"));
		
		
		System.out.println(values.get(0).getText());
		
		
		System.out.println("----Printing all values-------");
		
		for(int i=0; i<values.size(); i++) {
			
			
			System.out.println(values.get(i).getAttribute("value"));
		}
		
		System.out.println("----Printing links-----");
		
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]/div[3]"));
		
		
		List<WebElement> links = block.findElements(By.tagName("a"));
		
		
		System.out.println("Total links are : "+links.size());
		
		
		
		for(WebElement link: links) {
			
			System.out.println(link.getAttribute("href")+"------and the text is : "+link.getText());
			
		}
		
		
		WebElement block2 = driver.findElement(By.id("block2"));
		
		block2.findElements(By.id("abc")).get(2).click();
		
		
		
		driver.findElements(By.xpath("//*[@id=\"load_form\"]/div[1]/div[2]/input")).get(1).click();
		driver.findElement(By.xpath("(//*[@id=\"load_form\"]/div[1]/div[2]/input)[2]")).click();
		
		
	}

}
