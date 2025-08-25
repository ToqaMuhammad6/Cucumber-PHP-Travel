package travel.site.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        //glue= "travel/site/"
        glue = {"travel.site.steps", "travel.site.hooks"}

)

public class RunnerTest extends AbstractTestNGCucumberTests {
}
