package org.carefulchameleons.stepdefs;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featurefiles"},
        plugin = {"pretty","html:target/testReport.html", "json:target/jsonReport.json"},

        //tags can be used to run tests based on the individual scenarios
        //one scenario at a time

        //tags = "@test1",
        publish = true
)
public class TestRunner { }
