package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import util.WebDriverObject;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {"stepdefinitions"},
monochrome = true)
public class TestRunner {
	
	@AfterClass
	public static void tearDown() {
		WebDriverObject.closeDriver();
	}
}
