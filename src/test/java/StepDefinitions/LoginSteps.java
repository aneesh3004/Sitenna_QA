package StepDefinitions;

import Pages.LoginPage;
import Util.BrowserLaunch;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	LoginPage login;
	BrowserLaunch launchbrowser;

	// Code to launch the browser
	@Given("^user launches a browser$")
	public void user_launches_a_browser() throws InterruptedException {
		launchbrowser = new BrowserLaunch();
		launchbrowser.browserlaunch();
		Thread.sleep(3000);
	}

	// Code to enter the URL & go on to the login page
	@And("^enters the URL address and is on login page$")
	public void enters_the_URL_address_and_is_on_login_page() throws InterruptedException {
		String URL = "https://qa.sitenna.com";
		launchbrowser.driver.get(URL);
		Thread.sleep(2000);
	}

	// Code to enter email id & password
	@When("^user enters (.+) and (.+)$")
	public void user_enters_Email_and_Password(String Email, String Password) throws InterruptedException {
		login = new LoginPage(launchbrowser.driver);
		login.enterEmail(Email);
		login.enterPassword(Password);
		Thread.sleep(3000);
	}

	// Code to click on the login button
	@And("^clicks on login button$")
	public void clicks_on_login_button() throws InterruptedException {
		login.clickLogin();
		Thread.sleep(3000);
	}

	@Then("^check (.+) and (.+) entered are valid or not$")
	public void check_and_entered_are_valid_or_not(String Email, String Password) {
		login.isCredentialValidInvalid(Email, Password);
	}

	@Given("^credentials entered are valid$")
	public void credentials_entered_are_valid() {
		login.isCredentialValid();
	}

	@Then("^login success message should be displayed$")
	public void login_success_message_should_be_displayed() {
		login.loginsuccess();
	}

	@And("^user should be navigated to the dashboard$")
	public void user_should_be_navigated_to_the_dashboard() throws InterruptedException {
		login.dashboardhighlighted();
		Thread.sleep(5000);
	}

	// Code to close the browser
	@And("^browser gets closed$")
	public void browser_gets_closed() {
		login.browserclose();
	}

	@Given("^credentials entered are invalid$")
	public void credentials_entered_are_invalid() {
		login.isCredentialInvalid();
	}

	@Then("^login error message should be displayed$")
	public void login_error_message_should_be_displayed() throws InterruptedException {
		login.loginerror();
		Thread.sleep(3000);
	}
}
