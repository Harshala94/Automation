package seleniumdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.jodah.failsafe.internal.util.Assert;

public class AutomationPractise {

	
	public static void main(String[] args) throws InterruptedException {
		
		//Set System Property
		System.setProperty("webdriver.chrome.driver","C:\\Gaurav\\AutomationDemo\\chromedriver\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","C:\\Gaurav\\AutomationDemo\\geckodriver\\geckodriver.exe");
		
		
		//Initialise the Driver
		WebDriver driver = new ChromeDriver();
		//WebDriver driver= new FirefoxDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Defining Explicit Wait
		//WebDriverWait wait = new WebDriverWait(driver,20);
		
		//Launch the url
		driver.get("http://automationpractice.com");
		System.out.println("URL is launched successfully");
		//driver.manage().window().maximize();
		Thread.sleep(8000);
	
		//Implicit Wait
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		/*WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));*/
		
		
		//Hover on Womens section
		Actions hoverElement = new Actions(driver);
		
		WebElement myElement = driver.findElement(By.xpath("//a[@title=\"Women\"]"));
		hoverElement.moveToElement(myElement).build().perform();
		System.out.println("Hover is successful");
		Thread.sleep(5000);
		
		//Click on Summer Dress
		driver.findElement(By.xpath("//a[@title=\"Women\"]/parent::li/ul/li[2]/ul/li[3]/a[@title=\"Summer Dresses\"]")).click();;
		System.out.println("Clicked On Summer Dresses");
		Thread.sleep(8000);
		
		//Scroll to view the element
		WebElement dress30dollars = driver.findElement(By.xpath("//img[@src=\"http://automationpractice.com/img/p/1/6/16-home_default.jpg\"]"));
		js.executeScript("arguments[0].scrollIntoView();",dress30dollars);
		
		//Hover on Item to be added to Cart
		hoverElement.moveToElement(dress30dollars).build().perform();
		System.out.println("Hover on 30 Dollar dress succesful & Product added to the cart");
		Thread.sleep(8000);
		
		//Add Printed Summer Dress Item to Cart
		driver.findElement(By.xpath("//img[@src=\"http://automationpractice.com/img/p/1/6/16-home_default.jpg\"]/../../../following-sibling::div/div[2]/a/span[text()='Add to cart']")).click();
		Thread.sleep(8000);
		
		//Proceed to Checkout
		driver.findElement(By.xpath("//a[@title=\"Proceed to checkout\"]")).click();
		Thread.sleep(4000);
		
		//Scroll to view the element
		WebElement checkoutbtn = driver.findElement(By.xpath("//a[@class=\"button btn btn-default standard-checkout button-medium\"]"));
		js.executeScript("arguments[0].scrollIntoView();",checkoutbtn);
		Thread.sleep(2000);
		
		//Proceed to Cart
		checkoutbtn.click();
		Thread.sleep(4000);
		
		//Verify user is on Authentication Page
		String pageName= driver.findElement(By.xpath("//div[@class=\"center_column col-xs-12 col-sm-12\"]/h1[text()='Authentication']")).getText();
		System.out.println(pageName);
		if(pageName.equalsIgnoreCase("AUTHENTICATION")) {
			System.out.println("User is on Authentication Page");
		}
		else {
			System.out.println("Incorrect Page Opened");
		}
		
		//Hover on the Cart
		WebElement cart = driver.findElement(By.xpath("//a/b[text()='Cart']"));
		hoverElement.moveToElement(cart).build().perform();
		Thread.sleep(2000);
		
		//Remove from the Cart
		driver.findElement(By.xpath("//a[@title=\"remove this product from my cart\"]")).click();
		
		driver.quit();

	}

}
