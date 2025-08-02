package io.cucumberfiles.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/cart.feature",
        glue = "io.cucumberfiles.steps",
        plugin = {"pretty", "json:target/cucumber.json"},
        monochrome = true,
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
