package stepsdefinitions;

import org.junit.Assert;
import com.simplilearn.cucumberdemo.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private LoginPage loginPage;
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	    loginPage = new LoginPage(Hooks.driver);
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	    loginPage.enterUsername(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		loginPage.enterPassword(password);	    
	}

	@When("user clicks login button")
	public void user_clicks_login_button() {
	    loginPage.clickLogin();
	}

	@Then("user should see the dashboard")
	public void user_should_see_the_dashboard() {
		// Give some wait to load the dashboard page
		try {Thread.sleep(3000);} catch (InterruptedException ignored) {}
	    Assert.assertTrue(loginPage.isDashboardVisible());
	}


}
