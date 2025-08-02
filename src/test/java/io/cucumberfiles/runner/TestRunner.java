package io.cucumberfiles.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/resources/cart.feature",   // ✅ your feature file path
        glue = "io.cucumberfiles.steps",// ✅ step definitions package
        plugin = {"pretty","json:target/cucumber.json"},
        monochrome = true,
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
