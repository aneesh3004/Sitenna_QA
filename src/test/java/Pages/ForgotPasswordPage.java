package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
	
	WebDriver driver;

	By forgotpassword_link = By.id("forgot_password");
	By resetpassword_email = By.id("reset_password_email");
	By resetpassword_btn = By.id("reset_password_button");
	By create_new_password = By.id("new_password");
	By repeat_new_password = By.id("repeat_new_password");
	By continue_btn = By.id("create_password_continue_button");
	
	// Constructor to initialize driver
		public ForgotPasswordPage(WebDriver driver) {
			this.driver = driver;
		}
	
	//Method to enter reset password email
	public void resetpasswordemail (String Email) {
		driver.findElement(resetpassword_email).sendKeys(Email);
	}
	
	// Method to check user is on login page or not
		public String validateloginpage() {
			String ActualURL = driver.getCurrentUrl();
			String ExpectedURL = "https://qa.sitenna.com/#/auth/signin";
			try {
				Assert.assertEquals(ExpectedURL, ActualURL);
				System.out.println("User is on login page");
			} catch (AssertionError e) {
				System.out.println(e.getMessage());
				System.out.println("User is not on login page");
			}
			return ActualURL;
		}
		
		
}
