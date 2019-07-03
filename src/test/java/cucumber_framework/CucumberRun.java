package cucumber_framework;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resource",dryRun = false,strict = true,tags="@Review")


public class CucumberRun {

}
