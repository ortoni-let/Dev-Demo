package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/java/stories/Login.feature"},
		glue = {"steps", "hooks"},
		dryRun = false,
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		plugin = {"pretty", "html:Reports"},
		tags = {"@smoke, @sanity"}
				)
public class Runner extends AbstractTestNGCucumberTests{
	// 
}
