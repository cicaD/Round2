package cucumberTestRunners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

// This file or class is starting point in to Junit execution of Cucumber tests


@RunWith(Cucumber.class)
@CucumberOptions(
				//features = "Feature",
				//glue={"stepDefinition"}
		features = "SearchProductOnEStoreFeature", // tells which folder feature definitions file is located in relative to project roor
		glue={"searchProductOnEStoreTestStepsDefinition"}  // tells the name of feature step definition file folder
				)


public class TestSearchProductOnEStoreTestRunnerTableInput {

}
