package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[contains(text(), \"Harshala Sawant\")]")
	WebElement userProfileName;
	
	//testpush
	
	
	@FindBy(xpath="//span[contains(text(),\"Friends\")]")
	WebElement friendsLink;
	

	@FindBy(xpath="//span[contains(text(),\"Home\")]")
	WebElement homeLink;
	
	//Initializing Page Objects
	public HomePage() {

		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		//System.out.println("Title of Home Page " + driver.getTitle());
		return driver.getTitle();
		
		
	}
	
	public void clickOnFriendsLink() {
		friendsLink.click();
		
	}

}
