package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookLoginSteps {
	
		
	
	@Given("User is on Facebook Login Page")
	public void LoadFacebookPage() {
		 System.out.println("User is on FacebookPage");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
	    System.out.println("Username password is correct");
	}

	@And("clicks on login page")
	public void clicks_on_login_page() {
		 System.out.println("User login button clicks");
	}

	@Then("verify that user is navigated to home page")
	public void verify_that_user_is_navigated_to_home_page() {
		 System.out.println("Login successful");
	}

}
