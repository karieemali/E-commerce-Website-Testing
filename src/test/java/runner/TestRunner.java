package runner;
import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

// this class Running (Features , steps condition)
@CucumberOptions(features = "src/test/java/features",glue = {"steps"},plugin = {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends TestBase
{ }
