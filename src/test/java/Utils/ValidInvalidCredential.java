package Utils;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ValidInvalidCredential {

	boolean result;
	boolean res;

	// Method to check credentials are valid or not
	public void isCredentialValidInvalid(String Email, String Password) throws PatternSyntaxException {
		String EmailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pat = Pattern.compile(EmailRegex);
		result = pat.matcher(Email).matches();
		System.out.println(result);
		String PasswordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[_@#$%^&+=])(?=\\S+$).(8,)$";
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
}