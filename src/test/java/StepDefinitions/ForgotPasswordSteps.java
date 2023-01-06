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

	// Code to launch browser
	@Given("^browser is launched$")
	public void browser_is_launched() throws InterruptedException {
		launchbrowser = new BrowserLaunch();
		launchbrowser.browserlaunch();
		Thread.sleep(3000);
	}

	// Code to enter the URL & go on to the login page
	@And("^URL address is entered and checked if the user is on login page$")
	public void url_address_is_entered_and_checked_if_the_user_is_on_login_page() throws InterruptedException {
		String URL = "https://qa.sitenna.com";
		launchbrowser.driver.get(URL);
		forgotpassword = new ForgotPasswordPage(launchbrowser.driver);
		validateloginpage = new ValidateLoginPage();
		validateloginpage.validateloginpage(launchbrowser.driver);
		Thread.sleep(2000);
	}

	// Code to click on forgot password link and check if user is on forgot password
	// page
	@Then("^user clicks on the Forgot Password link and check if the user is on forgot password page$")
	public void user_clicks_on_the_forgot_password_link_and_check_if_the_user_is_on_forgot_password_page()
			throws InterruptedException {
		forgotpassword.validateforgotpasswordpage();
		Thread.sleep(5000);
	}

	// Code to enter email
	@When("^user enters the (.+)$")
	public void user_enters_the(String Email) throws InterruptedException {
		forgotpassword.resetpasswordemail(Email);
		Thread.sleep(3000);
	}

	@And("^clicks on Reset Password button and message should be displayed to check the mail$")
	public void clicks_on_reset_password_button_and_message_should_be_displayed_to_check_the_mail()
			throws InterruptedException {
		forgotpassword.checkmailsuccess();
		Thread.sleep(5000);
	}

	/*
	 * // Code to open a new tab
	 * 
	 * @Given("^a new tab is opened$") public void a_new_tab_is_opened() {
	 * forgotpassword.opennewtab(); }
	 * 
	 * // Code to enter the mail URL
	 * 
	 * @And("^mail URL address is entered$") public void
	 * mail_url_address_is_entered() { String URL = "https://www.mailinator.com/";
	 * driver.get(URL); }
	 * 
	 * // Code to fetch the mail and open it
	 * 
	 * @Given("^user fetches and opens the mail with Subject Reset Password$")
	 * public void user_fetches_and_opens_the_mail_with_subject_reset_password() {
	 * 
	 * }
	 * 
	 * // Code to enter the mail id and click on go button
	 * 
	 * @When("^user enters (.+) and clicks on Go button$") public void
	 * user_enters_and_clicks_on_go_button(String mailemail) {
	 * 
	 * }
	 * 
	 * // Code to check mail account opens
	 * 
	 * @Then("^mail account of user opens$") public void
	 * mail_account_of_user_opens() {
	 * 
	 * }
	 * 
	 * // Code to check create new password window opens
	 * 
	 * @Then("^Create New Password window should open in new tab$") public void
	 * create_new_password_window_should_open_in_new_tab() {
	 * 
	 * }
	 * 
	 * // Code to click on create new password button
	 * 
	 * @And("^clicks on Create New Password button$") public void
	 * clicks_on_create_new_password_button() {
	 * 
	 * }
	 * 
	 * // Code to enter new password
	 * 
	 * @When("^user enetrs (.+) and (.+)$") public void user_enetrs_and(String
	 * CreateNewPassword, String RepeatNewPassword) {
	 * forgotpassword.enterresetpassword(CreateNewPassword, RepeatNewPassword); }
	 * 
	 * // Code to display passwords mismatch message
	 * 
	 * @Then("^error message displayed if both passwords entered are not same$")
	 * public void error_message_displayed_if_both_passwords_entered_are_not_same()
	 * { forgotpassword.validatepasswordmismatch(); }
	 * 
	 * // Code to display password match message
	 * 
	 * @Then("^success message displayed if both passwords entered are same$")
	 * public void success_message_displayed_if_both_passwords_entered_are_same() {
	 * forgotpassword.validatepasswordmatch(); }
	 * 
	 * // Code to enter email & new password for login
	 * 
	 * @Then("^enter the (.+) & (.+)$") public void enter_the_(String Email, String
	 * NewPassword) { forgotpassword.enterEmailPassword(Email, NewPassword); }
	 * 
	 * // Code to display success message on login
	 * 
	 * @Then("^login success message to be displayed$") public void
	 * login_success_message_to_be_displayed() { forgotpassword.loginsuccess(); }
	 * 
	 * // Code to click on continue button
	 * 
	 * @And("^clicks on Continue button$") public void clicks_on_continue_button() {
	 * forgotpassword.continuebutton(); }
	 * 
	 * // Code to validate login page
	 * 
	 * @And("^user should be on login page$") public void
	 * user_should_be_on_login_page() {
	 * validateloginpage.validateloginpage(launchbrowser.driver); }
	 * 
	 * // Code to click on the login button
	 * 
	 * @And("^user clicks on login button$") public void
	 * user_clicks_on_login_button() throws InterruptedException {
	 * forgotpassword.clickLogin(); Thread.sleep(3000); }
	 * 
	 * // Code to navigate on the dashboard
	 * 
	 * @And("^user should be navigated to the dashboard $") public void
	 * user_should_be_navigated_to_the_dashboard() {
	 * forgotpassword.dashboardhighlighted(); }
	 * 
	 * // Code to close the browser
	 * 
	 * @And("^browser is closed$") public void browser_is_closed() {
	 * forgotpassword.browserclose(); }
	 */
}
