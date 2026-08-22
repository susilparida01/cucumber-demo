package runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // Path to the feature files
    glue = {"stepsdefinitions"},              // Package name for step definitions
    plugin = {"pretty", "html:target/cucumber-reports.html"}, // Reporting options
    monochrome = true                       // Makes console output more readable

)
public class TestRunner {
    // This class remains empty
}
