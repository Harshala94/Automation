package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Users/Gaurav Prakash/OneDrive - LPS/Gaurav LPS One Drive/LPS Automation/Workspace LPS/POMAutomation/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
			System.out.println("Property File is Reffered from the base class");
		}
		
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		
	}
	
	public static void initialization() {
		
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/Gaurav Prakash/Downloads/chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Driver initiated");
		}
		
		else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:/Users/Gaurav Prakash/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		System.out.println("Url is launched successfully");
		
	}
	
	
	

}
