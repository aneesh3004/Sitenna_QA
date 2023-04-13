package Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void tofindchildurlandnumberoftabsopen() throws InterruptedException {
		switchtochild();
		String childurl = driver.getCurrentUrl();
		System.out.println("Child tab url" + childurl);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Number of tabs open in the browser: " + tabs.size());
	}
	
	public void switchtoparent() {
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String parentWindow = i1.next();
		driver.switchTo().window(parentWindow);
	}
	
	public void switchtochild() {
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		String childWindow = i1.next();
		driver.switchTo().window(childWindow);
	}
	
	public void waitForWebelementToAppear(WebDriver driver, WebElement WebElementName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(WebElementName));
	}
	
	public String homepageurl() {
		return driver.getCurrentUrl();
	}
}


