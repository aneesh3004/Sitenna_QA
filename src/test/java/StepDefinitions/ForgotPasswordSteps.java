package StepDefinitions;

import Pages.ForgotPasswordPage;
import Util.BrowserLaunch;
import Util.ValidateLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordSteps {

	BrowserLaunch launchbrowser;
	ForgotPasswordPage forgotpassword;
	ValidateLoginPage validateloginpage;

	@Given("^browser is launched$")
	public void browser_is_launched() throws InterruptedException {
		launchbrowser = new BrowserLaunch();
		launchbrowser.browserlaunch();
		Thread.sleep(3000);
	}

	@When("^user enters the (.+)$")
	public void user_enters_the(String Email) {
		forgotpassword.resetpasswordemail(Email);
	}

	@When("^user enetrs (.+) and (.+)$")
	public void user_enetrs_and(String CreateNewPassword, String RepeatNewPassword) {
		forgotpassword.enterresetpassword(CreateNewPassword, RepeatNewPassword);
	}

	@Then("^user clicks on the Forgot Password link and check if the user is on forgot password page$")
	public void user_clicks_on_the_forgot_password_link_and_check_if_the_user_is_on_forgot_password_page() {
		forgotpassword.forgotpasswordlink();
		forgotpassword.validateforgotpasswordpage();
	}

	@Then("^user clicks on the Create New Password button in email and is on Create New Password window$")
	public void user_clicks_on_the_create_new_password_button_in_email_and_is_on_create_new_password_window() {

	}

	@Then("^error message displayed if both passwords entered are not same$")
	public void error_message_displayed_if_both_passwords_entered_are_not_same() {
		forgotpassword.validatepasswordmismatch();
	}

	@Then("^success message displayed if both passwords entered are same$")
	public void success_message_displayed_if_both_passwords_entered_are_same() {
		forgotpassword.validatepasswordmatch();
	}

	// Code to enter the URL & go on to the login page
	@And("^URL address is entered and checked if the user is on login page$")
	public void url_address_is_entered_and_checked_if_the_user_is_on_login_page() throws InterruptedException {
		String URL = "https://qa.sitenna.com";
		launchbrowser.driver.get(URL);
		forgotpassword = new ForgotPasswordPage(launchbrowser.driver);
		validateloginpage = new ValidateLoginPage();
		validateloginpage.validateloginpage();
		Thread.sleep(2000);
	}

	@And("^clicks on Reset Password button$")
	public void clicks_on_reset_password_button() {
		forgotpassword.resetpasswordbutton();
	}

	@And("^clicks on Continue button$")
	public void clicks_on_continue_button() {
		forgotpassword.continuebutton();
	}

	@And("^user is on login page$")
	public void user_is_on_login_page() {
		validateloginpage.validateloginpage();
	}
}
