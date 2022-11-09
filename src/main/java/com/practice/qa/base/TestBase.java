package com.practice.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;

import com.practice.qa.utill.WebEventListener;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	
	

	public TestBase() {
	
	try{
	prop = new Properties();	
	FileInputStream f = new FileInputStream("/Volumes/personal data/NIKUL QA/Selenium_WorkSpace/Free_Crm_POM/src/main/java/com/practice/qa/config/config.properties");
	prop.load(f);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	
	public static void initialization() throws IOException, InterruptedException{

		String browser = prop.getProperty("browser"); 
		
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/sai/Downloads/SeleniumJars//geckodriver");
			driver = new FirefoxDriver(); 
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/sai/Downloads/SeleniumJars/Chrome107//chromedriver");
			driver = new ChromeDriver(); 
		}

		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //MAX TIME
		
		
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);

		
	}
	
	
	
	
	
	
	
	

}
