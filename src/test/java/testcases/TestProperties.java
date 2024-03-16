package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestProperties {
	
	
	public static WebDriver driver;
	public static Properties OR = new Properties();
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(TestProperties.class);
	
	
	/*
	 * 
	 * Log4j - dep
	 * Logger - getLogger() - INFO, DEBUG, ERROR
	 * Log4j.properties - Appenders - Log Level
	 * PropertyConfigurator
	 * 
	 * 
	 * 
	 */
	
	
	public static void click(String locatorKey) {
		
		if(locatorKey.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locatorKey))).click();
			
		}else if(locatorKey.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locatorKey))).click();
			
		}else if(locatorKey.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).click();
			
		}
		
		
		log.info("Clicking on an Element : "+locatorKey);
		
	}


	
	public static void type(String locatorKey, String value) {
		
		if(locatorKey.endsWith("_XPATH")) {
			driver.findElement(By.xpath(OR.getProperty(locatorKey))).sendKeys(value);
			
		}else if(locatorKey.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(locatorKey))).sendKeys(value);
			
		}else if(locatorKey.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(OR.getProperty(locatorKey))).sendKeys(value);
			
		}
		log.info("Typing in an element : "+locatorKey+"  entered the values as : "+value);
		
	}
	
	
	

	public static void main(String[] args) throws IOException {
		
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		

		log.info("Test execution started");
		
		fis = new FileInputStream("./src/test/resources/properties/OR.properties");
		OR.load(fis);
		
		log.info("OR Properties loaded");
		
		
		
		fis = new FileInputStream("./src/test/resources/properties/Config.properties");
		config.load(fis);
		log.info("Config properties loaded");
		
		
		
		//driver.findElement(By.id(OR.getProperty("username_ID"))).sendKeys()
		System.out.println(OR.getProperty("username_ID"));
		
		
		//driver.get(config.getProperty("testsiteurl"))
		System.out.println(config.getProperty("testsiteurl"));

		
		
		if(config.getProperty("browser").equals("chrome")){
			
			ChromeOptions options = new ChromeOptions();

			options.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(options);
			log.info("Chrome browser launched");
			
		}else if(config.getProperty("browser").equals("firefox")){
			
			driver = new FirefoxDriver();
			log.info("Firefox browser launched");
			
		}
		
		
		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigated to the test site url: "+config.getProperty("testsiteurl"));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicit.wait"))));
		

		
		type("username_ID","java@way2automation.com");
		click("nextBtn_XPATH");
		type("pass_CSS","sdfsfdsf");
		
		
		
		driver.quit();
		log.info("Test execution completed");
	}

}
