package io.cucumberfiles.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/cart.feature",   // ✅ your feature file path
        glue = "io.cucumberfiles.steps",// ✅ step definitions package
        plugin = {"pretty","json:target/cucumber.json"},
        monochrome = true,
        dryRun = false
)
public class TestRunner {
}
