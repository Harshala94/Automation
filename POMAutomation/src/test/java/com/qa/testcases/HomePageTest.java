package com.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
		
	}
	
	@Test
	public void verifyHomePageTitleTest() throws InterruptedException {
		System.out.println("Runing Home Page Test");
		
		Thread.sleep(8000);
		String homePageTitle = homepage.verifyHomePageTitle();
		System.out.println("Home Page Title is: " + homePageTitle);
		Assert.assertEquals(homePageTitle, "Facebook","Home Page title not matched");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
