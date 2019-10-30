package com.acutest.cdaf.testRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // glue location must also contain cucumber hooks class.
        monochrome = true,
        //cucumber = "target/test-classes/cucumber/cucumber/",
        features = "src/test/resources/cucumber/features",
        glue = "com/acutest/cdaf/stepdefs",
        tags = {"@appium-test"},
        plugin = {"pretty", "html:target/cucumber-report/autocorrect"})
public class AppiumRunnerAT {
}
