package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/features/loged.feature", "src/test/resources/features/login.feature"},  // ✅ folder instead of single file
    glue = "stepdefinitions",
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber.json"
    },
    monochrome = true,
    dryRun = false
    // ✅ removed tags (to avoid no execution issue)
)
public class TestRunnerTest {
}