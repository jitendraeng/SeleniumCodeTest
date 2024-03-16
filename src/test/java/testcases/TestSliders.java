package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestSliders {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		
		WebElement mainSlider = driver.findElement(By.xpath("//*[@id=\"slider\"]"));
		int width = mainSlider.getSize().width/2;
		
		System.out.println(mainSlider.getSize().width);
		
		System.out.println(width);
		
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));

		Thread.sleep(2000);
		
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, mainSlider.getSize().width, 0).perform();
	}

}
