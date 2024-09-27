package com.veeva.assignment.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\main\\resources\\Features\\ui.feature"},
        glue = {"src\\test\\java\\com\\veeva\\assignment\\stepDefinitions"},
        plugin = {"pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/"
        }

)
public class AssignmentRunner {

}
