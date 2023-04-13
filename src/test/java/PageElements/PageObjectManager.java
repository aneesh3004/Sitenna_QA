package PageElements;

import org.openqa.selenium.WebDriver;
import Utils.ValidateLoginPage;

public class PageObjectManager {	
	
	public ForgotPasswordPage forgotpassword;
	public ValidateLoginPage validateloginpage;
	public LoginPage login;
	public WebDriver driver;	
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage getLoginPage() {
		login = new LoginPage(driver);
		return login;
	}
	
	public ForgotPasswordPage getForgotPasswordPage() {
		forgotpassword = new ForgotPasswordPage(driver);
		return forgotpassword;
	}	
}
