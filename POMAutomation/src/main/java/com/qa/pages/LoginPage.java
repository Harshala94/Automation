package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactory - Object Repostory OR-
	
	@FindBy(name="email")
	WebElement emailId;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(name= "login")
	WebElement loginBtn;
	
	public LoginPage() { 
		
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String eid, String pwd) {
		emailId.sendKeys(eid);
		System.out.println("Username entered");
		password.sendKeys(pwd);
		System.out.println("Password entered");
		loginBtn.click();
		System.out.println("Login button click");
		
		return new HomePage();
		
	}

}
