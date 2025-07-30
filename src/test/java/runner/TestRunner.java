package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith; 
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "steps",
        plugin = { 
        "pretty",
        "html:target/cucumber-reports",
<<<<<<< HEAD
        "json:target/cucumber.json"
=======
        "json:target/cucumber.json",
        "message:target/cucumber-messages.ndjson"

        
},
>>>>>>> 2f8cf7f (Test 05)
        
},
        tags = "@Navigation")

public class TestRunner {
        @AfterClass
        public static void cleanDriver() {
                BasePage.closeBrowser();
        }
}