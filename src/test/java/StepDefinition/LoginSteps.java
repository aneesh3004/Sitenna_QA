package StepDefinition;

import java.awt.AWTException;
import java.io.IOException;
import PageElements.PageObjectManager;
import PageElements.LoginPage;
import Utils.GenericUtils;
import Utils.TestContxtSetup;
import Utils.TestBase;
import Utils.ValidInvalidCredential;
import Utils.ValidateLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	TestContxtSetup testContxtSetup;
	TestBase testbase;
	PageObjectManager pageobjectmanager;
	GenericUtils genericutils;
	LoginPage login;
	ValidInvalidCredential validatecredentials;
	ValidateLoginPage validatelogin;
	
	
	public LoginSteps(TestContxtSetup testContxtSetup) {
		this.testContxtSetup = testContxtSetup;
		this.login = testContxtSetup.pageobjectmanager.getLoginPage();
	}

	// Code to launch the browser
	@Given("^user launches a browser$")
	public void user_launches_a_browser() throws IOException, InterruptedException {
	}

	// Code to enter the URL & go on to the login page
	@And("^enters the URL address and check if the user is on login page$")
	public void url_address_is_entered_and_checked_if_the_user_is_on_login_page() throws InterruptedException, AWTException {
		login.fetchURL();
		validatelogin.validateloginpage();
		Thread.sleep(2000);
	}

	// Code to enter email id & password
	@When("^user enters (.+) and (.+)$")
	public void user_enters_Email_and_Password(String Email, String Password) throws IOException {
		login.enterEmail(Email);
		login.enterPassword(Password);
	}

	// Code to check credentials are valid
	@Given("^credentials entered are valid$")
	public void credentials_entered_are_valid() throws IOException {
		validatecredentials.isCredentialValid();
	}

	@And("^clicks on login button and check (.+) and (.+) entered are valid or not$")
	public void clicks_on_login_button_and_check_and_entered_are_valid_or_not(String Email, String Password)
			throws IOException {
		login.clickLogin();
		validatecredentials = new ValidInvalidCredential();
		validatecredentials.isCredentialValidInvalid(Email, Password);		
	}

	// Code to display login success message
	@Then("^login success message should be displayed$")
	public void login_success_message_should_be_displayed() throws InterruptedException {
		login.loginsuccess();
		Thread.sleep(5000);
	}

	// Code to navigate on the dashboard
	@And("^user should be navigated to the dashboard$")
	public void user_should_be_navigated_to_the_dashboard() throws InterruptedException {
		login.dashboardhighlighted();
		Thread.sleep(5000);
	}

	// Code to check credentials are invalid
	@Given("^credentials entered are invalid$")
	public void credentials_entered_are_invalid() throws IOException {
		validatecredentials.isCredentialInvalid();
	}

	// Code to display login error message
	@Then("^login error message should be displayed$")
	public void login_error_message_should_be_displayed() throws InterruptedException {
		login.loginerror();
		Thread.sleep(5000);
	}
}
