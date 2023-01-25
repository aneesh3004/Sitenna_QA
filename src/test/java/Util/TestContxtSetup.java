package Util;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import Pages.PageObjectManager;



public class TestContxtSetup {
	
	public WebDriver driver;	
	public PageObjectManager pageobjectmanager;
	public Testbase testbase;	
	public GenericUtils genericutils;	
	
	public TestContxtSetup() throws IOException {
		
		testbase = new Testbase();
		pageobjectmanager = new PageObjectManager(testbase.WebDriverManager());
		genericutils = new GenericUtils(testbase.WebDriverManager());		
	}
}
