package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;

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