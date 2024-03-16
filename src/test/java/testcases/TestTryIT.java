package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestTryIT {

	public static WebDriver driver;

	public static void captureScreenshot() {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("./screenshot/" + fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void captureElementScreenshot(WebElement element) {

		Date d = new Date();
		String fileName = "Element_"+d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screenshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("./screenshot/" + fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws IOException {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.switchTo().frame("iframeResult");

		// driver.findElement(By.xpath("/html/body/button")).click();
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'",
				driver.findElement(By.id("mySubmit")));
		
		captureElementScreenshot(driver.findElement(By.id("mySubmit")));

		driver.switchTo().defaultContent();

		List<WebElement> frames = driver.findElements(By.tagName("iframe"));

		System.out.println(frames.size());

		for (WebElement frame : frames) {

			System.out.println(frame.getAttribute("id"));
		}

		captureScreenshot();

	}

}
