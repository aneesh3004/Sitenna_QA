package StepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import PageElements.ForgotPasswordPage;
import PageElements.LoginPage;
import PageElements.PageObjectManager;
import Utils.GenericUtils;
import Utils.TestContxtSetup;
import Utils.TestBase;
import Utils.ValidInvalidCredential;
import Utils.ValidateLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordSteps {

	TestContxtSetup testContxtSetup;
	TestBase testbase;
	PageObjectManager pageobjectmanager;
	GenericUtils genericutils;
	LoginPage login;
	ValidInvalidCredential validatecredentials;
	ValidateLoginPage validateloginpage;
	ForgotPasswordPage forgotpassword;
	
	public ForgotPasswordSteps(TestContxtSetup testContxtSetup) {
		this.testContxtSetup = testContxtSetup;
		this.forgotpassword = testContxtSetup.pageobjectmanager.getForgotPasswordPage();
	}
	// Code to launch browser
	@Given("^browser is launched$")
	public void browser_is_launched() throws IOException, InterruptedException {
		testbase = new TestBase();
		testbase.WebDriverManager();
		Thread.sleep(3000);
	}

	// Code to click on forgot password link and check if user is on forgot password page
	@Then("^user clicks on the Forgot Password link and check if the user is on forgot password page$")
	public void user_clicks_on_the_forgot_password_link_and_check_if_the_user_is_on_forgot_password_page()
			throws InterruptedException {
		forgotpassword.validateforgotpasswordpage();
		Thread.sleep(5000);
	}

	// Code to enter email
	@When("^user fills the (.+)$")
	public void user_enters_the(String Email) throws InterruptedException {
		forgotpassword.resetpasswordemail(Email);
		Thread.sleep(3000);
	}

	// Code to click on reset password button & check the message for checking the mail
	@And("^clicks on Reset Password button and message should be displayed to check the mail$")
	public void clicks_on_reset_password_button_and_message_should_be_displayed_to_check_the_mail() throws InterruptedException {
		forgotpassword.checkmailsuccess();
		Thread.sleep(5000);
	}

	
	 // Code to open a URL in a new tab	  
	 @Given("^a new tab is opened and mail URL address is entered$") 
	 public void a_new_tab_is_opened_and_mail_url_address_is_entered() throws AWTException,InterruptedException { 
		 Robot robot = new Robot();
	     robot.keyPress(KeyEvent.VK_CONTROL); 
	     robot.keyPress(KeyEvent.VK_T);
	     robot.keyRelease(KeyEvent.VK_CONTROL); 
	     robot.keyRelease(KeyEvent.VK_T);
	     Thread.sleep(3000);
	     
	    //Switch focus to new tab
		/*
		 * ArrayList<String> tabs = new ArrayList<String>
		 * (launchbrowser.driver.getWindowHandles());
		 * launchbrowser.driver.switchTo().window(tabs.get(1));
		 * driver.get("https://www.mailinator.com/");
		 */
	}	 
	
	/*
	 * // Code to enter the mail id and click on go button
	 * 
	 * @When("^user fills (.+) and clicks on Go button$") public void
	 * user_enters_and_clicks_on_go_button(String Mail_Email) {
	 * forgotpassword.mailsearch(Mail_Email); }
	 * 
	 * 
	 * // Code to fetch the mail and open it
	 * 
	 * @Given("^user fetches and opens the mail with Subject Reset Password$")
	 * public void user_fetches_and_opens_the_mail_with_subject_reset_password() {
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