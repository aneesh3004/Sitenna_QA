package Utils;

import org.openqa.selenium.WebDriver;

public class ValidateLoginPage {
	
	public WebDriver driver;
	TestContxtSetup testContxtSetup;
	ValidateLoginPage validatelogin;
	
	public ValidateLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void validateloginpage() {
		String ActualURL = driver.getCurrentUrl();
		String ExpectedURL = "https://qa.sitenna.com/#/auth/signin";
		if (ActualURL.equals(ExpectedURL)) {
			System.out.println("User is on login page: " +ActualURL);
		} else { 
			System.out.println("User is not on login page");
		}		
	}
}