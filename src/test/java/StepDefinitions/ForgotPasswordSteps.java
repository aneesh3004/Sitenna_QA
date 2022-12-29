package StepDefinitions;

import Pages.ForgotPasswordPage;
import Pages.LoginPage;
import Util.BrowserLaunch;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordSteps {

	BrowserLaunch launchbrowser;
	ForgotPasswordPage forgotpassword;

	@Given("^user launches a browser$")
	public void user_launches_a_browser() throws InterruptedException {
		launchbrowser = new BrowserLaunch();
		launchbrowser.browserlaunch();
		Thread.sleep(3000);
	}

	@When("^user enters the (.+)$")
	public void user_enters_the(String email) {

	}

	@When("^user enetrs (.+) and (.+)$")
	public void user_enetrs_and(String newpassword, String repeatnewpassword) {

	}

	@Then("^user clicks on the Forgot Password link and check if the user is on forgot password page$")
	public void user_clicks_on_the_forgot_password_link_and_check_if_the_user_is_on_forgot_password_page() {

	}

	@Then("^user clicks on the Create New Password button in email and is on Create New Password window$")
	public void user_clicks_on_the_create_new_password_button_in_email_and_is_on_create_new_password_window() {

	}

	@Then("^error message displayed if (.+) and (.+) entered are not same$")
	public void error_message_displayed_if_and_entered_are_not_same(String newpassword, String repeatnewpassword) {

	}

	// Code to enter the URL & go on to the login page
		@And("^enters the URL address and check if the user is on login page$")
		public void enters_the_url_address_and_check_if_the_user_is_on_login_page() throws InterruptedException {
			String URL = "https://qa.sitenna.com";
			launchbrowser.driver.get(URL);
			forgotpassword = new ForgotPasswordPage(launchbrowser.driver);
			forgotpassword.validateloginpage();
			Thread.sleep(2000);
		}
		
	@And("^clicks on Reset Password button$")
	public void clicks_on_reset_password_button() {

	}

	@And("^clicks on Continue button$")
	public void clicks_on_continue_button() {

	}

	@And("^check whether (.+) and (.+) enetered are same or not$")
	public void check_whether_and_enetered_are_same_or_not(String newpassword, String repeatnewpassword) {

	}

	@And("^success message displayed if (.+) and (.+) entered are same$")
	public void success_message_displayed_if_and_entered_are_same(String newpassword, String repeatnewpassword) {

	}

}
