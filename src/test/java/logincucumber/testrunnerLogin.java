package logincucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features/login.feature",
		glue = "logincucumber",
		plugin = {"pretty", "html:cucumberReport/login.html",
							"json:cucumberReport/login.json"
				 },
			monochrome = true			
		)

public class testrunnerLogin extends AbstractTestNGCucumberTests
{

}
