package myRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Selenium workspace\\CucumberBDDSelenium\\pom.xml\\src\\main\\java\\features\\login.feature",
		glue={"stepDefinitions"},
		plugin = {"html:target/cucumber-html-report"}
		)

public class TestRunner {
	
}
