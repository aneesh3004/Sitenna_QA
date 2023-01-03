package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Pages.ForgotPasswordPage;
import Pages.LoginPage;
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
	LoginPage login;

	WebDriver driver;

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

	@Then("^user clicks on the Forgot Password link and check if the user is on forgot password page$")
	public void user_clicks_on_the_forgot_password_link_and_check_if_the_user_is_on_forgot_password_page() {
		forgotpassword.forgotpasswordlink();
		forgotpassword.validateforgotpasswordpage();
	}

	@Then("^message should be displayed to check the mail$")
	public void message_should_be_displayed_to_check_the_mail() {
		forgotpassword.checkmailsuccess();
	}

	// Code to enter the URL & go on to the login page
	@And("^URL address is entered and checked if the user is on login page$")
	public void url_address_is_entered_and_checked_if_the_user_is_on_login_page(WebDriver WebDriver)
			throws InterruptedException {
		String URL = "https://qa.sitenna.com";
		launchbrowser.driver.get(URL);
		forgotpassword = new ForgotPasswordPage(launchbrowser.driver);
		validateloginpage = new ValidateLoginPage();
		validateloginpage.validateloginpage(WebDriver);
		Thread.sleep(2000);
	}

	@And("^clicks on Reset Password button$")
	public void clicks_on_reset_password_button() {
		forgotpassword.resetpasswordbutton();
	}

	@Given("^a new tab is opened$")
	public void a_new_tab_is_opened() {

	}

	@And("^mail URL address is entered$")
	public void mail_url_address_is_entered() {

	}

	@Given("^user fetches and opens the mail with Subject Reset Password$")
	public void user_fetches_and_opens_the_mail_with_subject_reset_password() {

	}

	@When("^user enters (.+) and clicks on Go button$")
	public void user_enters_and_clicks_on_go_button(String mailemail) {

	}

	@Then("^mail account of user opens$")
	public void mail_account_of_user_opens() {

	}

	@Then("^Create New Password window should open in new tab$")
	public void create_new_password_window_should_open_in_new_tab() {

	}

	@And("^clicks on Create New Password button$")
	public void clicks_on_create_new_password_button() {

	}

	@When("^user enetrs (.+) and (.+)$")
	public void user_enetrs_and(String CreateNewPassword, String RepeatNewPassword) {
		forgotpassword.enterresetpassword(CreateNewPassword, RepeatNewPassword);
	}

	@Then("^error message displayed if both passwords entered are not same$")
	public void error_message_displayed_if_both_passwords_entered_are_not_same() {
		forgotpassword.validatepasswordmismatch();
	}

	@Then("^success message displayed if both passwords entered are same$")
	public void success_message_displayed_if_both_passwords_entered_are_same() {
		forgotpassword.validatepasswordmatch();
	}

	@Then("^enter the (.+) & (.+)$")
	public void enter_the_(String Email, String NewPassword) {
		forgotpassword.enterEmailPassword(Email, NewPassword);
	}

	@Then("^login success message should be displayed$")
	public void login_success_message_should_be_displayed() {
		forgotpassword.loginsuccess();
	}

	@And("^clicks on Continue button$")
	public void clicks_on_continue_button() {
		forgotpassword.continuebutton();
	}

	@And("^user should be on login page$")
	public void user_should_be_on_login_page() {

	}

	// Code to click on the login button
	@And("^clicks on login button$")
	public void clicks_on_login_button() throws InterruptedException {
		forgotpassword.clickLogin();
		Thread.sleep(3000);
	}

	@And("^user should be navigated to the dashboard $")
	public void user_should_be_navigated_to_the_dashboard() {
		forgotpassword.dashboardhighlighted();
	}

	@And("^browser is closed$")
	public void browser_is_closed() {
		forgotpassword.browserclose();
	}
}
