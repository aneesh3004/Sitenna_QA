package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		String projectpath = System.getProperty("user.dir"); // generating dynamic project path
		FileInputStream fis = new FileInputStream(projectpath + "/src/test/resources/GlobalProperties.properties");
		Properties prop = new Properties(); // it's use to read the .properties file
		prop.load(fis);// loading the .properties file
		String URL = prop.getProperty("sitennaurl");
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-gpu");
			options.addArguments("--disable-extensions");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--remote-allow-origins=*");  // this i added  this and it worked, Thanks a ton  xinchao zhang !!
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(capabilities);
		    driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
			driver.get(URL);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));			
		}
		
		return driver;
	}
}