package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepdefinitions", "hooks"},
		plugin = {"pretty", "html:target/cucumber-report/cucumber-employee-report.html"},
		dryRun = false,
		tags = "@regression"
		)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	
	
	
	
	
	

}
