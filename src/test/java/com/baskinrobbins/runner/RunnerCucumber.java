package com.baskinrobbins.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/org/tillster/baskinrobbins/features", glue = {
		"com.baskinrobbins.stepdefinations" }, tags =  "@Cart" , plugin = { "pretty",
				"html:target/cucumber-reports/cucumber.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
			    "json:target/cucumber-reports/cucumber.json",
				"pretty", "junit:target/cucumber-reports/report_xml.xml", })

public class RunnerCucumber extends AbstractTestNGCucumberTests {
	

}




