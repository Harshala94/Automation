package com.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		System.out.println("Runing Login Page Test, Priority 1");
		String title= loginpage.validateLoginPageTitle();
		System.out.println("Login Page Title is : "+title);
		Assert.assertEquals(title, "Facebook – log in or sign up");
	}
	
	@Test(priority=2)
	public void loginTest() {
		System.out.println("Runing Login Page Test, Priority 2");
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
