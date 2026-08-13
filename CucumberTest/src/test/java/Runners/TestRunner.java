package Runners;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
		features="src/test/java/Features",
		glue="StepDefinitions",
		plugin= {"pretty","html:target/cucumber-report.html"},
		monochrome=true		
		)
 
public class TestRunner extends AbstractTestNGCucumberTests{
 
}