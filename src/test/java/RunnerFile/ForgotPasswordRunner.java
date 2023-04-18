package RunnerFile;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
   //path of feature file
   features = "src/test/resources/FeatureFile/ForgotPasswordFeature.feature",
   //path of step definition file
   glue = "ForgotPasswordSteps", monochrome = true
   )
public class ForgotPasswordRunner {
}
