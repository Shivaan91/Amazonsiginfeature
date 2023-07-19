package org.tillster.chowking.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driverfactory {
	
	static WebDriver driver;

	public static void  intializeBrowser(String browser) {

		if (browser.equals("Chrome")) {

			driver = new ChromeDriver();
		}

		else if (browser.equals("firefox")) {

			driver = new FirefoxDriver();

		}

		else if (browser.equals("edge")) {

			driver = new EdgeDriver();

		}

	}
	
	public static WebDriver getDriver() {
		
		return driver;
		
	}

}
