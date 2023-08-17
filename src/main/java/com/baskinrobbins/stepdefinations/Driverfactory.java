package com.baskinrobbins.stepdefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.baskinrobbins.baseclass.Baseclass;
import com.baskinrobbins.utils.Configurations;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory extends Baseclass {
	public ExtentReports extent;
	public ExtentTest extentTest;

	@Before
	public void setupp() throws Exception {
		config = new Configurations();
		log = LogManager.getLogger(Driverfactory.class.getName());
		Configurator.setRootLevel(Level.INFO);
		System.out.println("Setup completed");
		String browser = config.getBrowser();
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
		ExtentSparkReporter spark = new ExtentSparkReporter("test-output/SparkReport.html");
		reports.attachReporter(spark);
		reports.createTest("ScreenCapture").addScreenCaptureFromPath("extent.png")
				.pass(MediaEntityBuilder.createScreenCaptureFromPath("extent.png").build());
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyReport");
		ChromeOptions option = new ChromeOptions();
		ExtentTest test = new ExtentTest("test-output/SparkReport", "location");
		extent.config().reportName("New Extent Reports");
		test.log(LogStatus.PASS, browser);
		option.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
		option.addArguments("--headless");
		option.addArguments("--lang=en_US");
		option.addArguments("--log-level=1");
		option.addArguments("--disable-gpu");
		option.addArguments("--window-size=1920,1080");
		option.addArguments("--start-maximized");
		option.addArguments("--disable-extensions");
		option.addArguments("--disable-gpu");
		option.addArguments("--no-sandbox");
		option.addArguments("--disable-dev-shm-usage");
		option.addArguments("--no-sandbox");
		option.addArguments("--disable-cache");
		option.addArguments("browser.cache.disk.enable");
		option.addArguments("browser.cache.memory.enable");
		option.addArguments("browser.cache.offline.enable");
		option.addArguments("network.http.use-cache");
		option.addArguments("--disable-backgrounding-occluded-windows");
		option.addArguments("--disable-renderer-backgrounding");
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}
		log.fatal("setup completed");
	}

	@After
	public void teardown(Scenario sc) {
		System.out.println("Tear Down method executed..");
		if (sc.isFailed() == true) {
			String fileWithPath = "//Tillster_Chowking_UI_Framework/test-output/../Screenshots/failedScreenshot.png";
			TakesScreenshot scrShot = ((TakesScreenshot) driver);

			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			File DestFile = new File(fileWithPath);

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		reports.flush();
		driver.quit();
	}

	public void addScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}

	@AfterTest
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getTestName());
		} else {
			test.log(Status.SKIP, result.getTestName());
		}
	}

	public void reportLog(String message) {
		test.getExtent();// For extentTest HTML report
		log.info("Message: " + message);
		Reporter.log(message);

	}

}