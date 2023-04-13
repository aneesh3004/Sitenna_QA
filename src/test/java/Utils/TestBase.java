package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		String projectpath = System.getProperty("user.dir"); // generating dynamic project path
		FileInputStream fis = new FileInputStream(projectpath + "/src/test/resources/Global.properties");
		Properties prop = new Properties(); // it's use to read the .properties file
		prop.load(fis);// loading the .properties file
		String URL = prop.getProperty("sitennaurl");
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();// from here driver variable get life to invoke the chrome browser
			driver.manage().window().maximize();
			driver.get(URL);
			Actions a = new Actions(driver);
			a.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).build().perform();// to hard refresh the page
			a.keyDown(Keys.CONTROL).sendKeys(Keys.F5).keyUp(Keys.CONTROL).build().perform();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return driver;
	}
}