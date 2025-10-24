package io.cucumberfiles.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/buy.feature",
        glue = "io.cucumberfiles.steps",
        plugin = {
                "pretty",
                "html:target/cucumber-reports2.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        },
        monochrome = true,
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {}
