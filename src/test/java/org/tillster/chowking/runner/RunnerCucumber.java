package org.tillster.chowking.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/org/tillster/chowking/features",
glue = {"org.tillster.chowking.stepdefinations"} ,
plugin = {"pretty","html:target/cucumber-reports/reports_html.html",
		
		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		  
		  "pretty","json:target/cucumber-reports/report_json.json",
		  
		  "pretty", "junit:target/cucumber-reports/report_xml.xml",})

public class RunnerCucumber extends AbstractTestNGCucumberTests {

}
