package com.baskinrobbins.ExtentReporterListner;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.baskinrobbins.baseclass.Baseclass;

import io.cucumber.java.Before;

public class Extentreports extends Baseclass {
	
	public ExtentTest logger;
    public ExtentReports extent;
	
	@Before
	public void generateExtentReports() throws IOException {
				
     ExtentSparkReporter spark = new ExtentSparkReporter("test-output/SparkReport.html");
     htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReports.html");
	 ExtentReports extent = new ExtentReports();
     extent.attachReporter(spark);
     htmlReporter.config().setChartVisibleOnOpen(true);
     htmlReporter.config().setDocumentTitle("Simple Automation Report");
     htmlReporter.config().setReportName("Test Report");
     htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
 }
	
     
}

	
