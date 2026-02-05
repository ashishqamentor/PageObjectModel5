package greenkartcucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features/greenkart.feature",
		glue = "greenkartcucumber",
		plugin = {"pretty", "html:cucumberReport/greenkart.html",
							"json:cucumberReport/greenkart.json"
				 },
			monochrome = true			
		)

public class testrunner extends AbstractTestNGCucumberTests
{

}
