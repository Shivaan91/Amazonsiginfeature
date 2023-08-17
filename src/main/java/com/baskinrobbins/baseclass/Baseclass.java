package com.baskinrobbins.baseclass;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.baskinrobbins.pages.Cartpage;
import com.baskinrobbins.pages.Loginpage;
import com.baskinrobbins.utils.Configurations;

public class Baseclass {

	public static WebDriver driver;
	public Loginpage loginpage;
	public static SoftAssert softAssertion = new SoftAssert();
	public static JavascriptExecutor js;
	public static Logger log;
	public Configurations config;
	public Cartpage pagee;
	public static ExtentReports reports = new ExtentReports();
	public static ExtentTest test ;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentSparkReporter sparkreporter;
	
	public WebDriver getDriver() {
        return driver;
    }
	
	
}
