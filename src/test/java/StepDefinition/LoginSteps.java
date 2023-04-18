package StepDefinition;

import java.io.IOException;
import org.junit.runner.RunWith;
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
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
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

    //Code to verify login screen
    @Given("user is on login screen")
    public void user_is_on_login_screen() {
    validatelogin.validateloginpage();
}

    //Code to check login credentials are valid
    @Given("^credentials entered are valid$")
    public void credentials_entered_are_valid() throws IOException {
	validatecredentials.isCredentialValid();
    }

    //Code to check login credentials are invalid
    @Given("^credentials entered are invalid$")
    public void credentials_entered_are_invalid() throws IOException {
	validatecredentials.isCredentialInvalid();
    }
    
    //Code to enter email id and password
    @When("^user enters (.+) and (.+)$")
    public void user_enters_Email_and_Password(String Email, String Password) throws IOException {
	 login.enterEmail(Email);
	 login.enterPassword(Password);
    }
    
    //Code for login success message
    @Then("^login success message should be displayed$")
    public void login_success_message_should_be_displayed() throws InterruptedException {
	login.loginsuccess();
	Thread.sleep(5000);
    }

    //Code for login error message
    @Then("^login error message should be displayed$")
    public void login_error_message_should_be_displayed() throws InterruptedException {
	login.loginerror();
	Thread.sleep(5000);
    }

    //Code to check login credentials are valid or not
    @And("^clicks on login button and check (.+) and (.+) entered are valid or not$")
    public void clicks_on_login_button_and_check_and_entered_are_valid_or_not(String Email, String Password)
			throws IOException {
	 login.clickLogin();
	 validatecredentials = new ValidInvalidCredential();
	 validatecredentials.isCredentialValidInvalid(Email, Password);    
    }
    
    //Code to navigate on the Dashboard
    @And("^user should be navigated to the dashboard$")
    public void user_should_be_navigated_to_the_dashboard() throws InterruptedException {
	 login.dashboardhighlighted();
	 Thread.sleep(5000);
    }
}
