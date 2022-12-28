package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/featureFiles",
glue = "stepDef", monochrome = true,
plugin= {"pretty","html:target/cucumber","json:target/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
