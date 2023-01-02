package Util;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ValidateLoginPage {

	public String validateloginpage(WebDriver driver) {
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