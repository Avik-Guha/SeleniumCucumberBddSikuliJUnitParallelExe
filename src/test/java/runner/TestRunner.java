package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/feature" }, // feature folder path
		glue = { "steps", "hooks" }, // step definition, hooks folder name
		tags = { "@Login" },
		//	tags = {"@TestFile1 or @TestFile2 or @TestFile3"},
		strict = true,
//		dryRun = true,//to check feature vs step definition mapping is correct
		monochrome = true, // to see console output in a clean manner
		plugin = { "pretty", "html:target/cucumberReports", "json:target/cucumberReports.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter::",
				"timeline:test-output-thread/",
				"de.monochromata.cucumber.report.PrettyReports:test-output",
				"rerun:target/failedRerun.txt"
				})

public class TestRunner {
	

}
