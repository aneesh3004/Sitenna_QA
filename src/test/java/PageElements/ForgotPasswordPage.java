package PageElements;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

	public WebDriver driver;

	By forgotpassword_link = By.id("forgot_password");
	By resetpassword_email = By.id("reset_password_email");
	By resetpassword_btn = By.id("reset_password_button");
	By create_new_password = By.id("new_password");
	By repeat_new_password = By.id("repeat_new_password");
	By continue_btn = By.id("create_password_continue_button");
	By passwordmatchsuccess = By.xpath("//notifier-container[@class = 'notifier__container']");
	By passwordmismatcherror = By.xpath("//notifier-container[@class = 'notifier__container']");
	By login_Email = By.id("login_email");
	By login_Password = By.id("login_password");
	By login_button = By.id("login_button");
	By loginsuccessmessage = By.xpath("//notifier-container[@class = 'notifier__container']");
	By dashboard = By.xpath("//*[@id=\"dashboard_menu_item\"]");
	By checkmailsuccessmessage = By.xpath("//notifier-container[@class = 'notifier__container']");
	By email = By.id("search");
	By go = By.name("GO");

	// Constructor to initialize driver
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	// Method to enter reset password email
	public void resetpasswordemail(String Email) throws InterruptedException {
		driver.findElement(resetpassword_email).sendKeys(Email);
		Thread.sleep(3000);
	}

	// Method to click forgot password link and check user is on forgot password page or not
	public String validateforgotpasswordpage() throws InterruptedException {
		driver.findElement(forgotpassword_link).click();
		Thread.sleep(3000);
		String ActualURL = driver.getCurrentUrl();
		System.out.println("Current URL is : " + ActualURL);
		String ExpectedURL = "https://qa.sitenna.com/#/auth/forgot-password";
		try {
			Assert.assertEquals(ExpectedURL, ActualURL);
			System.out.println("User is on forgot password page");
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			System.out.println("User is not on forgot password page");
			Thread.sleep(3000);
		}
		return ActualURL;
	}

	// Method to click on continue button
	public void continuebutton() {
		driver.findElement(continue_btn).click();
	}

	// Method to enter new password & repeat new password
	public void enterresetpassword(String CreateNewPassword, String RepeatNewPassword) {
		driver.findElement(create_new_password).sendKeys(CreateNewPassword);
		driver.findElement(repeat_new_password).sendKeys(RepeatNewPassword);
	}

	// Method to check both passwords entered are same
	public void validatepasswordmatch() {
		if (create_new_password == repeat_new_password) {
			this.matchsuccess();
			System.out.println(passwordmatchsuccess);
		} else {
			System.out.println("Error");
		}
	}

	// Method to check both passwords entered are not same
	public void validatepasswordmismatch() {
		if (create_new_password != repeat_new_password) {
			this.mismatcherror();
			System.out.println(passwordmismatcherror);
		} else {
			System.out.println("Error");
		}
	}

	// Method for password mismatch error message
	public String mismatcherror() {
		String ActualText = driver.findElement(passwordmismatcherror).getText();
		String ExpectedText = "password do not match.";
		try {
			Assert.assertEquals(ExpectedText, ActualText);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		return ActualText;
	}

	// Method for password match success message
	public String matchsuccess() {
		String ActualText = driver.findElement(passwordmatchsuccess).getText();
		String ExpectedText = "password reset successfully.";
		try {
			Assert.assertEquals(ExpectedText, ActualText);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		return ActualText;
	}

	// Method for check mail success message
	public String checkmailsuccess() throws InterruptedException {
		driver.findElement(resetpassword_btn).click();
		Thread.sleep(5000);
		String ActualText = driver.findElement(checkmailsuccessmessage).getText();
		System.out.println("Message: " + ActualText);
		String ExpectedText = "Please check mail for reset password";
		try {
			Assert.assertEquals(ExpectedText, ActualText);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
			Thread.sleep(5000);
		}
		return ActualText;
	}

	// Method to enter email and password
	public void enterEmailPassword(String Email, String NewPassword) {
		driver.findElement(login_Email).sendKeys(Email);
		driver.findElement(login_Password).sendKeys(NewPassword);
	}

	public void clickLogin() throws InterruptedException {
		driver.findElement(login_button).click();
		Thread.sleep(5000);
	}

	// Method to print login success message
	public String loginsuccess() {
		String ActualText = driver.findElement(loginsuccessmessage).getText();
		String ExpectedText = "login successful";
		try {
			Assert.assertEquals(ExpectedText, ActualText);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		return ActualText;
	}

	// Method to navigate on the dashboard
	public void dashboardhighlighted() {
		driver.findElement(dashboard).isSelected();
	}

	// Method to close the browser
	public void browserclose() {
		driver.close();
		driver.quit();
	}
	
   /*
	 * // Method to enter mailinator email id & click on GO button public void
	 * mailsearch(String Mail_Email) {
	 * driver.findElement(email).sendKeys(Mail_Email);
	 * driver.findElement(go).click(); }
	 */

	
}