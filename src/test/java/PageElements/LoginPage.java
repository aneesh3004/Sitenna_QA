package PageElements;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.GenericUtils;

public class LoginPage {

	public WebDriver driver;
	public GenericUtils genutils = new GenericUtils(driver);
	
	@FindBy(id = "login_email")
	WebElement login_Email;
	
	@FindBy(id = "login_password")
	WebElement login_Password;
	
	@FindBy(id = "login_button")
	WebElement login_btn;
	
	@FindBy(xpath = "//notifier-container[@class = 'notifier__container']")
	WebElement loginsuccessmessage;
	
	@FindBy(xpath = "//notifier-container[@class = 'notifier__container']")
	WebElement loginerrormessage;
	
	@FindBy(xpath = "//*[@id=\"dashboard_menu_item\"]")
	WebElement dashboard;	
	
	
	// Constructor to initialize driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	// Method to enter the email id
	public void enterEmail(String Email) throws IOException {
		login_Email.sendKeys(Email);		
	}

	// Method to enter the password
	public void enterPassword(String Password) {
		login_Password.sendKeys(Password);
	}

	// Method to click on login button
	public void clickLogin() throws IOException {		
		genutils.waitForWebelementToAppear(driver,login_btn);
		login_btn.click();	
	}

	// Method to print login success message
	public String loginsuccess() throws InterruptedException {
		String ActualText = loginsuccessmessage.getText();
		Thread.sleep(5000);
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
		dashboard.isSelected();
	}

	// Method to print login error message
	public String loginerror() throws InterruptedException {
		String ActualText = loginerrormessage.getText();
		Thread.sleep(5000);
		String ExpectedText = "Invalid user login attempt.";
		try {
			Assert.assertEquals(ExpectedText, ActualText);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
		return ActualText;
	}		
}
