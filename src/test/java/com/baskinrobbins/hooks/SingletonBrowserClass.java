package com.baskinrobbins.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonBrowserClass {

	// instance of singleton class
	private static SingletonBrowserClass instanceOfSingletonBrowserClass=null;
	
	
    private WebDriver driver;

    // Constructor
    private SingletonBrowserClass(){
    	System.setProperty("webdriver.chrome.driver","./exefiles/chromedriver.exe");
		driver= new ChromeDriver();
    }

    // TO create instance of class
    public static SingletonBrowserClass getInstanceOfSingletonBrowserClass(){
        if(instanceOfSingletonBrowserClass==null){
        	instanceOfSingletonBrowserClass = new SingletonBrowserClass();
        }
        return instanceOfSingletonBrowserClass;
    }
    
    // To get driver
    public WebDriver getDriver()
    {
    	return driver;
    }
    

   
}


















//package org.tillster.chowking.hooks;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.tillster.chowking.constants.Chowkingconstants;
//import org.tillster.chowking.drivers.Driverfactory;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//
//public class Hooks {
//    
//	WebDriver driver;
//	
//	@Before
//	public void setup() {
//		
//		Driverfactory.intializeBrowser("edge");
//		driver = Driverfactory.getDriver();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.get(Chowkingconstants.url);
//		driver.getTitle();
//
//	}
//	
//	@After
//	public void tearDown() {
//		
//		driver.quit();
//		
//	}
//}

