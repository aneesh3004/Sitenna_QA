package Utils;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import PageElements.PageObjectManager;

public class TestContxtSetup {
	
	public WebDriver driver;	
	public PageObjectManager pageobjectmanager;
	public TestBase testbase;	
	public GenericUtils genericutils;	
	
	public TestContxtSetup() throws IOException {
		
		testbase = new TestBase();
		pageobjectmanager = new PageObjectManager(testbase.WebDriverManager());
		genericutils = new GenericUtils(testbase.WebDriverManager());		
	}
}
