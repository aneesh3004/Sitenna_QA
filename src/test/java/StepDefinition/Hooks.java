package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import Utils.TestContxtSetup;

public class Hooks {

	public TestContxtSetup testContxtSetup;

	public Hooks(TestContxtSetup testContxtSetup) {
		// invoking testContxtsetup in the constructor
		this.testContxtSetup = testContxtSetup;
	}

	@After(order = 0) // it'll close the browser after every scenario
	public void AfterScenario() throws IOException {
		// in this closing the browser after every scenario
		testContxtSetup.testbase.WebDriverManager().quit();
	}

	/*
	 * @AfterStep // for run the bellow screenshot method for every step so it
	 * capture if any test case fails public void AddScreenshot(Scenario scenario)
	 * throws IOException {// method to capture the screenshot for the test failure
	 * WebDriver driver = testContxtSetup.testbase.WebDriverManager();
	 * 
	 * if (scenario.isFailed()) { // screenshot File sourcePath = ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.FILE); byte[] fileContent =
	 * FileUtils.readFileToByteArray(sourcePath); scenario.attach(fileContent,
	 * "image/png", "image"); }
	 * 
	 * }
	 */

	@After(order = 1) // using this to logout the user once the scenario finish
	public void usersignout() throws IOException, InterruptedException {

		Thread.sleep(3000);
		testContxtSetup.testbase.WebDriverManager().findElement(By.xpath(
				"//*[/html/body/app-root/div[1]/app-home/div/mat-drawer-container/mat-drawer/div/div/ul[2]/li[2]/a]")).click();	
		testContxtSetup.testbase.WebDriverManager().findElement(By.linkText("Logout")).click();
		Thread.sleep(3000);
	}
}
