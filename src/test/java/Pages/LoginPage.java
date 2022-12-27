package Pages;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	boolean result;
	boolean res;

	By login_Email = By.id("login_email");
	By login_Password = By.id("login_password");
	By login_btn = By.id("login_button");
	By loginsuccessmessage = By.xpath("//notifier-container[@class = 'notifier__container']");
	By dashboard = By.id("dashboard_menu_item");
	By loginerrormessage = By.xpath("//notifier-container[@class = 'notifier__container']");

	// Constructor to initialize driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Method to enter the email id
	public void enterEmail(String Email) {
		driver.findElement(login_Email).sendKeys(Email);
	}

	// Method to enter the password
	public void enterPassword(String Password) {
		driver.findElement(login_Password).sendKeys(Password);

	}

	// Method to click on login button
	public void clickLogin() {
		driver.findElement(login_btn).click();
	}

	// Method to check credentials are valid or not
	public void isCredentialValidInvalid(String Email, String Password) throws PatternSyntaxException {
		String EmailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pat = Pattern.compile(EmailRegex);
		result = pat.matcher(Email).matches();
		System.out.println(result);
		String PasswordRegex = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[_@#$%]).(8,20)$";
		Pattern p = Pattern.compile(PasswordRegex);
		res = p.matcher(Password).matches();
		System.out.println(res);
	}

	// Method to check credentials are valid
	public void isCredentialValid() {
		if (result == true && res == true) {
			System.out.println("Credentials are valid");
		}
	}

	// Method to check credentials are invalid
	public void isCredentialInvalid() {
		if (result == false && res == false) {
			System.out.println("Credentials are invalid");
		}
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

	// Method to print login error message
	public String loginerror() {
		String ActualText = driver.findElement(loginerrormessage).getText();
		String ExpectedText = "Invalid user login attempt.";
		try {
			Assert.assertEquals(ExpectedText, ActualText);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		return ActualText;
	}

	// Method to close the browser
	public void browserclose() {
		driver.close();
		driver.quit();
	}
}