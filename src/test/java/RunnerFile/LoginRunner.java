package RunnerFile;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
   //path of feature file
   features = "src/test/resources/FeatureFile/LoginFeature.feature",
   //path of step definition file
   glue = "StepDefinition", monochrome = true)
   
public class LoginRunner {
}
